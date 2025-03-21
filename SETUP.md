# TIRA/DSA-2024 Setup

This readme instructs you on:

1. creating an account in GitLab.
1. forking and cloning your own private git repository to work with.

Here we assume you have already installed the [tools of the course](TOOLS.md).


## GitLab 

You will need **an account** at [GitLab](https://gitlab.com). All exercises and course projects are delivered through GitLab. 

You must fork this repository and deliver all your course work through that forked private repository.

More information about how to use git and GitLab in the course is provided elsewhere. If this file is located now on your own PC, you should have gotten this project by a) forking the course repository to a private repository of your own, and then b) cloning it to your PC. Instructions on how to do that is provided below.

You also **must fill in the Moodle form** where you specify the requested information about you and your repository. That data is used by our automatic scripts to fetch your repository for testing and grading at the end of the course. Without this information, we won't test and grade your work. The number of students on this course is so high that automation is a necessity, and without the data the scripts cannot handle your work.


## How to set up your workspace

The instructions assume you are reading this from the GitLab web page of the course repository.

First step is to fork the course project in GitLab and clone it to your own PC, assuming you are reading this from the web pages of the course repository. The course Moodle workspace has instructions for you how to do all this, so **check out that first**.

This step is done only *once* assuming you will work from one PC throughout the course. After executing the steps below, you have the project on your PC. Later you will add and change files in the local project, commit the changes and when needed, update the remote repository from your local repository.

1. Create the ssh keys and provide the public key to GitLab.
1. Login to your GitLab account and access this TIRA course project repository. URL is provided in the course Moodle workspace. Though if you are reading this, you probably have that URL already :)
1. **Fork** the project from the repository web page. You will get your own forked copy of the repository in GitLab.
1. From the forked project settings, **make** your project **private**.
1. **Add the course teachers** to your private repository with **Developer** access level. Teachers need access to help you solve issues in the exercises and grade your work in the course. No one else than you and the teachers should have access to the forked private repository of yours.
1. **Open the command prompt** (terminal window) on your PC.
1. **Navigate** to a directory you want to place your *local cloned* repository. Select a directory path with *no spaces nor special characters* in the directory names. Some tools do not like these at all. All work done in the course will be located in this directory.
1. **Clone** your private remote repository to your PC using the ssh URL: `git clone <ssh-url-to-your-remote-private-forked-repository>`. If you used password to protect your ssh private key, enter the ssh key password at this point (*not* the password to GitLab.com). Enter the private repository URL after `clone` without the "< >" characters -- just the URL to the repository.
1. You should have now a **local repository**, a "copy" of your remote private repository, on your PC. 

In the terminal, list the contents of the directory (`dir` on Windows, `ls` on Unixes). Browse the subdirectories and files to study what is included. 

> Do *not* accidentally delete or move anything here! If you mess this local project and the work you have done has not yet been committed to local repository or pushed to the remote private repository of yours, the work is *lost*.

Each exercise and the course projects are now on your local PC. Study them and start working with them following the timing below, and further instructions from the teachers.

## About

* Course material for Tietorakenteet ja algoritmit | Data structures and algorithms 2024.
* Study Program for Information Processing Science, University of Oulu.
