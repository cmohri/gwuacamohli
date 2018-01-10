//Clara Mohri

import java.util.ArrayList;

public class Parser{

    //turns a string array into an ArrayList.
    //this makes it easier to work with array
    //returns ArrayList
    public static ArrayList toAL(String[] ar){
	ArrayList ret = new ArrayList();
	for (String i: ar){
	    ret.add(i);
	}
	return ret;
    }

    //splits based on +, -, /, *
    public static ArrayList makeAL(String eq){
	eq = eq.replaceAll("[+]" , " + ");
	String[] splitted = eq.split(" +");
	ArrayList tester = toAL(splitted);
	return tester;
    }

    //turns the numbers in the array into numbers
    public static void numberize(ArrayList eq){
	for (int i = 0; i < eq.size(); i++ ){
	    Object here = eq.get(i);
	    System.out.println(here);
	    if (here instanceof String){
		
	    }
	}
    }

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
    }

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
    }

    //contains x boolean
    public static boolean hasX(String term){
	return term.indexOf("x") >= 0;
    }

    //precondition: term has x
    //evaluates with an x value
    public static int input(String term, int xval){
	int retVal = xval;
	int deg = findDeg(term);
	while (deg > 1){
	    retVal *= xval;
	    deg -= 1;
	}
	retVal *= findCoeff(term);
	return retVal;
    }


    public static void main (String[] args){
	//testing split method
	/*	String[] ar = "3.25 + 3".split(" ");
	System.out.println(toAL(ar));
	String foo = "33+3+7.0";	
	foo = foo.replaceAll("[+]", " + ");
	System.out.println(foo);
	String[] test = foo.split(" +");
	ArrayList tester = toAL(test);
	System.out.println(tester);

	numberize(tester);

	String eq = "3x^2";
	System.out.println("index of carrot " + eq.indexOf("^"));
	eq = eq.substring(0, 2);
	System.out.println(eq);
	System.out.println("index of x " + eq.indexOf("x"));
	eq = eq.substring(0, 1);
        System.out.println(eq);
	Integer inta = Integer.parseInt("3");
	int degree = 2;

	System.out.println(inta);
	inta += 4;*/
	//System.out.println(split("3x^a+2")); 
	
	String eq1 = "3x^21+x^3";
	System.out.println(eq1);
	System.out.println(makeAL(eq1));
	
	String eq = "3x^2";
	System.out.println("Term: " + eq);
	System.out.println("has x? " + hasX(eq));
	System.out.println("degree: " +findDeg("3x^2"));
	System.out.println("coeff: " + findCoeff("3x^2"));
	System.out.println("input 3: " + input("3x^2", 3)); 

	String eq2 = "2x^10";
	System.out.println(eq2);
	System.out.println(findCoeff(eq2));
	System.out.println(findDeg(eq2));
	System.out.println(input(eq2, 2));
	
	System.out.println("Term: 3");
	System.out.println("degree: " + findDeg("3"));
	System.out.println("coeff: " + findCoeff("3"));
	

    }
    
}