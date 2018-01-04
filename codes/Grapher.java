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
	xmax = 9;
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

    //User is asked what degree
    public void degree(){
	System.out.print("What degree equation?");
	int degree = Keyboard.readInt();
	System.out.println("You've chosen degree: "+ degree);
	if (degree == 0){
	    System.out.print("Equation: y = ");
	    double a = Keyboard.readDouble();
	    grapher(a);
	}
	else if (degree == 1){
	    System.out.println("Equation in the form y = ax + b");
	    System.out.print("a: ");
	    double a = Keyboard.readDouble();
	    System.out.print("b: ");
	    int b = Keyboard.readInt();
	    System.out.println("Equation: y = " + a + "x + " + b);
	    grapher(a, b); 
	}
	else if (degree == 2){
	    System.out.println("Equation in the form y = ax^2 + bx + c");
	    System.out.print("a: ");
            int a = Keyboard.readInt();
            System.out.print("b: ");
            int b = Keyboard.readInt();
	    System.out.print("c: ");
	    int c = Keyboard.readInt();
            System.out.println("Equation: y = " + a + "x^2 + " + b + "x + " + c);
            grapher(a, b, c);
	}
	else if (degree == 3){
	    System.out.println("Equation in the form y = ax^3 + bx^2 + cx + d");
            System.out.print("a: ");
            int a = Keyboard.readInt();
            System.out.print("b: ");
            int b = Keyboard.readInt();
            System.out.print("c: ");
            int c = Keyboard.readInt();
	    System.out.print("d: ");
            int d = Keyboard.readInt();
            System.out.println("Equation: y = " + a + "x^3 + " + b + "x^2 + " + c + "x + " + d);
            grapher(a, b, c, d );
	}
	System.out.println(this);
    }

    public void grapher(double a){
	for (int x = xmin; x < xmax; x++){
            int y = (int)a ;
            if (y < ymax && y >= ymin){
                _graph[ymax- 1- y][x] = " •";
            }
        }
    }

    //graphing method inputs asterisks to indicate points on a function
    //for linear functions
    public void grapher(double a, double b){
	for (int x = xmin ; x < xmax ; x++){
	    int y = (int)(a*x + b) ;
	    if (y < ymax && y >= ymin){
		_graph[ymax- 1- y][x] = " •";
	    }
	}
    }

    //graphing method inputs asterisks to indicate points on a function
    //for quadratic functions
    public void grapher(double a, double b, double c){
	for (int x = xmin; x < xmax; x++){
            int y = (int)(a*x*x + b*x + c) ;
            if (y < ymax && y >= ymin){
                _graph[ymax- 1- y][x] = " •";
            }
        }
    }

    //for third degree functions
    public void grapher(double a, double b, double c, double d){
        for (int x = xmin; x < xmax; x++){
            int y = (int)(a*x*x*x + b*x*x + c*x + d) ;
            if (y < ymax && y >= ymin){
                _graph[ymax- 1- y][x] = " •";
            }
        }
    }

    public static void main (String[] args){

	Grapher foo = new Grapher();
	//System.out.println(foo);
	foo.degree();
	//System.out.println(foo);

    }


}