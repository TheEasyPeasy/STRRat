<h1>RAT is shared for research purposes only!</h1>

# STRRat

STRRAT is a Java-based RAT, which makes extensive use of plugins to provide full remote access to an attacker, as well as credential stealing, key logging and additional plugins. The RAT has a focus on stealing credentials of browsers and email clients, and passwords via keylogging. It supports the following browsers and email clients: Firefox, Internet Explorer, Chrome, Foxmail, Outlook, Thunderbird. 

Since Version 1.2 and above, STRRAT was infamous for its ransomware-like behavior of appending the file name extension .crimson to files. Version 1.5 is notably more obfuscated and modular than previous versions, but the backdoor functions mostly remain the same: collect browser passwords, run remote commands and PowerShell, log keystrokes, among others. Version 1.5 of STRRAT Malware includes a proper encryption routine, though currently pretty simple to revert.

source: https://malpedia.caad.fkie.fraunhofer.de/details/jar.strrat

## Rat Deobfuscator

Since STRRat is obfuscated it required from me to write simple decryptor that helped me analyzing more cleaner code.
Decryptor is written in ow2 asm library.

## STRRat

Manually changed class names and methods based on how they work and what they do. Project is IDE ready, just import and run it!


## Screenshots

![alt text](https://i.imgur.com/PrJp3DH.png)


