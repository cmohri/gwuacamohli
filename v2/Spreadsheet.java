
/***
 * class Spreadsheet -- models an excel spreadsheet
 *
 * BACKGROUND:
 * A Spreadsheet contains a table in the form of a rectangular array.
 * Its dimensions are numRows by numColumns.
 * Each row and column are numbered starting from 1.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 by 3 spreadsheet:
 *        -       -
 *        1   2   3  
 *
 *    1   a   b   c
 *
 *    2   d   e   f
 *        -       -
 *   ... where d is at position (2,1).
 *
 * 
 ***/

import cs1.Keyboard;

public class Spreadsheet {
    
    private final static int DEFAULT_SIZE = 1;

    private int numRows, numCols;
    private Comparable[][] _table;

    //===================================
    //      ~INITIATOR FUNCTIONS~
    //===================================

    //default constructor
    public Spreadsheet(){
        newTable();
        numRows++;
        numCols++;
        _table = new Comparable[numRows][numCols];
    }

    //Initiates graph by asking user for number of rows and columns
    //Creates graph of default size 1 by 1 if inputs are invalid
    public void newTable() {
        String s;

        s = "~~~Spreadsheet functionality~~~\n";

        s += "\nNumber of Rows: ";
        System.out.print(s);
        numRows = Keyboard.readInt();

        s = "Number of Columns: ";
        System.out.print(s);
        numCols = Keyboard.readInt();

        if (numRows < 1 || numCols < 1) {
            numRows = DEFAULT_SIZE;
            numCols = DEFAULT_SIZE;
            s = "\nNumber of rows or columns entered is invalid. ";
            s += "\n...Creating table with default dimensions 1 by 1...";
            System.out.println(s);
        }
        else {
            s = "\n...Creating table with dimensions " + numRows + " by " + numCols + "...";
            System.out.println(s);
        }
    }     

    //Overwrites toString() to return the table with each row                          
    //and column labeled starting from 1                                               
    public String toString(){
        String retStr = "\t";
        for (int n = 1; n < numCols; n++) {
            retStr += n + "\t";
        }
        retStr += "\n\t ";
        for (int n = 1; n < numCols; n++) {
            retStr += "--------";
        }
        retStr += "\n\t|\n";
        for (int i = 1; i < numRows; i++) {
            retStr += i + "\t|";
            for (int j = 1; j < numCols; j++) {
                if (_table[i][j] == null)
                    retStr += "\t";
                else retStr += _table[i][j] + "\t";
            }
            retStr += "\n\t|\n";
        }
        return retStr + "\b";
    }


    //Fills each slot with a user input
    public void filler() {
        String s, in;
        Comparable input = "";

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                
                s = "Enter a value at (" + i + "," + j + "):  ";
                System.out.print(s);

                input = Parser.input();
                set(i,j,input);
            }
        }

        s = "\n...Displaying filled table...\n";
        System.out.println(s + this);
    }

    //Overwrites filler() and fills a specified row or column with user input
    //if boolean fillRow is true, fill in the row at the given index
    //                      false, fill in the column at the given index
    public void filler(boolean fillRow,int index) {
        String s;
        Comparable input;

        //Filling the new Row
        if (fillRow) {
           for (int i = 1; i < numCols; i++) {
               
                s = "\nEnter a value at (" + index + "," + i + "):  ";
                System.out.print(s);

                input = Parser.input();
                set(index,i,input);
           }
        }

        //Filling the new Column
        else {
            s = "\n";
           for (int i = 1; i < numRows; i++) {
               
                s = "Enter a value at (" + i + "," + index + "):  ";
                System.out.print(s);

                input = Parser.input();
                set(i,index,input);
           }
        }

        s = "\n...Displaying filled table...\n";
        System.out.println(s + this);        
    }

    //===================================
    //         ~MENU FUNCTIONS~
    //===================================

    //Contains selection to edit or calculate statistics
    public void mainMenu() {
        String s;
        int input;

        s = "\nWhat would you like to do next?\n";
        s += "\t1: Edit the table\n";
        s += "\t2: Calculate statistics\n";
        s += "\t3: Exit program\n";
        s += "Your selection:  ";
        System.out.print(s);
        input = Keyboard.readInt();

        //Edit the table
        if (input == 1) 
            edit();

        //Calculate statistics
        else if (input == 2) 
            statistics();
            //security check for all ints and doubles

        //Exit the program
        else if (input == 3) {
            System.out.println("\nBack to main menu...\n");
	    Woo zoo = new Woo();
	    zoo.driver();
	}
        //Error message for invalid inputs
        else {
            System.out.println("Your selection is not an option. Please enter one of the options.");
            mainMenu();
        }
    }

    //Contains selection to edit the table
    public void edit(){
        String s;
        int r,c, input;
        Comparable input2;
        
            s = "\nChoose a following option to edit the table:\n";
            s += "\t1: Edit value in a slot\n";
            s += "\t2: Remove value at a slot\n";
            s += "\t3: Add a row\n";
            s += "\t4: Add a column\n"; 
            s += "\t5: Remove a row\n"; 
            s += "\t6: Remove a column\n"; 
            s += "\t7: Sort data\n"; 
            s += "\t8: Back to main menu\n";
            s += "\t9: Exit the program\n";
            s += "Your selection:  ";
            System.out.print(s);
            
            input = Keyboard.readInt();

            //Setting the value at a specified (r,c)
            if (input == 1) {
                s = "\nEditing value at a specified slot...\n";
                s += "\tSpecify row number: ";
                System.out.print(s);
                r = Keyboard.readInt();

                s = "\tSpecify column number: ";
                System.out.print(s);
                c = Keyboard.readInt();

                if ( (r >= numRows || r < 1) 
                    || (c >= numCols || c < 1) ) {
                    System.out.println("Error: Invalid input for index. Returning to to the previous menu...");
                    edit();
                }

                s = "\t...to what?  ";
                System.out.print(s);
                input2 = Parser.input();
                set(r,c,input2);
                System.out.println("\n...Setting slot(" + r + "," + c +") to " + input + "...\n" + this);

                edit();
            }

            //Removing the value at a specified(r,c)
            else if (input == 2) {
                s = "\nRemoving value at a specified slot...\n";
                s += "\tSpecify row number: ";
                System.out.print(s);
                r = Keyboard.readInt();

                s = "\tSpecify column number: ";
                System.out.print(s);
                c = Keyboard.readInt();

                if ( (r >= numRows || r < 1) 
                    || (c >= numCols || c < 1) ) {
                    System.out.println("Error: Invalid input for index. Returning to to the previous menu...");
                    edit();
                }

                remove(r,c);
                System.out.println("\n...Removing value @slot(" + r + "," + c +")" + "...\n" + this);
                
                edit();
            }

            //Adding a row r
            else if (input == 3) {
                s = "\nAdding a new row...\n";
                s += "\tSpecify row index at which you want to insert the new row: ";
                System.out.print(s);
                r = Keyboard.readInt();

                if  (r > numRows || r < 1) {
                    System.out.println("Error: Invalid input for index. Returning to to the previous menu...");
                    edit();
                }

                add(true,r);
                System.out.println("\n...New row " + r + " inserted...\n" + this);
                filler(true,r);

                edit();
            }

            //Adding a column c
            else if (input == 4) {
                s = "\nAdding a new column...\n";
                s += "\tSpecify column index at which you want to insert the new column: ";
                System.out.print(s);
                c = Keyboard.readInt();

                if  (c > numCols || c < 1) {
                    System.out.println("Error: Invalid input for index. Returning to to the previous menu...");
                    edit();
                }

                add(false,c);
                System.out.println("\n...New column " + c + " inserted...\n" + this);
                filler(false,c);

                edit();
            }

            //Remove a row r
            else if (input == 5) {
                s = "\nRemoving a row...\n";
                s += "\tSpecify the index of the row you wish to remove: ";
                System.out.print(s);
                r = Keyboard.readInt();

                if  (r >= numRows || r < 1) {
                    System.out.println("Error: Invalid input for index. Returning to to the previous menu...");
                    edit();
                }

                remove(true,r);
                System.out.println("\n...Displaying updated table...\n" + this);

                edit();
            }

            //Remove a column c
            else if (input == 6) {
                s = "\nRemoving a column...\n";
                s += "\tSpecify the index of the column you wish to remove: ";
                System.out.print(s);
                c = Keyboard.readInt();

                if  (c >= numCols || c < 1) {
                    System.out.println("Error: Invalid input for index. Returning to to the previous menu...");
                    edit();
                }

                remove(false,c);
                System.out.println("\n...Displaying updated table...\n" + this);

                edit();
            }

            //Sort data in ascending order
            //Allows sorting for a specified row, column, or entire table
            else if (input == 7) {

                s = "\nSort table (in ascending order)...\n";
                s += "\t1: a specified row\n";
                s += "\t2: a specified column\n";
                s += "\t3: every value in the table\n";
                s += "Your selection:  ";
                System.out.print(s);
                input = Keyboard.readInt();

                //Sorting a row r
                if (input == 1) {
                    s += "\nSpecify row number: ";
                    System.out.print(s);
                    r = Keyboard.readInt();

                    if  (r >= numRows || r < 1) {
                        System.out.println("Error: Invalid input for index. Returning to to the previous menu...");
                        edit();
                    }

                    double[] temp = new double[numCols - 1];
                    for (int i = 1 ; i < numCols; i++) {
                        if (_table[r][i] instanceof String) {
                            System.out.println("Error: Invalid data type exists in selected row.  Returning to the previous menu...");
                            edit();
                        }
                        if(_table[r][i] instanceof Double)
                            temp[i - 1] = (double)_table[r][i];
                        else temp[i - 1] = (int)_table[r][i];
                    }
                    insertionSort(temp);
                    for (int i = 1 ; i < numCols; i++) {
                        _table[r][i] = temp[i - 1];
                    }

                    System.out.println("\n...Displaying sorted table...\n" + this);
                    
                    edit();
                }

                //Sorting a column c
                else if (input == 2) {
                    s += "\nSpecify column number: ";
                    System.out.print(s);
                    c = Keyboard.readInt();

                    if  (c >= numCols || c < 1) {
                        System.out.println("Error: Invalid input for index. Returning to to the previous menu...");
                        edit();
                    }

                    double[] temp = new double[numRows - 1];
                    for (int i = 1 ; i < numRows; i++) {
                        if (_table[i][c] instanceof String) {
                            System.out.println("Error: Invalid data type exists in selected column.  Returning to the previous menu...");
                            edit();
                        }
                        if (_table[i][c] instanceof Double)
                            temp[i - 1] = (double)_table[i][c];
                        else temp[i - 1] = (int)_table[i][c];
                    }
                    insertionSort(temp);
                    for (int i = 1 ; i < numRows; i++) {
                        _table[i][c] = temp[i - 1];
                    }

                    System.out.println("\n...Displaying sorted table...\n" + this);

                    edit();
                }

                //Sorting the entire table
                else if (input == 3) {
                    int placeholder = 0;
                    double[] temp = new double[(numRows - 1)*(numCols - 1)];
                    for (int i = 1; i < numRows; i++) {
                        for (int j = 1; j < numCols; j++) {

                            if (_table[i][j] instanceof String) {
                                System.out.println("Error: Invalid data type exists in selected column.  Returning to the previous menu...");
                                edit();
                            }
                    
                            if (_table[i][j] instanceof Double)
                                temp[placeholder] = (double)_table[i][j];
                            else temp[placeholder] = (int)_table[i][j];
                            placeholder++;
                        }
                    }
                    insertionSort(temp);
                    placeholder = 0;
                    for (int i = 1; i < numRows; i++) {
                        for (int j = 1; j < numCols; j++) {
                            _table[i][j] = temp[placeholder];
                            placeholder++;
                        }
                    }

                    System.out.println("\n...Displaying sorted table...\n" + this);

                    edit();
                }

                //Error message for invalid inputs
                else {
                    System.out.println("Your selection is not an option. Returning to the previous menu...");
                    edit();
                }
            }

            //Back to main menu!
            else if (input == 8) {
                mainMenu();
            }

            //Exit the program
            else if (input == 9) {
                s = "Are you sure? (y or n)  ";
                System.out.print(s);
                input2 = Keyboard.readString();
                if (input2.equals("n")) {
                    edit();
                }
                else {
		    System.out.println("\nBack to main menu...\n");
		    Woo zoo = new Woo();
		    zoo.driver();
		}
            }

            //Error message for invalid inputs
            else {
                System.out.println("Your selection is not an option. Please enter one of the options.");
                edit();
            }
    }

    //Contains selection to calculate mean, median, or mode for 
    //a specifed row, column, or the entire table.
    //Checks if selected rows or tables only hold int or double values.
    //If calcAll is true, calculate statistics for all values in the table.
    //If calcRow is true, calculate statistics for a specified index
    public void statistics() {
        String s;
        boolean calcRow = false, calcAll = false;
        int index = 0, input, input2 = 0;
        
            s = "\nWhat would you like to calculate:\n";
            s += "\t1: Mean\n";
            s += "\t2: Median\n";
            s += "\t3: Mode\n";
            s += "\t4: Back to main menu\n";
            s += "\t5: Exit the program\n";
            s += "Your selection:  ";
            System.out.print(s);
            input = Keyboard.readInt();

            //Back to main menu!
            if (input == 4) {
                mainMenu();
            }

            //Exit the program
            else if (input == 5) {
                s = "Are you sure? (y or n)  ";
                System.out.print(s);
                s = Keyboard.readString();
                if (s.equals("n")) {
                    edit();
                }
                else {
		    System.out.println("\nBack to main menu...\n");
		    Woo zoo = new Woo();
		    zoo.driver();
		}
                return;
            }

            //If calculation functions are selected, choose index
            if (input == 1 || input == 2 || input == 3) {
            s = "\nCalulate statistics on...\n";
            s += "\t1: a specified row\n";
            s += "\t2: a specified column\n";
            s += "\t3: every value in the table\n";
            s += "Your selection:  ";
            System.out.print(s);
            input2 = Keyboard.readInt();
            }

            //Specify a row 
            if (input2 == 1) {
                s = "Specify a row:  ";
                System.out.print(s);
                index = Keyboard.readInt();
                calcRow = true;

                if (index >= numRows || index < 1) {
                    System.out.println("Error: Invalid input for index. Returning to to the previous menu...");
                    statistics();
                }

                for (int i = 1; i < numCols; i++) {
                    if (_table[index][i] instanceof String) {
                        System.out.println("Error: Invalid data type in selected row.  Returning to the previous menu...");
                        statistics();
                    }
                }
            }

            //Specify a column
            else if (input2 == 2) {
                s = "Specify a column:  ";
                System.out.print(s);
                index = Keyboard.readInt();
                calcRow = false;

                if (index >= numCols || index < 1) {
                    System.out.println("Error: Invalid input for index. Returning to to the previous menu...");
                    statistics();
                }

                for (int i = 1; i < numRows; i++) {
                    if (_table[i][index] instanceof String) {
                        System.out.println("Error: Invalid data type in selected column.  Returning to the previous menu...");
                        statistics();
                    }
                }
            }

            //Selected the entire table
            else if (input2 == 3) {
                calcAll = true;

                for (int i = 1; i < numRows; i++) {
                    for (int j = 1; j < numCols; j++) {
                        if (_table[i][j] instanceof String) {
                        System.out.println("Error: Invalid data type in the table.  Returning to the previous menu...");
                        statistics();
                        }
                    }
                }
            }

            //error message for invalid input for input2
            else {
                System.out.println("Your selection is not an option. Returning to the previous menu...");
                statistics();
            }

        //----------------------------------
            //Calculating the mean
            if (input == 1) {
                if (calcAll) {
                    System.out.println( "Calculated mean:  " + mean() ); //the entire table
                }
                else System.out.println( "Calculated mean:  " + mean(calcRow,index) ); //the specified row/column
                System.out.println("\nCurrent table:" + this);
                statistics();
            }

            //Calculating the median
            else if (input == 2) {
                if (calcAll) {
                    System.out.println( "Calculated median:  " + median() ); //the entire table
                }
                else System.out.println( "Calculated median:  " + median(calcRow,index) ); //the specified row/column
                System.out.println("\nCurrent table:" + this);
                statistics();
            }

            //Calculating the mode
            else if (input == 3) {
                if (calcAll) {
                    System.out.println( "Calculated mode:  " + mode() ); //the entire table
                }
                else System.out.println( "Calculated mode:  " + mode(calcRow,index) ); //the specified row/column
                System.out.println("\nCurrent table:" + this);
                statistics();
            }

            //Back to main menu!
            else if (input == 4) {
                mainMenu();
            }

            //Exit the program
            else if (input == 5) {
                s = "Are you sure? (y or n)  ";
                System.out.print(s);
                s = Keyboard.readString();
                if (s.equals("n")) {
                    edit();
                }
                else System.out.println("\n~~Back to main menu...\n");
		Woo zoo = new Woo();
		zoo.driver();
            }

            //Error message for invalid inputs
            else {
                System.out.println("Your selection is not an option. Please enter one of the options.");
                edit();
            }
    }

    //===================================
    //        ~HELPER FUNCTIONS~
    //===================================

    //Sets (r,c) to newVal
    public Comparable set(int r, int c, Comparable newVal) {
        Comparable retVal = _table[r][c];
        _table[r][c] = newVal;
        return retVal;        
    }

    //Removes value at (r,c)
    public Comparable remove(int r, int c) {
        Comparable retVal = _table[r][c];
        _table[r][c] = "";
        return retVal;
    }

    //Removes a row or column at specified index
    //If removeRow is true, remove row at index
    //                false, remove column at index
    public void remove(boolean removeRow, int index) {
        Comparable[][] temp;
        if (removeRow) {  
            //Removing a row 
            numRows--;
            temp = new Comparable[numRows][numCols];
            for (int i = 1; i < index; i++) {
                for (int j = 1; j < numCols; j++) {
                    temp[i][j] = _table[i][j]; 
                }
            }
            for (int i = index; i < numRows; i++) {
                for (int j = 1; j < numCols; j++) {
                    temp[i][j] = _table[i + 1][j];
                }
            }
        }
        else {
            //Removing a column
            numCols--;
            temp = new Comparable[numRows][numCols];
            for (int i = 1; i < index; i++) {
                for (int j = 1; j < numRows; j++) {
                    temp[j][i] = _table[j][i];
                }
            }
            for (int i = index; i < numCols; i++) {
                for (int j = 1; j < numRows; j++) {
                    temp[j][i] = _table[j][i + 1];
                }
            }
        }
         _table = temp;
    }

    //Adds a row or column at specified index
    //If removeRow is true, add row at index
    //                false, add column at index
    public void add(boolean addRow,int index) {
        Comparable[][] temp;
        if (addRow) {  
            //Adding an empty row 
            numRows++;
            temp = new Comparable[numRows][numCols];
            for (int i = numRows - 1; i > index; i--) {
                for (int j = 1; j < numCols; j++) {
                    temp[i][j] = _table[i-1][j]; 
                } 
            }
            for (int i = index - 1; i > 0; i--) {
                for (int j = 1; j < numCols; j++) {
                    temp[i][j] = _table[i][j];
                }
            }
        }
        else {
            //Adding an empty column
            numCols++;
            temp = new Comparable[numRows][numCols];
            for (int i = numCols - 1; i > index; i--) {
                for (int j = 1; j < numRows; j++) {
                    temp[j][i] = _table[j][i-1];
                }
            }
            for (int i = index - 1; i > 0; i--) {
                for (int j = 1; j < numRows; j++) {
                    temp[j][i] = _table[j][i];
                }
            }
        }
         _table = temp;
    }

    //Utilized insertion sort to sort an array in ascending order
    public void insertionSort(double[] data) {
        for( int partition = 1; partition < data.length; partition++ ) {

            for( int i = partition; i > 0; i-- ) {
                if ( data[i] < ( data[i - 1] )) {
                    double temp = data[i];
                    data[i] = data[i-1];
                    data[i-1] = temp;
                } 
                else break;
            } 
        }
    }

    //-------------------------------
    //Calculates the mean of the values in the table
    //Mean = Returns sum of each considered value divided by the total number of values 
    public double mean() {
        int totalNum = (numRows - 1) * (numCols - 1);
        double sum = 0;
            for (int i = 1; i < numRows; i++) {
                for (int j = 1; j < numCols; j++) {
                if (_table[i][j] instanceof Double) 
                    sum += (double)_table[i][j];
                else sum += (int)_table[i][j];
            }
        }
System.out.println(sum + "/" + totalNum);
        return sum / totalNum;
    }

    //Calculates the mean of the values in a specified row or column
    //If calcRow is true, calculate the mean for the specified row
    //              false, calculate the mean for the specified column
    public double mean(boolean calcRow, int index) {
        int totalNum;
        double sum = 0;

        if (calcRow) {
            //Calculating the mean of row index
            totalNum = numCols - 1;
            for (int i = 1; i < numCols; i++) {
                if (_table[index][i] instanceof Double) 
                    sum += (double)_table[index][i];
                else sum += (int)_table[index][i];
            }
        }
        else {
            //Calculating the mean of column index
            totalNum = numRows - 1;
            for (int i = 1; i < numRows; i++) {
                if (_table[i][index] instanceof Double) 
                    sum += (double)_table[i][index];
                else sum += (int)_table[i][index];
            }
        }
        return sum / totalNum;
    }

    //Calculates the median of the values in the table
    //Median: Copies considered values to an array and sorts the array into ascending order
    //Returns the value at the middle for odd-lengthed arrays and the mean 
    //    of the two values at the middle for even-lengthed arrays.
    public double median() {
        int placeholder = 0;
        double[] temp = new double[(numRows - 1) * (numCols - 1)];
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                if (_table[i][j] instanceof Double) 
                    temp[placeholder] = (double)_table[i][j];
                else temp[placeholder] = (int)_table[i][j];
                placeholder++;
            }
        }
        insertionSort(temp);

        if (temp.length % 2 == 0) {
System.out.println(temp[temp.length / 2]+"+"+temp[(temp.length / 2) -1]+"/2");
            return (temp[temp.length / 2] + temp[(temp.length / 2) - 1]) / 2;
        } else return temp[temp.length / 2];
    }

    //Calculates the median of the values in a specified row or column
    //If calcRow is true, calculate the median for the specified row
    //              false, calculate the median for the specified column
    public double median(boolean calcRow, int index) {
        double[] temp;
        if (calcRow) {
            //Calculating the median of row index            
            temp = new double[numCols - 1];
            for (int i = 1; i < numCols; i++) {
                if (_table[index][i] instanceof Double) 
                    temp[i - 1] = (double)_table[index][i];
                else temp[i - 1] = (int)_table[index][i];
            }
        }
        else {
            //Calculating the median of column index
            temp = new double[numRows - 1];
            for (int i = 1; i < numRows; i++) {
                if (_table[i][index] instanceof Double) 
                    temp[i - 1] = (double)_table[i][index];
                else temp[i - 1] = (int)_table[i][index];
            };
        }
        insertionSort(temp);

        if (temp.length % 2 == 0) {
System.out.println(temp[temp.length / 2]+"+"+temp[(temp.length / 2) -1]+"/2");
            return (temp[temp.length / 2] + temp[(temp.length / 2) - 1]) / 2;
         } else {
             return temp[temp.length / 2];
         }
    }

    //Calculates the mode of the values in the table  
    public double mode() {
        int count = 0, maxCount = 0;
        double tempval, mode = 0;
        int placeholder = 0;
        double[] temp = new double[(numRows - 1) * (numCols - 1)];
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                if (_table[i][j] instanceof Double) 
                    temp[placeholder] = (double)_table[i][j];
                else temp[placeholder] = (int)_table[i][j];
                placeholder++;
            }
        }
        insertionSort(temp);

        tempval = temp[0];
        for (double n : temp) {
            if (tempval ==  n) {
                count++;
            }
            if (count > maxCount) {
                maxCount = count;
                mode = tempval;
            }
            count = 1;
            tempval = n;
        }
        return mode;
    }

    //Calculates the mode of the values in a specified row or column
    //If calcRow is true, calculate the mode for the specified row
    //              false, calculate the mode for the specified column
    public double mode(boolean calcRow, int index) {
        int count = 0, maxCount = 0;
        double tempval, mode = 0;
        double[] temp;

        if (calcRow) {
            //Calculating the mode of row index
            temp = new double[numCols - 1];
            for (int i = 1; i < numCols; i++) {
                if (_table[index][i] instanceof Double) 
                    temp[i - 1] = (double)_table[index][i];
                else temp[i - 1] = (int)_table[index][i];
            }
        }
        else {
            //Calculating the mode of column index
            temp = new double[numRows - 1];
            for (int i = 1; i < numRows; i++) {
                if (_table[i][index] instanceof Double) 
                    temp[i - 1] = (double)_table[i][index];
                else temp[i - 1] = (int)_table[i][index];
            };
        }
        insertionSort(temp);

        tempval = temp[0];
        for (double n : temp) {
            if (tempval ==  n) {
                count++;
            }
            if (count > maxCount) {
                maxCount = count;
                mode = tempval;
            }
            count = 1;
            tempval = n;
        }
        return mode;
    }


    public static void main(String[] args){

        Spreadsheet pigeon = new Spreadsheet();

        System.out.println(pigeon);
        pigeon.filler();

//Would you like to set, remove, addRow, addCol, statistics, exit
        pigeon.mainMenu();

    }//end of main

}//end of Spreadsheet 