Kareem Abbasi

====================
= FILE DESCRIPTION =
====================
1- SpaceShip.java - The class that is responsible for the main methods that each SpaceShip use.
2- SpaceShipFactory.java - The class that is responsible for creating the SpaceShips according to the user input.
3- AggressiveShip.java - The aggressive ship class.
4- BasherShip.java - The Basher ship class.
5- DrunkardShip.java - The Drunk ship class.
6- HumanShip.java - The human ship class.
7- RunnerShip.java - The runner ship class.
8- SpecialShip.java - The Special ship class.
9- README.


==================
=     DESIGN     =
==================

***      GENERAL      ***

The game is designed in a way that allows an easy creation of different ship types that share the same basic functions.
All the ships should implement one method that will change the way they act each round. If a certain ship needs to do
any of the basic methods differently it can do that by overriding the original method.
Each space ship has a set of different variables. None of them can be accessed from outside.
There are also variables that are the same across all the different types.
Only some variables are accessible by all the different types.

*************************

- The SpaceShips:
--------------------
The main SpaceShip class includes the main methods and variables that every SpaceShip in the game uses or has,
such as: The health variable, the energyLevel variable, the fire() methods... etc. These methods don't change
between different types so they are normal methods.

I chose to make the SpaceShip class an abstract class in order to make the doAction() methods - which is called once
per round in every SpaceShip - an abstract method. This forces any class that inherits the SpaceShip class to
implement the doAction() methods or the program won't run. This saves us from making unnecessary errors.

Each types of space ship inherits the SpaceShip class and implements the doAction() methods according to the way
it moves in the game. When inheriting the SpaceShip class, each type of space ship can use the methods and the
variables from the SpaceShip class easily.

Not all the variables from the SpaceShip class can be accessed from its subclasses. The variables that need to be
accessed from the subclasses are protected variables whereas the others are private. This in turns helps protecting
the different variables.

The HumanShip furthermore overrides the getImage() methods, which returns the image of the humna ship. But in
all the other classes uses the implementation found in the SpaceShip class and returns the image of the enemy ship.


- The DrunkardShip:
----------------------
The drunkard ship has variables that represent the probability that the ship performs a certain movement.
Each probability variable is an integer that is between 0 (min) and 100 (max).
Each round the code generates a random number between 0 and 100 and if this number is smaller than the probability
for a certain task, the ship performs that task.


- The SpecialShip:
---------------------
The special ship uses a combination of movements from all the other ships types.
It finds the closest ship to it and the distance between them.

It first checks if it is threatened from the closest ship by checking the distance and the angle between them, it will
try to teleport if it feels threatened.
Then it will try to shoot if it is close to the closest ship.
If it is too close to the closest ship it will turn on its shields. And it will always accelerate and move towards
the closest ship by checking the angle between the two of them.


