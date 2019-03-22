# Calcutaor

Simple Calculator project in JavaFX, using this project for playing around with some features of Java, JavaFX, Scene Builder.
Inspiration for this project came from variouse places like Windows 10 and Android Calculators. My goal was to replicate functionalities of those calculators and add some of of my own.

## Authors

* **Darek**  - [DaRoTP](https://github.com/DaRoTP)

## What can it do ?
* It can perform all of the actions that a basic calculator can and more, to name a few it can calculate sin, cos, tan, ctg, convert to hexadecimal, octal and binary...
* **Change-Themes** - to do so you use a choice-box on the top right corner, select a theme of your choice and it changes style sheet to the one you have chosen.
* **Night-Mode** - it's a toggle-button located on the left top side of the window which after activating changes style sheet to *THEME DARK* and after deactivating changes back to a previously selected theme.
* **Extended-mode** - it's a button located on the left top side of the window, right to the *Night-Mode*, after activating the button it switches to a different scene with more funtions like sin,cos,hex,dec... Clicking the button again will return window to standard scene that we see when we launch the application.


## I've learned to...
* use choice-boxes - to access selected items and manipulate them.
* switch between scenes.
* use different style sheets and change them when program is running.
* use an event handler.
* use a listener.

## Bugs
* When changing theme in *standard mode* then switching to *extended* and changing theme again for example to *default*, stacks two style sheets together ( you can see it when switching from *DEEP PINK* to *DEFAULT*)
* TBD (to be discovered)

## Tools used to build this 

* JavaFX Scene Builder 8.5.0
* Java Version 8 (build 1.8.0_201-b09)
