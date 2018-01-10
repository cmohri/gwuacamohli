
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
 * TASK:
 * 
 ***/

import cs1.Keyboard;

public class Spreadsheet<T> {
    
    private final static int DEFAULT_SIZE = 1;

    private int numRows, numCols;
    private Object[][] _table;

    public Spreadsheet(){
        newTable();
        numRows++;
        numCols++;
        _table = new Object[numRows][numCols];
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
        return retStr;
    }

//sort input to String, int, double
    public void filler() {
        String s;
        Object input = 0;

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                
                s = "Enter a value at (" + i + "," + j + "):  ";
                System.out.print(s);

                input = Keyboard.readString();             
                set(i,j,input);
            }
        }//sorting inputs

        s = "\n...Displaying filled chart...\n";
        System.out.println(s + this);
    }

    public void functions() {
        String s;
        int r, c;

        s = "What would you like to do next?\n";
        s += "\t1: Edit the table\n";
        s += "\t2: Calculate statistics\n";
        s += "\t3: Exit program\n";
        System.out.println(s);

        if (Keyboard.readInt() == 1) {
            
            s = "wooo?"; //answer in the form of (a,b)
            s += "\nRow: ";
            System.out.println(s);


        }
    }

    public Object set(int r, int c, Object newVal) {
        Object retVal = _table[r][c];
        _table[r][c] = newVal;
        return retVal;        
    }

/*
    public Object[] addRow() {
        numRows++;
        Object[][] temp = new Object[numRows][numCols];


    }

    public Object[] addRow(int r) {

    }

    public Object[] add(){

    }
*/
    public static void main(String[] args){

        Spreadsheet pigeon = new Spreadsheet();

        System.out.println(pigeon);
        pigeon.filler();

//Would you like to get, set, remove, addRow, addCol, statistics, exit
        pigeon.functions();


    }
}//end of Spreadsheet 