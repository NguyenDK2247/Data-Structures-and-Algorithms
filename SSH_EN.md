# Create ssh key pair

Once you have the repositoyr forked, you need to create a shh key pair.

* Open up a terminal (command prompt).
* If not there already, navigate to the home directory and further to .ssh directory
```console
cd .ssh
```
* If you do not have any existing key pair, or you want new onex for this project, you need to create ones.
```console
ssh-keygen -t ed25519
```
* You can use the default name for the files.
* You can give a password (it is strongly recommended).
* Check that you have 2 new files in the directory
```console
ls
```
or
```console
dir
```
The file ending with .pub is the public key. The oter one, you should not share.
* Open the file ending with .pub with a text editor. You can use whatever text editor you like. This exampel opens it from the terminal with Gedit:
```console
gedit <filename.pub>
```
* Copy the string in the file.
* Go to gitlab to your own repository.
* Go to profile (top-right profile icon) and choose `preferences`.
* On the left side-bar go to ssh keys.
* Paste the copied string into the big box.
* You can give it a name and and expiration date.
* Press `add key`.
* Go back to terminal (command prompt) to check that everything is working.
* Type in the following command:
```console
ssh -T git@gitlab.com
```
* If you set up a password, it should ask for it at this point.
* You should see a welcome message
