# Keep your Gitlab repo in sync with the main repo

In order to keep your Gitlab repo in sync with the main repo that you forked your exercies from, the following instructions need to be executed.

## Setting up the upstream in git
In your terminal, navigate to the root directory of the exercises (dsa-dice-2024).

Enter the following command:
```shell
git remote add upstream https://gitlab.com/a.b.z.m/dsa-dice-2024.git
```

Note: the previous command needs to be entered only once! It means, whenever you want to keep your repo in sync with the upstream, you don't need to run the previous command every time.


## Keeping your local repo in your personal computer for the exercies in sync with the upstream

In order to keep your local repo in sync with the upstream, run the following command:

```shell
git pull upstream main
```

## Keeping your Gitlab repo in sync with your local repo

To reflect back the updated files into your remote repo in Gitlab, run the following command:

```shell
git push
```

Note: `git pull upstream main` and `git push` are needed to be executed every time you want to keep your local files in sync with the upstream.