import java.util.Scanner;
import java.io.PrintWriter;
import cs1.Keyboard;
import java.lang.Math;

public class Grapher    
{
    //instance variables:
    public String[][] _graph;
    public String equation;
    public int xmax;
    public int ymax;
    public int xmin;
    public int ymin;

    //default constructor
    public Grapher(){
	xmax = 10;
	ymax = 10;
	xmin = -10;
	ymin = -10;
	_graph = new String[ ymax - ymin + 1 ][ xmax - xmin + 1 ];
	filler();
    }//end Grapher()

    //filler method fills _graph with spaces 
    public void filler(){
	for (int i = 0; i < _graph.length; i++){
	    for (int x = 0; x < _graph[i].length; x++){
		_graph[i][x] = "  ";
	    }
	}
    }//end filler()

    //toString method shows contents of _graph
    public String toString() {
        String foo = "";
	//user's equation: 
	foo += "y = " + equation + "\n\n";
	    foo += "\n";
	    for( int i = 0 ; i < _graph.length ; i++ ) {
	    //y axis:
	    //ensures spacing is good, so that the y axis can appear to be a straight line
	    foo += ymax-i;
	    if (ymax  - i < 10 && ymax-i >-1)
		foo += "  ";
	    else if (ymax - i <= -10){}		
	    else foo += " ";
            foo += "| ";

	    //retrieving data from _graph
            for( int j= 0; j < _graph[i].length ; j++ ) {
                foo += _graph[i][j] + " "; 
            }
            foo += "\n";
        }	
	foo += "    ";
	//x axis bar:
	for (int i = xmin; i <= xmax; i++){
	    if (i/2 == 0)  
		foo += "–––";
	    else 
	    foo += "––-–";
	}
	foo += "\n";
	//x axis numbers:
	foo += "      ";
	for (int i = xmin; i <= xmax; i++){
	    foo += i;
	    //proper spacing procedures:
	    if (i >= 0 && i < 10){
		foo += "  ";
	    }
	    else if (i <= -10){
		foo += "";
	    }
	    else foo += " ";
	}
	foo += "\n";

        return foo;
    }//end toString()

    //method graphsthe function that is entered
    public void plotPoints(){
	System.out.println("Enter desired equation. \n\t1. Must be in terms of x\n\t2. Be careful with spaces");
	System.out.print("y= ");
	String eq = Keyboard.readString();
	equation = eq;
	for (int x = xmin; x <= xmax; x++){
	    int y = Parser.input(eq, x);
	    if (y <= ymax && y >= ymin){
		_graph[ ymax-y ][ x-xmin] = " •";
	    }
	}
	System.out.println(this);
	driver();
    }//end plotPoints()

    //when the equation has already been set as an instance variable. Used by setViewing()
    public void plotPoints(String eq){
	System.out.println(equation);
        for (int x = xmin; x <= xmax; x++){
            int y = Parser.input(eq, x);
            if (y <= ymax && y >= ymin){
                _graph[ ymax-y ][ x-xmin] = " •";
            }
        }
        System.out.println(this);
    }//end plotPoints(String eq)

    //allows user to change the viewing window
    public void setViewing(){
	//display current viewing window:
	System.out.println("Current viewing window:");
	System.out.println("xmin: " + xmin);
	System.out.println("xmax: " + xmax);
	System.out.println("ymin: " + ymin);
	System.out.println("ymax: " + ymax + "\n");
	System.out.println("Enter in the values for new viewing window. Values must be integers, and the absolute value of every input must be less than or equal to 20.");
	//set new viewing window
	setXmin();
	setXmax();
	setYmin();
	setYmax();
	_graph = new String[ymax-ymin + 1][xmax - xmin + 1]; 
	filler();
	plotPoints(equation);	
	driver();
    }//end setViewing()
    
    //set instance variable xmin
    public void setXmin(){
	System.out.print("xmin: ");
        int xmini = Keyboard.readInt();
        while (Math.abs(xmini) > 20){
            System.out.println("\tInput number with absolute value <= 20.");
            System.out.print("xmin: " );
            xmini = Keyboard.readInt();
        }
	xmin = xmini;
    }//end setXmin()

    //set instance variable xmax
    public void setXmax(){
	System.out.print("xmax: ");
        int xmaxi = Keyboard.readInt();
        while (Math.abs(xmaxi) > 20 || xmaxi <= xmin){
            System.out.println("\tInput number with absolute value <= 20, and must be greater than xmin");
            System.out.print("xmax: " );
            xmaxi = Keyboard.readInt();
        }
	xmax = xmaxi;
    }//end setXmax()

    //set instance variable ymin
    public void setYmin(){
	System.out.print("ymin: ");
        int ymini = Keyboard.readInt();
        while (Math.abs(ymini) > 20){
            System.out.println("\tInput number with absolute value <= 20.");
            System.out.print("ymin: " );
            ymini = Keyboard.readInt();
        }
	ymin = ymini;
    }//end setYmin()

    //set instance variable ymax
    public void setYmax(){
	System.out.print("ymax: ");
        int ymaxi = Keyboard.readInt();
        while (Math.abs(ymaxi) > 20 || ymaxi <= ymin){
            System.out.println("\tInput number with absolute value <= 20, and must be greater than ymin");
            System.out.print("ymax: " );
            ymaxi = Keyboard.readInt();
        }
	ymax = ymaxi;
    }//end setYmax()

    //method calculates zeroes within the domain using a for-loop
    //precondition: equation has already been defined
    public void calcZeroes() {
	String printStr = "zeroes: ";
	for (int x = -2^10; x < Math.pow(2, 10); x++){
            int y = Parser.input(equation, x);
            if (y == 0){
                printStr += (x + ", ");
            }
        }
	//get rid of any additional commas:
	if (printStr.length() > 8) 
	    printStr = printStr.substring(0, printStr.length() - 2);
	System.out.println(printStr);
	driver();
    }//end calcZeroes()

    //method calculates y intercept by inputting 0 as the x value in the equation
    public void calcYInt() {
	String printStr = "y-intercept: ";
	int yint = Parser.input(equation, 0);
	printStr += yint;
	System.out.println(printStr);
    }//end calcYInt()

    //method allows user to download toString() of graph to a text file called equation + "graph.txt"
    //the graph will be downloaded to the same directory as wherever this code is stored.
    public void download(){
	System.out.println("Downloading " + equation + "_graph.txt...");
	try{
	    PrintWriter writer = new PrintWriter(equation + "_graph.txt", "UTF-8");
	    writer.println(this.toString());
	    writer.close();
	    System.out.println("Succesfully downloaded " + equation + "_graph.txt!");
	} catch (Exception e){ System.out.println("Unable to download.");}
	driver();
    }//end download
	
    //driver method combines everything for user 
    public void driver() {
	System.out.println("\n---------------------------------------\n1. Customize viewing window\n2. Calculate x- and y-intercepts\n3. Download graph\n4. View table\n5. Input new equation\n6. Exit");
	int userInput = Keyboard.readInt();
	while (userInput < 1 || userInput > 5){
	    System.out.println("Please input a valid selection");
	    userInput = Keyboard.readInt();
	}	
	if (userInput == 1)
	    setViewing();
	else if (userInput == 2){
	    calcYInt();
	    calcZeroes();
	}
	else if (userInput == 3)
	    download();
	else if (userInput == 4)
	    System.out.println("table");
	else if (userInput == 5){
	    filler();
	    plotPoints();
	}
	else {return;}
    }//end driver()

    //main method
    public static void main (String[] args) {
	Grapher foo = new Grapher();
	foo.plotPoints();
	foo.driver();
    }//end main method
}