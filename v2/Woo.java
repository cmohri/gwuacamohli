//driver class
import cs1.Keyboard;

public class Woo{

    //driver method calls on other classes based on user selection
    public static void driver() {

	System.out.println("Select functionality");
	System.out.println("1. Equation graphing, statistics, more");
	System.out.println("2. Open spreadsheet");
	System.out.println("3. Calculator");
	System.out.println("4. View description of each option");
	System.out.println("5. Exit");
	int userInput = Keyboard.readInt();
	while (userInput < 1 || userInput > 5){
	    System.out.println("Please input a valid selection");
	    userInput = Keyboard.readInt();
	}
	if (userInput == 1){
	    Grapher foo = new Grapher();
	    foo.plotPoints();
	    foo.driver();
	}
	if (userInput == 2){
	    Spreadsheet moo = new Spreadsheet();
	    moo.filler();
	    moo.mainMenu();
	}
	if (userInput == 3){
	    Calculator bar = new Calculator();
	    bar.calculate();
	}
	if (userInput == 4){
	    System.out.println(description());
	}
	else {	    
	    System.out.println("Exiting Mathematical Utility ...");
	    return;
	}
	driver();
    }
    
    public static String description() {
	String retStr = "";
	retStr += ("------------------------------------------");
	retStr += ("\nPROGRAM DESCRIPTION\n");
	retStr += ("This program offers some of the functionality of a graphing calculator.\n");
	retStr += ("1: Equation graphing, statistics, more\n");
	retStr += ("\tEnter in a polynomial in terms of x\n\tCalculate intercepts\n\tView table\n\tChange viewing window\n\tOr download graph/table\n");
	retStr += ("2: Open spreadsheet\n");
	retStr += ("\tUse a spreadsheet to input values\n");
	retStr += ("3: Calculator\n");
	retStr += ("\tUse a basic calculator program\n");
	retStr += ("------------------------------------------\n\n");
	return retStr;
    }

    //main method, executable
    public static void main(String[] args) {

	System.out.println("\nTeam Gwuacamohli   Pd08\nClara Mohri, Wenting Li, Jessica Wu brings to you....");
	//to make text bold:
	System.out.println("\n\033[1mMathematical Utility:\033[0m\n");
	driver();	
    }//end main method
    
}//end of Driver
