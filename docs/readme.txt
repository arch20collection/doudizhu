# Doudizhu
## Members
Hairong Chen, Qiran Sun, Yichen Li, Zhaolong Lin
## Overview
This project is an implementation of a popular Chinese card game: Doudizhu.
The game features easy-to-learn rules that are hard to master, requiring mathematical
and strategic thinking as well as carefully planned execution.
The game is played among three people with one pack of cards (54 count), including the
two differentiated jokers. It starts with each player bidding for the "landlord" position.
Those who lose the bid or do not bid enter the game as the "peasants" team competing
against the landlord. For each player, the objective of the game is to be the first one
to have no cards left.
The game starts with the landlord. In each round, each player must be able to show a deck
of a certain pattern in turn. A player with no available cards to show could choose to
skip in the round. If both 2 other players are skipped for a pattern shown by a player,
the game enters another round starting with that player.

## Prerequisite
JDK 14.0.3 or higher
JRE 14.0.3 or higher
GUI support, non-headless mode

## File path
root
|
|-docs
|  |
|  |-README.txt
|  |
|  |-<generated javadoc files>
|
|-output
|
|-scripts
|  |
|  |-run.sh
|  |
|  |-run.cmd
|
|-src
|  |
|  |-main
|  |  |
|  |  |-*.java
|  |
|
|-temp
|
|-tests
   |
   |-tests.pdf

## Logistics
* Application: main program
* Card: ADT of a card
* CardPanel: JPanel for showing a deck of cards, used for presenting current deck and player's own deck
* CardView: JButton for visualization of a card
* Client: class for server
* ControlToolBar: JToolBar for sending cards/skipping
* Deck: ADT of a card deck
* MainBody: main UI
* Message: ADT of a serializable message for server-client communication
* OpponentStatusBar: JPanel of two OpponentStatusPanel
* OpponentStatusPanel: JPanel of an opponent's status
* Player: ADT of a player
* Server: class of server
* StartPanel: JPanel for starting/connecting a server

## Usage
### Compilation and Javadoc
#### Linux/macOS
Execute ./scripts/run.sh in shell to compile and run the program.
#### Windows
Execute .\scripts\run.cmd in command prompt to compile and run the program.

The program will run automatically after compilation. User will be prompted
to click "ready" to notify the server. Game starts in turn when all users are ready,
allowing each player to choose cards and send. As one user sends out all his/her cards,
game terminates by announcing the winning player.

## Test
Please read ./docs/test.pdf for more details.