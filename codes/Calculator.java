/* to-do
   1. add user input
   2. create method to parse by * and / --> return output into a new arraylist 
   to evaluate first (PEMDAS) and then parse + evaluate by +/-
   3. what to do w/ exponents??? --> use parser methods??
*/

import java.util.ArrayList;

public class Calculator {

    //~~~~~~~~~~~~~~~~~~~~~~PARSING METHOD~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String[] parse(String preparsing){
	String[] output = preparsing.split(" * "); //somehow parses +,-,*,/ ?
	return output;
    }//end of parse()
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    //Calculator(ArrayList<Object> parsedinput)
    public static double Calculator(String expression){

	double final_output = 0;
	String[] temparray;
	int oneafter;
	int num;

	temparray = parse(expression);
	
	// for (int i =0;i < temparray.length;i++){
	//     System.out.println(temparray[i]);
	// }
	
	//for loop goes through entire parsed array
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

	System.out.println(Calculator("2 + 1 - 5 * 10 / 10"));
	System.out.println(Calculator("2 * 1 + 5 * 10 - 10"));
	System.out.println(Calculator("2 - 1 * 5 - 10 / 10"));
	System.out.println(Calculator("2 / 1 - 5 * 10 / 10"));

	
    }
    
}
