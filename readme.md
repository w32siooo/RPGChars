# Console application in Java

This is a backend for an RPG game.

## Objectives: 

Demonstrate usage of object-oriented programming techniques. Such as polymorphism implemented with interfaces and inheritance.   

## How to run: 

As this is just a backend project, the only way it is "meant" to be run is through it's tests folder. Simply run all the unittests in the tests folder, and verify that the program works as intended. 

### Notes:

I seperate each inventory slot into it's own class. That's why there is no generic armor class. This is also to avoid the possibility of characters trying to equip armors as weapons. Armors and weapons are clearly seperated using type specific interfaces that are defined by ENUM's. 

### UML Diagram:
![RPGCharacters](https://user-images.githubusercontent.com/47818670/133057288-51ce9edd-7079-42a5-8954-12f0df0b4b02.jpg)
