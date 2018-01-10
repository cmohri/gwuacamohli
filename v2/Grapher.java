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
	_graph = new String[ymax -ymin+1 ][xmax - xmin+1 ];
	filler();
    }

    //overloaded constructor 
    //allows user to determine domain and range for viewing window
    public Grapher(int domain, int range){
	_graph = new String[range][domain];
	filler();
    }

    //overloaded constructor
    //allows user to determine domain and range when not starting from 0
    public Grapher(int xmin, int xmax, int ymin, int max){
    }

    //filler method fills _graph with spaces 
    public void filler(){
	for (int i = 0; i <  ymax; i++){
	    for (int x = 0; x < xmax; x++){
		_graph[i][x] = "  ";
	    }
	}
    }

    //toString method shows contents of _graph
    public String toString() {
        String foo = "";
        for( int i = 0; i < ymax ; i++ ) {
	    //y axis:
	    foo += ymax-i - 1;
	    if (ymax - 1 - i < 10)
		foo += " ";
            foo += "| ";
            for( int j=0; j < xmax; j++ ) {
                foo += _graph[i][j] + " "; 
            }
            foo += "\n";
        }	
	foo += "    ";
	//x axis bar:
	for (int i = xmin; i < xmax; i++){
	    if (i/2 == 0)  
		foo += "–––";
	    else 
	    foo += "––-–";
	}
	foo += "\n";
	//x axis:
	foo += "     ";
	for (int i = xmin; i < xmax; i++){
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
		_graph[ymax-1-y][x] = " •";
	    }
	}
	System.out.println(this);
    }


    public static void main (String[] args){

	Grapher foo = new Grapher();
	//System.out.println(foo);
	foo.grapher();
	//System.out.println(foo);

    }


}