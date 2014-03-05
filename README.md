HashPass
========

Hash Pass allows a user to input a password or any text and generate a hash from it. 

Generally a secure password is hard to remember so users tend to opt for easy to remember passwords. These passwords are also easy to crack. 
This app aims to address that by allowing the user to use hashes in place of their passwords on various sites.

Example: a user may have a password such as "computer" (a bad one) that would be easily cracked in a dictionary attack.

Where as the md5 hash generated from computer is
df53ca268240ca76670c8566ee54568a which is not easy to guess or dictionary attack.

There are currently four algorithms available in the app. MD5 , SHA1 , SHA256 & SHA512.

This allows the user to use the same password for four different sites and a different hash for each.

For your banking or email you could use the SHA512 hash of your chosen password . In the computer example the hash is

922d076069b1df893fc010b7a6d2aa55c7c4c5d194f163394a4c864de5754131c17bfa94ac1667f56b5181cc7eca5dc3a09444caee6eecf16114926bb29f7e79

The hashes are automatically copied to the clipboard for convenience. This allows you to paste it into an app easily.

If a database is compromised which is insecurely storing the passwords and your passwords (your generated hash) was obtained . 
The other three sites (with different hashing algorithms) would be safe.

Using hashes as passwords also makes an attack more computationally expensive as each string has to be hashed first before submitting it as the password.



# Whats next ?
I have removed the ads and made some small changes to the UI but for now it is the same version as is in the play store.
https://play.google.com/store/apps/details?id=byrne.utilities.hashpass 

I plan to add the app to the fdroid repository in the future. 
