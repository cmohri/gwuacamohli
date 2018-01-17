# gwuacamohli
## Clara Mohri, Wenting Li, Jessica Wu

_**General Project Description**_

This project functions as a basic mathematical utility. When the user runs the project, user can: 
1. Graph a polynomial function in terms of x
  * Change domain and range
  * Request y-intercept and x-intercepts
  * Request to view a table of the viewing window
2. Use a calculator for simple math
3. Create a spreadsheet
  * Request sorting based on column/row
  * View statistics for column/row

_**Instructions for Running**_

To COMPILE
~~~~
$ javac Woo.java
~~~~
To RUN
~~~~
$ java Woo
~~~~
@----------------------------------- 

 _**Instructions for Running**_
1. Select desired functionality
	1: Graphing Calculator
	2: Simple Math Calculator
	3: Spreadsheet
2. Follow instructions in shell…  

**Grapher**....
* Input a polynomial equation in the form ax^n + bx^n-1 + ...(ex. 3x^2 + 2x - 1)  
   NOTE: x should be the only variable inputted
* A graph generated from the equation will be displayed. User can then select, from a list, to customize viewing window, calculate x- and y- intercepts, download the graph to the same directory as the program, view a table of the equation, input a new equation, or exit the program. 

**Calculator**....
* Input an expression as one would enter on a simple scientific calculator in the order user would like.
	   (ex. 3 + 3 / 3 would result in 2)
	NOTE: only +,-,*,/,^ are acceptable operations
*  The result will be displayed in the shell.

**Spreadsheet**....
* Input "<# of Rows> by <# of Columns>", with rows starting from index 1 and increasing downwards, and columns starting from index 1 and increasing to the right.
* An empty table will be displayed with the appropriate number of rows and columns labeled. User will then fill the table row by row by typing the desired stored object in the grid. 
    NOTE: Spreadsheet will only take ints, doubles, or Strings as a storable value!
* A filled graph will be displayed. User can choose a functionality in the main menu by entering the corresponding number (ex. 1, 2, etc...). User will be redirected to the edit or statistics menu. Once again, enter the number corresponding to the functionality you wish to use for magic to happen.
* User can edit the graph (add a row, remove a row, etc.) at a specified index and request statistics (mean, median, mode) of a specified row, column, or every value in the table!
    * NOTE: Functionalities including sort and statistics calculations only function on ints and doubles stored in the table. Sorting a list of int and doubles returns a list of doubles and shows up as doubles in the displayed list after the sorting. Sorting uses insertion sort algorithm.
    * NOTE: Mode returns the most frequent value in the specified data set. However, when there are more than one mode, the smallest mode will be returned. Similarly, when there is no mode, the smallest number in the specified data set will be returned.
