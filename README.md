Mancala
=======

Group Project for CS151 - Object Oriented Design
TO-DO
=======
1. __Weekly Team Report__
  * Needs to be done asap
1. Update To-Do List  
2. Create **Use Cases**  
3. Create **Clas Diagram**
  * which UML program are we using?
4. Create Sequence Diagram

Project Specifications
=====
![mancala](../useful/board.jpg)
##The Game
The board consists of two rows of pits, each. Three pieces of stones are placed in each of the 12 holes. Each player has a large store called Mancala to the right side of the board. One player starts the game by picking up all of the stones in any one of his own pits. Moving counter-clock wise, the player places one in each pit starting with the next pit until the stones run out. If you run into your own Mancala, place one stone in it. If there are more stones to go past your own Mancala, continue placing them into the opponent's pits. However, skip your opponent's Mancala. If the last stone you drop is your own Mancala, you get a free turn . If the last stone you drop is in an empty pit on your side, you get to take that stone and all of your opponents stones that are in the opposite pit. Place all captured stones in your own Mancala. The game ends when all six pits on one side of the Mancala board are empty. The player who still has stones on his side of the board when the game ends captures all of those pieces and place them in his Mancala. The player who has the most stones in his Mancala wins.

##Requirements and User Interface
`Will:` we could probably do a better job with a start screen.  Like have the ability to select different options from dropdown lists or something.

###Start Screen
* The initial screen of the game displays two buttons to select the style of the board.
* To start the game, the user selects a board style.

###Game Begins
* This game is for two human players. (Taking turns using mouse.)
* Initially the program displays an empty board.
* Ask player to enter number of stones to be placed in each pit of the board.
  * _max number is 4 per pit_
* The two mancala (end pits) will be empty.

###Game Play
* Player selects a pit by clicking on the pit.
 * The program updates according to above specifications.

* The Program offers an undo function for the player.
 * As a button.
 * Only one undo at a time, 3 per turn
 * Example  
 > In the following picture
 (1), suppose the player A selected the pit e. As a result, the state of the board will change to (2). If this player undos, the state of the board goes back to (1). The players can not undo again (that is, pressing the undo button at this moment will not do anything) and has to make a choice of a pit.  
![ex1](useful/ex1.png)

###Design
Use the __MVC__ pattern.  A view (a pit) can also serve as a controller to take user input.  
The Program can have multiple styles.  
* Shape and color of pits  
* Use the __Strategy__ pattern for different styles.  



##Weekly Team Report
__Team Leaders__
The team leader will submit a hard copy of weekly team report in class on the given due date.

| Due| Week        | Team Member | Submitted |
|----|:-----------:|:-----------:| ---------:|
|4/8 | 4/1 - 4/7   | Avi         | No        |
|4/15| 4/8 - 4/14  | Michael     | No        |
|4/23| 4/15 - 4/21 | Will        | No        |
|4/29| 4/22 - 4/28 | Avi         | No        |

__Everyone__ is responsible for individual reports, the group leader will collect individual reports and write a weekly team report.  
__Individual Reports__
+ One or two lines for each day stating
 1. How many hours you worked on the project. (If 0, then 0)
 2. What did you do?  

 > `Sample Individual Weekly Report:`  
 Name:  
 T: 4/1  
W: 4/2  
R: 4/3  
F: 4/4  
M: 4/7  
For each day, write one or two lines about what you did and how long it took.
If if you didn't do any project on a particular day, leave the line blank.

__Team Report__
+ The team leader writes no more than 10 lines of summary stating:
 1. Weekly achievements.
 2. Issues that need to be resolved next week.

 >`Suggested format of the summary report:`  
 __Tuesday 4/1 ~ Monday 4/7__  
 __Team Name__: goes here !  
 __Team leader of the week__: A  
 __Team members__: A, B, and C  
 __Summary__ (written by the team leader)  
 // about 10 lines go here.  
 __Student A__'s name  
 __Student A__'s individual weekly report here.  
 __Student B__'s name  
 __Student B__'s individual weekly report here.  
 __Student C__'s name  
 __Student C__'s individual weekly report here.  

*No e-mail or late submission will be accepted.*

##__Project Outcomes__
__Each team submits a final report__ that includes:
1. Class diagram  
2. Use cases  
3. Sequence diagram  
4. One page of paper that includes answers for the following questions  
  1. Which materials/key concepts from this course did you apply on the project?  
  2. Which topics did you have to learn through self-study in order to complete the project?

5. Participate in the google survey regarding this project. The web site will be announced as soon as it is ready. The participation will be counted towards your credit.  

 __One set of soft copy per team__
 + All source code must be thoroughly __documented by Javadoc.__ That is, each file should have Javadoc comments for the file (including author information), classes, and methods.
 + Include all .java files in project.zip, and submit it through the web site (which will be ready by then) on the course web site.

Each member has to fill the [peer evaulation](http://www.cs.sjsu.edu/~kim/cs151/contents/project/peer_eval.html) form and bring it to the demo session, which will be scheduled at the end of the semester.

##__Due Dates__

__Soft Copy__ May 3, Saturday at 11:59 pm  
> Through submission link on the course website

__Final Report__ May 5, Monday
>In front of my office. (A box will be prepared to put your report on Monday May 5, 9:00 am - 4:00 pm. I have to leave at 2:00 pm sharp and the box will be collected right before I leave. No late submission will be considered. If you want to submit it early, slide the report under the door of my office.)
