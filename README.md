# Dungeons and Object Oriented Dragons
This is a silly, "Dungeons and Dragons" inspired game. It is primarily an exercise in using common Object Oriented Programming concepts (OOP) such as abstract classes, interfaces and inheritence. In this game, the user can creates a PlayerCharacter (PC) in the form of a knight that is used to fight against NonPlayerCharacters (NPCs) in the form of monsters.<br />

## Table of Contents
**[How to Run this Program](#how-to-run-this-program)**  
**[Running the program](#running-the-program)**  
**[Examples of readability analyses](#examples-of-readability-analyses)**<br /> 

## How to Run this Program
### Downloading
You can download an executable *.jar file from here:<br />
https://github.com/mikeuf/dungeons-and-oo-dragons/raw/master/dist/dungeons-and-oo-dragons.jar<br />
<br />
You may receive a message from your browser stating that the program is "not commonly downloaded and may be dangerous," or something to this effect. Your browser should give you the option to either discard or keep the file.
### Running
Start the program from a command line, using this syntax:<br />
**java -jar DungeonsAndObjectOrientedDragons.jar**<br />
<br />
**Note:** You will need a recent version of the Java Runtime Environment (JRE) to run this program.

Characters can either be PlayerCharacters (PCs) or NonPlayerCharacters (NPCs). In this game, the NPCs are monsters that will be generated for the PC, controlled by the player, to fight.<br />
 
All characters can defend against attacks from other characters. Depending on the defenseLevel of their armor, they can block a portion of the attack or cause the attacker to miss entirely.<br />

## Class Design
**Figure 1 - Class Diagram**
![Class diagram](https://github.com/mikeuf/dungeons-and-oo-dragons/blob/master/images/class-diagram.jpg "Class diagram")

## Typical Output
**Figure 2 - Interactively creating a knight**
```
Welcome to Dungeons and Object Oriented Dragons!
You are a brave knight who is about to enter the Dungeon of Infinite Loops.

Choose one of the following:
1) Interactively create a new knight
2) Automatically generate a new knight

Your choice, my liege? 
1

Enter the name of your knight: 
Sir Mike

Select your weapon! (Choose number):
1) Long Sword
2) Battle Axe
3) Nunchuks

Your choice my liege?: 
1

Select your armor! (Choose number):
1) Chain Mail
2) Plate Armor
3) Mithril Coat

Your selection, sire?: 
1

Your knight has been created! Here are your stats:
Name: Sir Mike
Health: 47
Age: 48
Gold: $59
Weapon: Long Sword
Armor: Chain Mail

How many monsters would you like Sir Mike to fight?
3

Now entering the dungeon...

Sir Mike is bravely iterating through the Dungeon of Infinite Loops when
a dreaded Hobgoblin leaps out from the darkness, brandishing a Cast Iron Skillet.

*** Monster Stats ***
Name: Hobgoblin
Health: 11
Gold: $80
Weapon: Cast Iron Skillet
Armor: Trash Can Lid for a Breastplate, Suspended with Bungee Cords

*** Starting Round 1 ***
Press "c" to continue the battle...
c

The Hobgoblin assails Sir Mike with its Cast Iron Skillet, causing 3 damage!

Sir Mike swings at the Hobgoblin with his Long Sword, causing 4 damage!

*** New Health Levels ***:
Sir Mike: 44 
Hobgoblin: 7 

*** Starting Round 2 ***
Press "c" to continue the battle...
c

The Hobgoblin assails Sir Mike with its Cast Iron Skillet, causing 4 damage!

Sir Mike swings at the Hobgoblin with his Long Sword, causing 2 damage!

*** New Health Levels ***:
Sir Mike: 40 
Hobgoblin: 5 

*** Starting Round 3 ***
Press "c" to continue the battle...
c

The Hobgoblin assails Sir Mike with its Cast Iron Skillet, causing 1 damage!

Sir Mike swings at the Hobgoblin with his Long Sword, causing 10 damage!

The Hobgoblin hath been slain by Sir Mike! It had 80 gold coins which Sir Mike is now pocketing.
Sir Mike now has 139 gold coins.

Sir Mike is bravely iterating through the Dungeon of Infinite Loops when
a dreaded Bugbear leaps out from the darkness, brandishing a Really Big Fly Swatter.

*** Monster Stats ***
Name: Bugbear
Health: 23
Gold: $65
Weapon: Really Big Fly Swatter
Armor: Hefty Garbage Bag, with Holes Cut Out for Arms

*** Starting Round 1 ***
Press "c" to continue the battle...
c

The Bugbear assails Sir Mike with its Really Big Fly Swatter, causing 5 damage!

Sir Mike swings at the Bugbear with his Long Sword, causing 4 damage!

*** New Health Levels ***:
Sir Mike: 34 
Bugbear: 19 

*** Starting Round 2 ***
Press "c" to continue the battle...
c

The Bugbear assails Sir Mike with its Really Big Fly Swatter, and misses!

Sir Mike swings at the Bugbear with his Long Sword, causing 5 damage!

*** New Health Levels ***:
Sir Mike: 34 
Bugbear: 14 

*** Starting Round 3 ***
Press "c" to continue the battle...
c

The Bugbear assails Sir Mike with its Really Big Fly Swatter, causing 4 damage!

Sir Mike swings at the Bugbear with his Long Sword, causing 4 damage!

*** New Health Levels ***:
Sir Mike: 30 
Bugbear: 10 

*** Starting Round 4 ***
Press "c" to continue the battle...
c

The Bugbear assails Sir Mike with its Really Big Fly Swatter, causing 6 damage!

Sir Mike swings at the Bugbear with his Long Sword, causing 12 damage!

The Bugbear hath been slain by Sir Mike! It had 65 gold coins which Sir Mike is now pocketing.
Sir Mike now has 204 gold coins.

Sir Mike is bravely iterating through the Dungeon of Infinite Loops when
a dreaded Dragon leaps out from the darkness, brandishing a Snoutful of Flames.

*** Monster Stats ***
Name: Dragon
Health: 36
Gold: $828
Weapon: Snoutful of Flames
Armor: Enchanted Hide

*** Starting Round 1 ***
Press "c" to continue the battle...
c

The Dragon assails Sir Mike with its Snoutful of Flames, causing 8 damage!

Sir Mike swings at the Dragon with his Long Sword, causing 2 damage!

*** New Health Levels ***:
Sir Mike: 16 
Dragon: 34 

*** Starting Round 2 ***
Press "c" to continue the battle...
c

The Dragon assails Sir Mike with its Snoutful of Flames, causing 9 damage!

Sir Mike swings at the Dragon with his Long Sword, causing 5 damage!

*** New Health Levels ***:
Sir Mike: 7 
Dragon: 29 

*** Starting Round 3 ***
Press "c" to continue the battle...
c

The Dragon assails Sir Mike with its Snoutful of Flames, causing 2 damage!

Sir Mike swings at the Dragon with his Long Sword, causing 10 damage!

*** New Health Levels ***:
Sir Mike: 5 
Dragon: 19 

*** Starting Round 4 ***
Press "c" to continue the battle...
c

The Dragon assails Sir Mike with its Snoutful of Flames, causing 8 damage!

Oh no! Sir Mike has been vanquished in battle.
The Dragon makes off with Sir Mike's 204 gold coins and donates them to a charity that supports
underprivileged Dragons of Middle Earth.

Play again? (y/n): 

Exiting program. I wish you good fortune in the wars to come...
```
<br />
<br />
<br />

**Figure 3 - Automatically creating a knight**



```
Welcome to Dungeons and Object Oriented Dragons!
You are a brave knight who is about to enter the Dungeon of Infinite Loops.

Choose one of the following:
1) Interactively create a new knight
2) Automatically generate a new knight

Your choice, my liege? 
2

Your knight has been created! Here are your stats:
Name: Sir Loin
Health: 35
Age: 28
Gold: $83
Weapon: Nunchuks
Armor: Mithril Coat

How many monsters would you like Sir Loin to fight?
2

Now entering the dungeon...

Sir Loin is bravely iterating through the Dungeon of Infinite Loops when
a dreaded Dragon leaps out from the darkness, brandishing a Snoutful of Flames.

*** Monster Stats ***
Name: Dragon
Health: 26
Gold: $755
Weapon: Snoutful of Flames
Armor: Enchanted Hide

*** Starting Round 1 ***
Press "c" to continue the battle...
c

The Dragon assails Sir Loin with its Snoutful of Flames, and misses!

Sir Loin swings at the Dragon with his Nunchuks, causing 1 damage!

*** New Health Levels ***:
Sir Loin: 35 
Dragon: 25 

*** Starting Round 2 ***
Press "c" to continue the battle...
c

The Dragon assails Sir Loin with its Snoutful of Flames, causing 7 damage!

Sir Loin swings at the Dragon with his Nunchuks, and misses!

*** New Health Levels ***:
Sir Loin: 28 
Dragon: 25 

*** Starting Round 3 ***
Press "c" to continue the battle...
c

The Dragon assails Sir Loin with its Snoutful of Flames, causing 1 damage!

Sir Loin swings at the Dragon with his Nunchuks, causing 6 damage!

*** New Health Levels ***:
Sir Loin: 27 
Dragon: 19 

*** Starting Round 4 ***
Press "c" to continue the battle...
c

The Dragon assails Sir Loin with its Snoutful of Flames, and misses!

Sir Loin swings at the Dragon with his Nunchuks, and misses!

*** New Health Levels ***:
Sir Loin: 27 
Dragon: 19 

*** Starting Round 5 ***
Press "c" to continue the battle...
c

The Dragon assails Sir Loin with its Snoutful of Flames, causing 2 damage!

Sir Loin swings at the Dragon with his Nunchuks, causing 18 damage!

*** New Health Levels ***:
Sir Loin: 25 
Dragon: 1 

*** Starting Round 6 ***
Press "c" to continue the battle...
c

The Dragon assails Sir Loin with its Snoutful of Flames, causing 6 damage!

Sir Loin swings at the Dragon with his Nunchuks, causing 9 damage!

The Dragon hath been slain by Sir Loin! It had 755 gold coins which Sir Loin is now pocketing.
Sir Loin now has 838 gold coins.

Sir Loin is bravely iterating through the Dungeon of Infinite Loops when
a dreaded Bugbear leaps out from the darkness, brandishing a Really Big Fly Swatter.

*** Monster Stats ***
Name: Bugbear
Health: 19
Gold: $215
Weapon: Really Big Fly Swatter
Armor: Hefty Garbage Bag, with Holes Cut Out for Arms

*** Starting Round 1 ***
Press "c" to continue the battle...
c

The Bugbear assails Sir Loin with its Really Big Fly Swatter, causing 7 damage!

Sir Loin swings at the Bugbear with his Nunchuks, causing 6 damage!

*** New Health Levels ***:
Sir Loin: 12 
Bugbear: 13 

*** Starting Round 2 ***
Press "c" to continue the battle...
c

The Bugbear assails Sir Loin with its Really Big Fly Swatter, and misses!

Sir Loin swings at the Bugbear with his Nunchuks, causing 1 damage!

*** New Health Levels ***:
Sir Loin: 12 
Bugbear: 12 

*** Starting Round 3 ***
Press "c" to continue the battle...
c

The Bugbear assails Sir Loin with its Really Big Fly Swatter, causing 1 damage!

Sir Loin swings at the Bugbear with his Nunchuks, causing 18 damage!

The Bugbear hath been slain by Sir Loin! It had 215 gold coins which Sir Loin is now pocketing.
Sir Loin now has 1053 gold coins.

Play again? (y/n): n

Exiting program. I wish you good fortune in the wars to come...
```



