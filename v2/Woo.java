//driver class
import cs1.Keyboard;

public class Woo{

    //driver method calls on other classes based on user selection
    public static void driver() {
	System.out.println("Mathematical Utility");
	System.out.println("Select functionality");
	System.out.println("1. Function work");
	System.out.println("2. Open spreadsheet");
	System.out.println("3. Calculator");
	System.out.println("4. Exit");
	int userInput = Keyboard.readInt();
	while (userInput < 1 || userInput > 4){
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
	    moo.functions();
	}
	if (userInput == 3){
	    Calculator bar = new Calculator();
	    bar.calculate();
	}
	else {	    
	    return;
	}
	driver();
    }
    

    public static void main(String[] args) {
	driver();	
    }
    
}//end of Driver