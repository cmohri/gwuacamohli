
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

public class Spreadsheet<T> {
    
    private final static int DEFAULT_SIZE = 1;

    private int numRows, numCols;
    private Comparable[][] _table;

    public Spreadsheet(){
        newTable();
        numRows++;
        numCols++;
        _table = new Comparable[numRows][numCols];
    }

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

    public String toString(){
        String retStr = "\t";
        for (int n = 1; n < numCols; n++) {
            retStr += n + "\t"; 
        }
        retStr += "\n\n";
        for (int i = 1; i < numRows; i++) {
            retStr += i + "\t";
            for (int j = 1; j < numCols; j++) {
                if (_table[i][j] == null) 
                    retStr += "\t";
                else retStr += _table[i][j] + "\t"; 
            }
            retStr += "\n\n";
        }
        return retStr + "\b";
    }

//sort input to String, int, double
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

    public void filler(boolean fillRow,int index) {
        String s;
        Comparable input;

        //Filling the new Row
        if (fillRow) {
            s = "\n";
           for (int i = 1; i < numCols; i++) {
               
                s = "Enter a value at (" + index + "," + i + "):  ";
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

        if (input == 1) 
            edit();

        else if (input == 2) 
            statistics();
            //security check for all ints and doubles

        else if (input == 3) 
            System.out.println("\n~~ Hope ya had a great time!");

        else {
            //error message
        }
    }

    public void edit(){
        String s;
        int r,c;
        Comparable input;
        
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

                s = "\t...to what?  ";
                System.out.print(s);
                input = Parser.input();
                set(r,c,input);
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
                remove(r,c);
                System.out.println("\n...Removing value @slot(" + r + "," + c +")" + "...\n" + this);
                
                edit();
            }

            //Adding a row
            else if (input == 3) {
                s = "\nAdding a new row...\n";
                s += "\tSpecify row index at which you want to insert the new row: ";
                System.out.print(s);
                r = Keyboard.readInt();

                addRowCol(true,r);
                System.out.println("\n...New row " + r + " inserted...\n" + this);
                filler(true,r);

                edit();
            }

            //Adding a column
            else if (input == 4) {
                s = "\nAdding a new column...\n";
                s += "\tSpecify column index at which you want to insert the new column: ";
                System.out.print(s);
                c = Keyboard.readInt();

                addRowCol(false,c);
                System.out.println("\nNew column " + c + " inserted...\n" + this);
                filler(false,c);

                edit();
            }

            //Remove a row
            else if (input == 5) {
                mainMenu();
            }

            //Remove a column
            else if (input == 6) {
                mainMenu();
            }

            //Sort data
            else if (input == 7) {

                s = "\nSort data of (in ascending order)...\n";
                s += "\t1: a specified row\n";
                s += "\t2: a specified column\n";
                s += "\t3: every value in the table\n";
                s += "Your selection:  ";
                System.out.print(s);
                input = Keyboard.readInt();

                if (input == 1) {
                    s += "\tSpecify row number: ";
                    System.out.print(s);
                    r = Keyboard.readInt();

                    double[] temp = new double[numCols - 1];
                    for (int i = 1 ; i < numCols; i++) {
                        temp[i - 1] = (double)_table[r][i];
                    }
                    insertionSort(temp);
                    for (int i = 1 ; i < numCols; i++) {
                        _table[r][i] = temp[i - 1];
                    }

                    System.out.println("...Displaying sorted table...\n" + this);
                }

                if (input == 2) {
                    s += "\tSpecify column number: ";
                    System.out.print(s);
                    c = Keyboard.readInt();

                    double[] temp = new double[numRows - 1];
                    for (int i = 1 ; i < numRows; i++) {
                        temp[i - 1] = (double)_table[i][c];
                    }
                    insertionSort(temp);
                    for (int i = 1 ; i < numRows; i++) {
                        _table[i][c] = temp[i - 1];
                    }

                    System.out.println("...Displaying sorted table...\n" + this);
                }


                if (input == 3) {
                    int placeholder = 0;
                    double[] temp = new double[(numRows - 1)*(numCols - 1)];
                    for (int i = 1; i < numRows; i++) {
                        for (int j = 1; j < numCols; j++) {
                            temp[placeholder] = (double)_table[i][j];
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
                }
            }

            //Back to main menu!
            else if (input == 8) {
                mainMenu();
            }

            else if (input == 9) {
                s = "Are you sure? (y or n)  ";
                System.out.print(s);
                input = Keyboard.readString();
                if (input.equals("n")) {
                    edit();
                }
                else System.out.println("\n~~ Hope ya had a great time!");
            }

            //error message
            else {

            }
    }

    public void statistics() {
        String s;
        boolean calcRow = false, calcAll = false;
        int index = 0;
        Comparable input, input2 = 0;
        
            s = "\nWhat would you like to calculate:\n";
            s += "\t1: Mean\n";
            s += "\t2: Median\n";
            s += "\t3: Mode\n";
            s += "\t4: Back to main menu\n";
            s += "\t5: Exit the program\n";
            s += "Your selection:  ";
            System.out.print(s);
            input = Keyboard.readInt();

            if (!(input == 4)) {
            s = "\nCalulate statistics on...\n";
            s += "\t1: a specified row\n";
            s += "\t2: a specified column\n";
            s += "\t3: every value in the table\n";
            s += "Your selection:  ";
            System.out.print(s);
            input2 = Keyboard.readInt();
            }

            if (input2 == 1) {
                s = "\n\tSpecify a row:  ";
                System.out.print(s);
                index = Keyboard.readInt();
                calcRow = true;

                for (int i = 1; i < numCols; i++) {
                    if (_table[index][i] instanceof String) {
                        System.out.println("Error: Invalid data type in selected row.  Returning to the previous menu.");
                        statistics();
                    }
                }
            }

            else if (input2 == 2) {
                s = "\n\tSpecify a column:  ";
                System.out.print(s);
                index = Keyboard.readInt();
                calcRow = false;

                for (int i = 1; i < numRows; i++) {
                    if (_table[i][index] instanceof String) {
                        System.out.println("Error: Invalid data type in selected column.  Returning to the previous menu.");
                        statistics();
                    }
                }
            }

            else if (input2 == 3) {
                calcAll = true;

                for (int i = 1; i < numRows; i++) {
                    for (int j = 1; j < numCols; j++) {
                        if (_table[i][j] instanceof String) {
                        System.out.println("Error: Invalid data type in the table.  Returning to the previous menu.");
                        statistics();
                        }
                    }
                }
            }

            else {
                //error messages
                s = "\nInput is not an option. Returning to the previous menu...";
                System.out.println(s);
                statistics();
            }

//----------------------
            //mean
            if (input == 1) {
                if (calcAll) {
                    System.out.println( mean() );
                }
                else System.out.println( mean(calcRow,index) );
                statistics();
            }

            //median
            else if (input == 2) {
                if (calcAll) {
                    System.out.println( median() );
                }
                else System.out.println( median(calcRow,index) );
                statistics();
            }

            //mode
            else if (input == 3) {
                if (calcAll) {
                    System.out.println( mode() );
                }
                else System.out.println( mode(calcRow,index) );
                statistics();
            }

            //Back to main menu!
            else if (input == 4) {
                mainMenu();
            }

            else if (input == 5) {
                s = "Are you sure? (y or n)  ";
                System.out.print(s);
                input = Keyboard.readString();
                if (input.equals("n")) {
                    edit();
                }
                else System.out.println("\n~~ Hope ya had a great time!");
            }

            //error messages
            else {

            }
    }

    public Comparable set(int r, int c, Comparable newVal) {
        Comparable retVal = _table[r][c];
        _table[r][c] = newVal;
        return retVal;        
    }

    public Comparable remove(int r, int c) {
        Comparable retVal = _table[r][c];
        _table[r][c] = "";
        return retVal;        
    }

    public void addRowCol(boolean addRow,int index) {
        Comparable[][] temp;
        if (addRow) {
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

    public double mean() {
        int totalNum = (numRows - 1) * (numCols - 1);
        double sum = 0;
        for (Object[] r : _table) {
            for (Object c : r) {
                sum += (double)c; 
            }
        }
        return sum / totalNum;
    }

    public double mean(boolean calcRow, int index) {
        int totalNum;
        double sum = 0;

        if (calcRow) {
            totalNum = numCols - 1;
            for (Object c : _table[index]) {
                sum += (double)c;
            }
        }
        else {
            totalNum = numRows - 1;
            for (int i = 1; i < numRows; i++) {
                sum += (double)_table[i][index];
            }
        }
        return sum / totalNum;
    }

    public double median() {
        int placeholder = 0;
        double[] temp = new double[(numRows - 1) * (numCols - 1)];
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                temp[placeholder] = (double)_table[i][j];
                placeholder++;
            }
        }
        insertionSort(temp);
        if (temp.length % 2 == 0) 
            return (temp[(temp.length / 2) - 1] + temp[(temp.length / 2) + 1]) / 2;
        else return temp[(temp.length / 2) + 1];
    }

    public double median(boolean calcRow, int index) {
        double[] temp;
        if (calcRow) {
            temp = new double[numCols - 1];
            for (int i = 1; i < numCols; i++) {
                temp[i - 1] = (double)_table[index][i];
            }
        }
        else {
            temp = new double[numRows - 1];
            for (int i = 1; i < numRows; i++) {
                temp[i - 1] = (double)_table[i][index];
            };
        }
        insertionSort(temp);

        if (temp.length % 2 == 0) 
            return (temp[temp.length / 2] + temp[(temp.length / 2) - 1]) / 2;
         else {
             return temp[temp.length / 2];
         }
    }

    public double mode() {
        int count = 0, maxCount = 0;
        double tempval, mode = 0;
        int placeholder = 0;
        double[] temp = new double[(numRows - 1) * (numCols - 1)];
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                temp[placeholder] = (double)_table[i][j];
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

    public double mode(boolean calcRow, int index) {
        int count = 0, maxCount = 0;
        double tempval, mode = 0;
        double[] temp;

        if (calcRow) {
            temp = new double[numCols - 1];
            for (int i = 1; i < numCols; i++) {
                temp[i - 1] = (double)_table[index][i];
            }
        }
        else {
            temp = new double[numRows - 1];
            for (int i = 1; i < numRows; i++) {
                temp[i - 1] = (double)_table[i][index];
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