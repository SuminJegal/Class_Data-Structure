
public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph m = new Graph(new String[]
				{"A","B","C","D","E","F","G","H","I","J"});
		
		m.add("A","B",4);
		m.add("A","H",1);
		m.add("A","I",5);
		m.add("B","C",5);
		m.add("B","I",2);
		m.add("C","D",1);
		m.add("C","I",3);
		m.add("C","J",1);
		m.add("D","E",1);
		m.add("D","J",3);
		m.add("E","F",6);
		m.add("E","J",5);
		m.add("F","G",1);
		m.add("F","J",1);
		m.add("G","H",2);
		m.add("G","I",2);
		m.add("G","J",3);
		m.add("H","I",3);
	
		System.out.println(m);
		

		m.kruskal();
		
	}

}
