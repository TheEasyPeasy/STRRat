import org.apache.commons.io.IOUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Main {

    private static ConcurrentHashMap<String, ClassNode> classes = new ConcurrentHashMap<>();


    public static void main(String[] args) throws Exception {
        final File f = new File("c7ed1cec47b5f8d575e739d4c77d86a6222a64539e5870229fc4488bb0b50b05.jar");
        final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File("rat-out.jar")));
        ZipFile zipFile = new ZipFile(f);
        List<ZipEntry> classEntries = new ArrayList<>();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.getName().contains(".class")) {

                try {
                    byte[] b = IOUtils.toByteArray(zipFile.getInputStream(entry));
                    byte[] newBytes = new byte[b.length - 1];
                    ClassReader cr = null;
                    if (b[0] == (byte) 1) {
                        System.out.println(entry.getName());
                        for (int i = 0; i < b.length; i++) {
                            newBytes[i] = b[i + 1];
                            newBytes[i] = (byte) (newBytes[1] ^ 205 ^ entry.getName().toCharArray()[0] ^ entry.getName().toCharArray()[1]);
                            if (i == 0) {
                                System.out.println(b[i + 1]);
                            }
                        }
                        cr = new ClassReader(newBytes);
                    } else {
                        cr = new ClassReader(IOUtils.toByteArray(zipFile.getInputStream(entry)));
                    }
                    ClassNode cn = new ClassNode();
                    cr.accept(cn, 0);
                    ClassWriter cw = new ClassWriter(0);
                    cn.accept(cw);
                } catch (Exception e) {

                }
                classEntries.add(entry);
            } else {
                ZipEntry zipEntry = new ZipEntry(entry.getName());
                zos.putNextEntry(zipEntry);
                InputStream is = zipFile.getInputStream(entry);
                byte[] buf = new byte[1];
                int len;
                while ((len = (is.read(buf))) > 0) {
                    zos.write(buf);
                }
            }
            zos.closeEntry();
        }

        classEntries.forEach(ce -> {
            try {
                InputStream inputStream = zipFile.getInputStream(ce);
                ClassReader cr = new ClassReader(inputStream);
                ClassNode cn = new ClassNode();
                cr.accept(cn, 0);
                ClassWriter cw = new ClassWriter(0);
                cn.accept(cw);
                classes.putIfAbsent(cn.name, cn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        classes.forEach((name, clz) -> {
            for (Object method : clz.methods) {
                final MethodNode methodNode = (MethodNode) method;
                if(methodNode.instructions.size() < 0) {
                    continue;
                }
                for(AbstractInsnNode instr : methodNode.instructions.toArray()) {
                    if(instr instanceof LdcInsnNode && ((LdcInsnNode)instr).cst instanceof String) {
                        if(instr.getNext() == null) {
                            continue;
                        }
                        if(instr.getNext().getOpcode() != Opcodes.INVOKESTATIC) {
                            continue;
                        }
                        if(!(instr.getNext() instanceof MethodInsnNode)) {
                            continue;
                        }
                        final MethodInsnNode decryptMethodNode = (MethodInsnNode) instr.getNext();
                        if(!decryptMethodNode.desc.equals("(Ljava/lang/String;)Ljava/lang/String;")) {
                            continue;
                        }
                        //System.out.println("method: " + decryptMethodNode.name + " calling " + decryptMethodNode.owner + " in class: " + clz.name);

                        //get 2 xors
                        int xorOne = 0;
                        int xorTwo = 0;
                        final ClassNode decryptorMethodClass = classes.get(decryptMethodNode.owner);
                        if(decryptorMethodClass == null){
                            throw new RuntimeException("Can not find decryptor method class!");
                        }
                        boolean found = false;
                        for (Object decryptorMethodNode : decryptorMethodClass.methods) {
                            final MethodNode mn = (MethodNode) decryptorMethodNode;
                            if(mn.name.equals(decryptMethodNode.name) && mn.desc.equals(decryptMethodNode.desc)) {
                                found = true;
                                boolean foundFirst = false;
                                for(AbstractInsnNode decFunInstr : mn.instructions.toArray()) {
                                    if(decFunInstr.getOpcode() == Opcodes.IXOR && decFunInstr.getPrevious() != null) {
                                        if(!foundFirst) {
                                            xorOne = getPushedInt(decFunInstr.getPrevious());
                                            foundFirst = true;
                                            continue;
                                        }
                                        xorTwo = getPushedInt(decFunInstr.getPrevious());
                                    }
                                }
                            }
                        }
                        if(!found) {
                            throw new RuntimeException("Can not find decrypt method in given class! " + decryptorMethodClass.name);
                        }
                        //System.out.println("Found xor numbers " + xorOne + " and " + xorTwo + " for " + methodNode.name);
                        LdcInsnNode ldcInsnNode = (LdcInsnNode) instr;
                        final String encrypted = (String) (ldcInsnNode).cst;
                        final String decrypted = decryptorTemplate(encrypted, xorOne, xorTwo);
                        System.out.println("Decrypted string: " + decrypted);
                        ldcInsnNode.cst = decrypted;
                        methodNode.instructions.remove(instr.getNext());
                    }
                }
            }
        });

        for (Map.Entry<String, ClassNode> entr : classes.entrySet()) {
            ClassWriter cw = new ClassWriter(0);
            entr.getValue().accept(cw);
            zos.putNextEntry(new ZipEntry(entr.getValue().name + ".class"));
            zos.write(cw.toByteArray());
        }
        zos.close();

    }

    public static String decryptorTemplate(String var0, final int xorOne, final int xorTwo) {
        int var10000 = (var0 = (String)var0).length();
        char[] var10002 = new char[var10000];
        int var2;
        var10000 = var2 = var10000 - 1;

        char[] var1;
        for(var1 = var10002; var10000 >= 0; var10000 = var2) {
            int var10001 = var2;
            char var6 = var0.charAt(var2);
            --var2;
            var1[var10001] = (char)(var6 ^ xorOne);
            if (var2 < 0) {
                break;
            }

            int var5 = var2--;
            var1[var5] = (char)(var0.charAt(var5) ^ xorTwo);
        }

        return new String(var1);
    }

    public static int getPushedInt(AbstractInsnNode insn) {
        int op = insn.getOpcode();
        if (op >= Opcodes.ICONST_M1 && op <= Opcodes.ICONST_5) {
            return op - Opcodes.ICONST_0;
        }
        if (op == Opcodes.BIPUSH || op == Opcodes.SIPUSH) {
            return ((IntInsnNode) insn).operand;
        }
        if (op == Opcodes.LDC) {
            Object cst = ((LdcInsnNode) insn).cst;
            if (cst instanceof Integer) {
                return (int) cst;
            }
        }
        throw new IllegalArgumentException("insn is not a push int instruction");
    }

}
