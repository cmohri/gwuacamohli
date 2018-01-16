import cs1.Keyboard;
import java.lang.Math;

public class Calculator {

    //~~~~~~~~~~~~~~~~~~~~~~PARSING METHOD~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String[] parse(String expression){
	expression = expression.replaceAll("[+]" , " + ");
  	expression = expression.replaceAll("[-]", " - ");
	expression = expression.replaceAll("[*]" , " * ");
  	expression = expression.replaceAll("[/]", " / ");
	String[] output = expression.split(" * "); //somehow parses +,-,*,/ ?
	return output;
    }//end of parse()
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //finds the base of every term of the expression
    public static double findBase(String term){
	double retVal = 0;
	int carrot = term.indexOf("^");
	//System.out.println(carrot);
	if (carrot >= 0 && (carrot< term.length())){
	    String base = term.substring(0, carrot);
	    retVal = Double.parseDouble(base);
	}
	return retVal;
    }
    
    //Calculator
    public static double Calculator(String expression){

	double final_output;
	String[] temparray;
	int oneafter;
	double num;

	temparray = parse(expression);
	
	// for (int i =0;i < temparray.length;i++){
	//     System.out.println(temparray[i]);
	// }
	
	//for loop to evaluate all exponents before +,-,*,/
	for (int i = 0; i < temparray.length; i++){
	    //if "^" --> 1. get degree 2. get base number 3. raise base to degree
	    if (temparray[i].indexOf("^") >= 0){
		//System.out.println("carrot");
		double expt = Parser.findDeg(temparray[i]);
		//System.out.println(deg);
		double base = findBase(temparray[i]);
	      	//System.out.println(base);
		double replacement = Math.pow(base,expt);
		//System.out.println(replacement);
		temparray[i] = Double.toString(replacement);
	    }
	}

	final_output = Double.parseDouble(temparray[0]);
	
	for (int i = 0; i < temparray.length; i++){
	    //if "+" --> add() the value at i + 1
	    if (temparray[i].equals("+")){
		//System.out.println("plus spotted");
		oneafter = i + 1;
		num = Double.parseDouble(temparray[oneafter]);
		final_output += num;
	    }
	    //if "-" --> subtract() the value at i + 1
	    if (temparray[i].equals("-")){
		//System.out.println("minus spotted");
		oneafter = i + 1;
		num = Double.parseDouble(temparray[oneafter]);
		final_output -= num;
	    }
	    //if "*" --> multiply() the value at i + 1
	    if (temparray[i].equals("*")){
	     	//System.out.println("mult spotted");
		oneafter = i + 1;
		num = Double.parseDouble(temparray[oneafter]);
		final_output *= num;
	    }
	    //if "/" --> divide() the value at i + 1
	    if (temparray[i].equals("/")){
	      	//System.out.println("divide spotted");
		oneafter = i + 1;
		num = Double.parseDouble(temparray[oneafter]);
		final_output /= num;
	    }
	}
	return final_output;
    }//end Calculator

    public static void calculate(){
	System.out.println("Enter a math expression. \n\t1. Acceptable operations are: +, - , * , / , ^  \n\t2. PEMDAS rules are not yet followed");
	
	String expression = Keyboard.readString();
	
	//if user attempts to input an invalid expression 
	try {
	    double answer = Calculator(expression);
	    System.out.print("Answer: ");
	    System.out.println(answer);


	    System.out.println("\nWould you like to calculate another expression?");
	    System.out.println("Select an option and press enter: \n\t1. Yes  \n\t2. No"); 
	    int choice = Keyboard.readInt();
	   
	    //if user attempts to input a number other than 1 or 2
	    while (choice != 1 && choice !=2){
	    	System.out.println("Please choose an option. Option 1 or 2? \n\t1. Yes  \n\t2. No");
	    	choice = Keyboard.readInt();
	    }
	
	    if (choice == 1){
	    	calculate();
	    } else if (choice == 2) {
	    	System.out.println("Exiting out of calculator");
	    }
	} catch (NumberFormatException e){
	    System.out.println("Invalid expression. Please try again");
	    calculate();
	}
    }
    
    public static void main (String[] args){

	/* // parse() test
	   String[] finalarray;
	
	   finalarray = parse("2 + 1 * 5");
	       
	   for (int i =0;i < finalarray.length;i++){
	   System.out.println(finalarray[i]);
	   }
	*/

	// System.out.println(Calculator("2 + 1 - 5 * 10 / 10"));
	// System.out.println(Calculator("2 * 1 + 5 * 10 - 10"));
	// System.out.println(Calculator("2 - 1 * 5 - 10 / 10"));
	// System.out.println(Calculator("2 / 1 - 5 * 10 / 10"));
	// System.out.println(Calculator("3+1")); //error

	Calculator foo = new Calculator();
	foo.calculate();
	//System.out.println(foo.Calculator(expression));

    }
}
