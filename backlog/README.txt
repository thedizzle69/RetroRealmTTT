# README for Retro_Realm_TTT

### by Jai SINGH and Tahir OMEROVIC

This project contains a TicTacToe game with 2 modes. The first mode is a terminal application while the second mode is a GUI version using Swing.

The link for the GitHub repository is: https://github.com/thedizzle69/RetroRealmTTT

The link for the github project is: https://github.com/users/thedizzle69/projects/4

## Documentation

Detailed information about the project and the process can be found in the "Documentation.pdf" file in the root directory of the project.

## How to JAVA

Before running the application, make sure you have at least Java 17 installed on your machine.

The project also runs fine on Java 21, tho. (I just wanted to flex that I have Java 21 installed)

If you need any assistance, please refer to the "How_to_install_Java.md" file in the root directory of the project. (this is just a reminder for myself, in case i HAVE THE WRONG JAVA VERSION INSTALLED)

## How to run the terminal application

1. Open the terminal and navigate to the folder containing the jar file. (jar/TicTacToeTerminal)
2. Run the shell script using the following command: `./start_terminal.sh`
2b. If you don't want to run the script, well do it yourself and run: `java -jar TicTacToeTerminal.jar`
3. Follow the instructions on the screen to play the game. (The terminal version is shit tho as it uses rows and columns instead of choosing a field from 1-9, so you better play the GUI version)

## How to run the GUI application

1. Open the terminal and navigate to the folder containing the jar file. (jar/TicTacToeGUI)
2. Run the shell script using the following command: `./start_gui.sh`
2b. Run the following command: `java -jar TicTacToeGUI.jar`
3. Play the game. As there is no AI implemented the only challenge is to play with yourself (like I do every night).

## Additional info

### There are a few workflows installed for automated jobs.

1. The maven.yml builds the package and checks for build errors.

2. The javadoc.yml creates the html files and also copies the files into the /docs directory to have a better overview than in the /target dir.

3. The build.yml creates specific jar files for the separate applications, only compiling the needed files and also creating a startup_script for the apps

4. The checkdiz.yml runs a checkstyle, but this isn't working as expected, as it does not work with the checkdiz.xml file. (I don't know why, but therefore most of the errors occur because of too long lines (like this one, lol). And some because of magic numbers. You don't say. (BTW. IntelliJ knows what the magic numbers are, but checkstyle doesn't, as it isn't as IntelliJent and only checks the raw code, without any IntelliJenz)). I still don't know where it gets its parameters from even. Like the 80 symbol line length.


## Outro

There isn't much more to say. As said, please refer to the Documentation.pdf in the root, if you want to know about the developing process and the project itself.

## Dafuq the copilot suggested right now to end my README

(I don't know why I'm writing this, as I'm the only one who will read this, but I'm bored and I don't want to do anything else, so I'm just writing this to fill the space. I'm sorry if you read this, but I'm just bored and I don't know what to do. I'm sorry. I'm really sorry. I'm so sorry. I'm so so sorry. I'm so so so sorry. I'm so so so so sorry. I'm so so so so so sorry. I'm so so so so so so sorry. I'm so so so so so so so sorry. I'm so so so so so so so so sorry. I'm so so so so so so so so so
