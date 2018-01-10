//Jessica Wu

import java.util.ArrayList;

public class Calculator {
    //instance vars
    double final_output;
    Parser parse = new Parser();

    //default constructor
    //if select calulcate, 
    public ArrayList<Object> Calculator(String expression){
	ArrayList alInput = parse.toAl(expression);
	parse.makeAl();
    }//end default constructor
    
    //~~~~~~~~~~~~~~~~~~~~~~ BASIC OPERATIONS~~~~~~~~~~~~~~~~~~~~~~
    //add()
    //implemented if a "+" is spotted in parsed input 
    //the value at the next index is added to final_output
    public void add(){
	/* IMPLEMENTATION */
    }
    
    //subtract()
    //implemented if a "-" is spotted in parsed input 
    //the value at the next index is subtracted from final_output
    public void subtract(){
       /* IMPLEMENTATION */
    }//end subtract() 
    
    //multiply()
    //implemented if a "*" is spotted in parsed input 
    //the value at the next index is multiplied to final_output
    public void multiply(){
	/* IMPLEMENTATION */
    }//end multiply()
    
    //divide()
    //implemented if a "/" is spotted in parsed input 
    //the final_output is divided by the value at the next index 
    public void divide(){
       /* IMPLEMENTATION */
    }//end divide()
    
    //exponent()
    //implemented if a "^" is spotted in parsed input
    //the final_project is raised to the power of the value of the next index 
    public void exponent(){
       /* IMPLEMENTATION */
    }//end exponent()
    
    //Calculator(ArrayList<Object> parsedinput)
    public void Calculator(ArrayList<Object> parsedinput){
	/* IMPLEMENTATION */
    }//end Calculator
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~ GRAPH CALCULATIONS ~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~ TABLE STATISTICS ~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public static void main (String[] args){
	//ArrayList<Object> test1 = new ArrayList<Object>(1,"+",5,"-",2,"*",10,"/",10,"^",2);
	ArrayList<Object> test2 = new ArrayList<Object>();
	test2.add(2);
    }
    
}
