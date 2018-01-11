//Clara Mohri

import cs1.Keyboard;
import java.lang.Math;

public class Grapher    
{
    //instance variables:
    private String[][] _graph;
    private int xmax;
    private int ymax;
    private int xmin;
    private int ymin;

    //default constructor
    public Grapher(){
	xmax = 10;
	ymax = 25;
	xmin = 0;
	ymin = 0;
	_graph = new String[ymax -ymin+2 ][xmax - xmin+2 ];
	filler();
    }

    //overloaded constructor 
    //allows user to determine domain and range for viewing window
    public Grapher(int domain, int range){
	xmin = 0;
	ymin = 0;
	xmax = domain;
	ymax = range;
	_graph = new String[ymax -ymin+2 ][xmax - xmin+2 ];
	filler();
    }

    //overloaded constructor
    //allows user to determine domain and range when not starting from 0
    public Grapher(int xmini, int xmaxi, int ymini, int ymaxi){
	xmin = xmini;
        ymin = ymini;
        xmax = xmaxi;
        ymax = ymaxi;
        _graph = new String[ymax -ymin+2 ][xmax - xmin+2 ];
        filler();
    }

    //filler method fills _graph with spaces 
    public void filler(){
	for (int i = 0; i <=  ymax; i++){
	    for (int x = 0; x <= xmax; x++){
		_graph[i][x] = "  ";
	    }
	}
    }

    //toString method shows contents of _graph
    public String toString() {
        String foo = "";
        for( int i = ymin; i <= ymax ; i++ ) {
	    //y axis:
	    foo += ymax-i;
	    if (ymax  - i < 10 && ymax-i >-1)
		foo += " ";
            foo += "| ";
            for( int j=0; j < xmax; j++ ) {
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
	//x axis:
	foo += "     ";
	for (int i = xmin; i <= xmax; i++){
	    foo += i;
	    foo += "  ";
	}
	foo += "\n";

        return foo;
    }

    //method graphs.
    public void grapher(){
	System.out.println("Enter desired equation. \n\t1. Must be in terms of x\n\t2. Be careful with spaces");
	System.out.print("y= ");
	String eq = Keyboard.readString();
	for (int x = xmin; x < xmax; x++){
	    int y = Parser.input(eq, x);
	    if (y < ymax && y >= ymin){
		_graph[ymax-y][x] = " •";
	    }
	}
	System.out.println(this);
    }


    public static void main (String[] args){

	Grapher foo = new Grapher(/*-10,10, -10,10*/);
	//System.out.println(foo);
	foo.grapher();
	//System.out.println(foo);

    }


}