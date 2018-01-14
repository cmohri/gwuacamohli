import cs1.Keyboard;

public class Table extends Grapher{
    
    //instance variables of Table:
    private String _table;
    

    //constructor sets the equation, xmin, and xmax instance variables
    public Table(String eq, int xmini, int xmaxi){
	equation = eq;
	xmin = xmini;
        xmax = xmaxi;
    }//end constructor
	
    //fillOut() method uses a for-loop to fill out the table
    public void fillOut(){
	_table = "  x  |  y\n––––––––––––\n";
	for (int x = xmin; x <= xmax; x++){
	    int y = Parser.input(equation, x);
	    //x col:
	    _table +=  x; 
	    //proper spacing for the bar between x and y cols:
	    if (x <= -10)
		_table += "  ";
	    else if (x > -10 && x < 0)
		_table += "   ";
	    else if (x >= 0 && x < 10)
		_table += "    ";
	    else _table += "   ";
	    _table += "|  " + y;
	    _table += "\n";
	}
    }//end fillOut()  

    //toString() method returns the String _table
    public String toString(){	
	fillOut();
	return "y = " + equation + "\n" + _table;
    }//end toString()
    
    //method allows user to set domain
    public void setDomain(){
	setXmin();
	setXmax();
	System.out.println(this);;
    }//end setDomain()

    //driver method combines everything so that the user can access it
    public void driver() {
	System.out.println("\n---------------------------------------");
        System.out.println("1. Download table\n2. Set domain\n3. Back to main menu");
        System.out.println("---------------------------------------");
	
        int userInput = Keyboard.readInt();
        while (userInput < 1 || userInput > 3){
            System.out.println("Please input a valid selection");
            userInput = Keyboard.readInt();
        }
        if (userInput == 1)
            download("table");
        else if (userInput == 2)
            setDomain();
	else return;
	driver();
    }//end driver()

    /*
    public static void main (String[] args){
	Table boo = new Table("3x", -20, 10);
	boo.fillOut();
	System.out.println(boo);
	System.out.println("current xmax: " + boo.xmax);
	boo.setXmax();
	System.out.println(boo.xmax);
	System.out.println(boo);
	}*/
}//end class Table