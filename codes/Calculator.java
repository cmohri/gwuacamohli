/* to-do
1. add user input
2. finish Calulcator
3. create method to parse by * and / --> return output into a new arraylist 
to evaluate first (PEMDAS) and then parse + evaluate by +/-
*/

import java.util.ArrayList;

public class Calculator {
    //instance vars
    double final_output;
    Parser parse = new Parser();

    //~~~~~~~~~~~~~~~~~~~~~~PARSING METHODS~~~~~~~~~~~~~~~~~~~~~~~~
    //parses by *
    //parses by /
    


    //default constructor
    //if select calulcate, 
    public ArrayList<Object> conversion(String expression){
	ArrayList alInput = parse.toAl(expression);
	parse.makeAl();
    }//end default constructor
    
    //~~~~~~~~~~~~~~~~~~~~~~ BASIC OPERATIONS~~~~~~~~~~~~~~~~~~~~~~
    //add()
    //implemented if a "+" is spotted in parsed input 
    //the value at the next index is added to final_output
    public void add(ArrayList<Object> parsed, int index){
	final_output += parsed[index];
    }
    
    //subtract()
    //implemented if a "-" is spotted in parsed input 
    //the value at the next index is subtracted from final_output
    public void subtract(ArrayList<Object> parsed, int index){
	final_output -= parsed[index];
    }//end subtract() 
    
    //multiply()
    //implemented if a "*" is spotted in parsed input 
    //the value at the next index is multiplied to final_output
    public void multiply(ArrayList<Object> parsed, int index){
	final_output *= parsed[index];
    }//end multiply()
    
    //divide()
    //implemented if a "/" is spotted in parsed input 
    //the final_output is divided by the value at the next index 
    public void divide(ArrayList<Object> parsed, int index){
	final_output /= parsed[index];
    }//end divide()
    
    //exponent()
    //implemented if a "^" is spotted in parsed input
    //the final_project is raised to the power of the value of the next index 
    public void exponent(ArrayList<Object> parsed, int index){
	final_output = final_output ** parsed[index];
    }//end exponent()
    
    //Calculator(ArrayList<Object> parsedinput)
    public double Calculator(ArrayList<Object> parsedinput){
	final_output = 0;

	//for loop goes through entire parsed array

	//if "+" --> add() the value at i + 1
	//if "-" --> subtract() the value at i + 1
	//if "*" --> multiply() the value at i + 1
	//if "/" --> divide() the value at i + 1
	//if "^" --> exponent() the value at i + 1
 
	return final_output;
    }//end Calculator
    
    public static void main (String[] args){
	
    }
    
}
