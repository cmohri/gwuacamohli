//Clara Mohri

import java.io.FileWriter;
import java.io.File;
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
	ymax = 20;
	xmin = -10;
	ymin = -10;
	_graph = new String[ ymax - ymin + 1 ][ xmax - xmin + 1 ];
	filler();
    }

    //overloaded constructor 
    //allows user to determine domain and range for viewing window
    public Grapher(int domain, int range){
	xmin = 0;
	ymin = 0;
	xmax = domain;
	ymax = range;
	_graph = new String[ymax -ymin+1 ][xmax - xmin+1 ];
	filler();
    }

    //overloaded constructor
    //allows user to determine domain and range when not starting from 0
    public Grapher(int xmini, int xmaxi, int ymini, int ymaxi){
	xmin = xmini;
        ymin = ymini;
        xmax = xmaxi;
        ymax = ymaxi;
        _graph = new String[ymax -ymin+1 ][xmax - xmin+1 ];
        filler();
    }

    //filler method fills _graph with spaces 
    public void filler(){
	for (int i = 0; i < _graph.length; i++){
	    for (int x = 0; x < _graph[i].length; x++){
		_graph[i][x] = "  ";
	    }
	}
    }

    //toString method shows contents of _graph
    public String toString() {
        String foo = "";
	//user's equation: 
	foo += equation;
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
    }

    //method graphs.
    public void grapher(){
	System.out.println("Enter desired equation. \n\t1. Must be in terms of x\n\t2. Be careful with spaces");
	System.out.print("y= ");
	String eq = Keyboard.readString();
	equation = eq;
	for (int x = xmin; x <= xmax; x++){
	    //System.out.print("x: " + x + ", ");
	    int y = Parser.input(eq, x);
	    //System.out.println("y: " + y); 
	    if (y <= ymax && y >= ymin){
		//System.out.println("\twill be plotted");
		_graph[ ymax-y ][ x-xmin] = " •";
		//System.out.println("\t[" + (ymax-y) + "]" + "[" +(x-xmin) + "]");
	    }
	}
	System.out.println(this);
	//printOut();
	System.out.println("1. Download graph\n2. Change domain/range\n3. Customize domain/range");
	int selection = Keyboard.readInt();

    }

    /*
    public void printOut(){
	for (String[] i: _graph){
	    for (String x: i){
		System.out.print(x);
		    }
	}
	}*/

    public static void main (String[] args){

	Grapher foo = new Grapher();
	foo.grapher();
	//System.out.println(foo);

    }


}