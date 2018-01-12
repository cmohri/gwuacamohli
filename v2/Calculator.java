/* to-do
   1. create method to parse by * and / --> return output into a new arraylist 
   to evaluate first (PEMDAS) and then parse + evaluate by +/-
*/

import cs1.Keyboard;
import java.lang.Math;

public class Calculator {

    //~~~~~~~~~~~~~~~~~~~~~~PARSING METHOD~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String[] parse(String preparsing){
	String[] output = preparsing.split(" * "); //somehow parses +,-,*,/ ?
	return output;
    }//end of parse()
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //finds the base of every term of the expression
    public static int findBase(String term){
	int retVal = 0;
	int carrot = term.indexOf("^");
	//System.out.println(carrot);
	if (carrot >= 0 && (carrot< term.length())){
	    String base = term.substring(0, carrot);
	    retVal = Integer.parseInt(base);
	}
	return retVal;
    }
    
    //Calculator
    public static double Calculator(String expression){

	int final_output;
	String[] temparray;
	int oneafter;
	int num;

	temparray = parse(expression);
	
	// for (int i =0;i < temparray.length;i++){
	//     System.out.println(temparray[i]);
	// }
	
	//for loop goes through entire parsed array
	for (int i = 0; i < temparray.length; i++){
	    //if "^" --> 1. get degree 2. get base number 3. raise base to degree
	    if (temparray[i].indexOf("^") >= 0){
		//System.out.println("carrot");
		int expt = Parser.findDeg(temparray[i]);
		//System.out.println(deg);
		int base = findBase(temparray[i]);
	      	//System.out.println(base);
		int replacement = (int)( Math.pow(base,expt));
		//System.out.println(replacement);
		temparray[i] = Integer.toString(replacement);
	    }
	}

	final_output = Integer.parseInt(temparray[0]);
	
	for (int i = 0; i < temparray.length; i++){
	    //if "+" --> add() the value at i + 1
	    if (temparray[i].equals("+")){
		//System.out.println("plus spotted");
		oneafter = i + 1;
		num = Integer.parseInt(temparray[oneafter]);
		final_output += num;
	    }
	    //if "-" --> subtract() the value at i + 1
	    if (temparray[i].equals("-")){
		//System.out.println("minus spotted");
		oneafter = i + 1;
		num = Integer.parseInt(temparray[oneafter]);
		final_output -= num;
	    }
	    //if "*" --> multiply() the value at i + 1
	    if (temparray[i].equals("*")){
	     	//System.out.println("mult spotted");
		oneafter = i + 1;
		num = Integer.parseInt(temparray[oneafter]);
		final_output *= num;
	    }
	    //if "/" --> divide() the value at i + 1
	    if (temparray[i].equals("/")){
	      	//System.out.println("divide spotted");
		oneafter = i + 1;
		num = Integer.parseInt(temparray[oneafter]);
		final_output /= num;
	    }
	}
    

	return final_output;
    }//end Calculator
    
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
	//	System.out.println(Calculator("3+1"));

	Calculator foo = new Calculator();
	System.out.println("Enter a math expression. \n\t1. Place a space between each operation (+,-,*,/). Make sure you don't have an extra space at the end! \n\t2. If you wish to use exponents, don't include spaces between the base, '^', and exponent. For example: 3^2"); 
	String expression = Keyboard.readString();
	//int deg = Parser.findDeg(expression);
	//System.out.println(deg);
	System.out.println(foo.Calculator(expression));
    }
    
}
