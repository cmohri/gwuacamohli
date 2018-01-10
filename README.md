# gwuacamohli
## Clara Mohri, Wenting Li, Jessica Wu

_**General Project Description**_

This project functions as a basic mathematical utility. When the user runs the project, user can: 
1. Graph a polynomial function in terms of x
  * Change domain and range
  * Request zeroes and intercepts within the viewing window
  * Request to view a table of the viewing window
2. Use a calculator for simple math
3. Create a spreadsheet
  * Request sorting based on column/row
  * View statistics for column/row

_**Instructions for Running**_

To COMPILE
~~~~
$ cd ~/gwuacamohli/codes
$ javac Driver.java
~~~~
To RUN
~~~~
$ java Driver
~~~~
@-----------------------------------
1. Select desired functionality
	1: Graphing Calculator
	2: Simple Math Calculator
	3: Spreadsheet
2. Follow instructions in shell…
   * Grapher....
        i) Input a polynomial equation in the form ax^n + bx^n-1 + ...
	   (ex. 3x^2 + 2x - 1)
	NOTE: x should be the only variable inputted
	ii) A graph generated from the equation will be displayed. User can then select to modify the preset domain and range for the graph by typing "edit domain" or "edit range" in shell.
	iii) User can request a table for the equation in the viewing window by typing "table" in the shell.
	iv) Users can request zeroes, y-intecepts, and slope by selecting from a list.

   * Calculator....
	i) Input an expression as one would enter on a simple scientific calculator in the order user would like.
	   (ex. 3 + 3 / 3 would result in 2)
	NOTE: only +,-,*,/,^ are acceptable operations
	ii) The result will be displayed in the shell.

   * Spreadsheet....
	i) Input "<# of Rows> by <# of Columns>", with rows starting from index 1 and increasing downwards, and columns starting from index 1 and increasing to the right.
	ii) An empty table will be displayed with the appropriate number of rows and columns labeled. User will then fill the table row by row by typing the desired stored object in the grid. 
	iii) A filled graph will be displayed. User can request to get the value at a specified slot (type "get" in the shell), set a value at a specified slot ("set"), remove a value ("remove"_, add another row at the specified index ("addRow"), and add another column at the specified index ("addCol").
	iv) User can request statistics (mean, median, mode) of a specified row, column, or every value in the table!
