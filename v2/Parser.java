//Gwuacamohli

import cs1.Keyboard;
import java.util.ArrayList;

public class Parser {

    //turns a string array into an ArrayList.
    //this makes it easier to work with array
    //returns ArrayList
    public static ArrayList<String> toAL(String[] ar){
	ArrayList<String> ret = new ArrayList();
	for (String i: ar){
	    ret.add(i);
	}
	return ret;
    }//end toAL(String[] ar)

    //splits based on +, -, /, *
    public static ArrayList<String> makeAL(String eq){
	//this also works to split with minus signs... 
	eq = eq.replaceAll("[+]" , " + ");
	eq = eq.replaceAll("[-]", " - ");
	String[] splitted = eq.split(" +");	
	ArrayList tester = toAL(splitted);
	return tester;
    }//end ArrayList<String> makeAL(String eq)

    //finds the degree of every part of the equation
    public static int findDeg(String term){
	int retVal = 0;
	int carrot = term.indexOf("^");
	//System.out.println(carrot);
	if (carrot >= 0 && (carrot< term.length())){
	    String degree = term.substring(carrot+1, term.length());
	    retVal = Integer.parseInt(degree);
	}
	return retVal;
    }//end findDeg(String term)

    //replaces x with a value
    public static int findCoeff(String term){
	int retVal = 1;
	if (hasX(term) && term.indexOf("x") > 0){
	    String coeff = term.substring(0, term.indexOf("x"));
	    retVal = Integer.parseInt(coeff);
	}
	if (! hasX(term)){
	    String coeff = term;
	    retVal = Integer.parseInt(coeff);
	}
	return retVal;
    }//end findCoeff(String term)

    //contains x boolean
    public static boolean hasX(String term){
	return term.indexOf("x") >= 0;
    }//end hasX(String term)

    //precondition: term has x
    //evaluates with an x value
    public static int termInput(String term, int xval){
	if (hasX(term)){
	    int retVal = xval;
	    int deg = findDeg(term);
	    while (deg > 1){
		retVal *= xval;
		deg -= 1;
	    }
	    retVal *= findCoeff(term);
	    return retVal;
	}
	else return findCoeff(term);
    }//end termInput(String term, int xval)

    //precondition: ArrayList with terms in x
    //postcondition: all the terms are evaluated for a certain x
    //               Because the ArrayList now contains both Strings and ints,
    //               a new ArrayList is created and returned to allow this
    public static ArrayList eqCalc(ArrayList<String> eq, int xval)  {
	ArrayList eval = new ArrayList();

	for (int i = 0; i < eq.size(); i++){
	    String item = eq.get(i);
	    if (hasX( item )){
		int val = termInput( item , xval);
		eval.add(val);
	    }
	    else { 
		try {
		    int val = termInput(item, xval);
		    eval.add(val);
		}
		catch(Exception e)   {  eval.add( item );}
	    }
	}
	return eval;
    }//end eqCalc(ArrayList<Stirng> eq, int xval)

    //precondition: an ArrayList with only ints and operations
    //              evaluates if addition/substraction is necesary
    //postcondition: evaluated to one int, which is returned
    public static int eval(ArrayList nums){
	int retVal = 0;
	for (int i = 0; i < nums.size(); i++){
	    if (nums.get(i) instanceof Integer){

		int x = (int)nums.get(i);
		if (i >0 && nums.get(i-1).equals("+")){
		    retVal += x;

		}
		else if (i > 0 && nums.get(i-1).equals("-")){
		    retVal -= x;
		}
		else {
		    retVal += x;

		}
	    }
	}
	return retVal;
    }//end eval(ArrayList nums)

    //precondition: an equation in terms of x is inputted as a String
    //              an xval is inputted that must be calcualted for the equation
    //postcondition: this value is returned
    public static int input(String eq, int xval){
	ArrayList<String> ar = makeAL(eq);
	ArrayList calcd = eqCalc(ar, xval);
	return eval( calcd);
    }//end input(String eq, int xval)

	//sorts a String input into a int, double, or String output
	public static Comparable input() {
		String in;
		Comparable output;

		in = Keyboard.readString();

        try {
            output = (int) Integer.parseInt(in);
        }
        catch (Exception e) { 
            output = (double) Double.parseDouble(in);
        }
		return output;
	}

    public static void main (String[] args){
	/*
	String eq1 = "3x^3+x^2+3";
	System.out.println(eq1);
	int finalval = input(eq1, -1);
	System.out.print("input -1: ");
	System.out.println(finalval);

	String eq2= "3x^2";
	System.out.println(eq2);
	System.out.print("input 0: ");
	System.out.println(input(eq2, 0));

	String eq3= "5+5+5";
	System.out.println(eq3);
	System.out.print("input 0: ");
	System.out.println(input(eq3, 0));
	*/
    }
    
}