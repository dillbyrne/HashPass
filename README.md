HashPass
========

A simple andorid application to address the recall verses recognition problem with passwords. Since hashing algorithms have deterministic outputs we can take advantage of this and use it for generating secure alphanumeric passwords from an input that is easy to remember and familiar to the user.

Example: a user may have a password such as `computer` (a bad one) that would be easily cracked in a dictionary attack.

Where as the md5 hash generated from computer is `df53ca268240ca76670c8566ee54568a` which is not easy to guess or dictionary attack. The input "computer" is also easy for the user to remember and will always produce the same output.

Many non technical users use the same password for different sites (not recommended). In this case they can at least choose a different hash and have up to four levels of security for each input.

For your banking or email you could use the SHA512 hash of your chosen password . Continuing with the `computer` example above the hash is

`922d076069b1df893fc010b7a6d2aa55c7c4c5d194f163394a4c864de5754131c17bfa94ac1667f56b5181cc7eca5dc3a09444caee6eecf16114926bb29f7e79`


## Features

* Four available algorithms
  * MD5
  * SHA1
  * SHA256
  * SHA512
* Hashes are automatically copied to clipboard for convienience 
* Clipboard is cleared after a user chosen interval

## Screenshots

![screenshot_2016-04-07-22-37-39](https://cloud.githubusercontent.com/assets/2903711/14405595/3baccf64-fe8a-11e5-9269-4a52c0a7cf65.png)
![screenshot_2016-04-07-22-38-01](https://cloud.githubusercontent.com/assets/2903711/14405593/3baaa1ee-fe8a-11e5-90b7-d162c3cfd686.png)



## Links

I have removed the ads and made some small changes to the UI to make use of the holo theme in kitkat but functionally it is the same version as is in the play store. The F-Droid version will always be the most up to date

https://f-droid.org/repository/browse/?fdfilter=bodha&fdid=byrne.utilities.hashpass

https://play.google.com/store/apps/details?id=byrne.utilities.hashpass 

## Firefox addon 

https://addons.mozilla.org/en-US/firefox/addon/hashpass-firefox/

