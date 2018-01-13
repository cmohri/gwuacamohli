public class Table extends Grapher{
    
    private String _table = "  x  |  y\n––––––––––––\n";
    private String equation = "3x";


    public Table(int xmini, int xmaxi){
	xmin = xmini;
        xmax = xmaxi;
    }
	
    public void fillOut(){
	for (int x = xmin; x <= xmax; x++){
	    int y = Parser.input(equation, x);
	    _table += "  " + x + "  |  " + y;
	    _table += "\n";
	}
    }  


    public String toString(){
	return _table;
    }


    public static void main (String[] args){

	Table boo = new Table(0, 3);
	boo.fillOut();
	System.out.println(boo);
    }

   
}