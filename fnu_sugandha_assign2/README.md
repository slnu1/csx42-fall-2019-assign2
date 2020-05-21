# CSX42: Assignment 2
## Name: Fnu Sugandha

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursePlanner/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursePlanner/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursePlanner/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentCoursePlanner/src/build.xml run -Darg0="input.txt" -Darg1="output.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:


Justification for choice of data structures:
Data structure used is ArrayList. Simple array based data structure is used considering the complexity level of problem.ArrayList are re-sizable array and we dont know the number
of students or courses before hand so its better to use dynamic arrays.It also has multiple methods to modify stored objects.

Data Structure Linked Hashmap to maintain the insertion order so that the assigned courses order can be maintained and what courses were taken in which semester can be checked for 
prerequisites requirement

the code will run for multiple students as well

Arraylist has been used to store the waitlist courses because the courses are limited and not exceptionally large.
Algorithm/Scheme:
Everytime preference course doe not meet the prerequisites its been added to waitlist and removed from preferences arraylist.
And once the next semester starts programs starts processing wait list first and if meets the prerequisite criteria then adds to the course plan and removes from the waitlist and so on.



input file location:

fnu_sugandha_assign2\studentCoursePlanner

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 08.10.2019


