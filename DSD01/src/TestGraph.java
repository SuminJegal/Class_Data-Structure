
public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MatrixGraph m = new MatrixGraph(new String[]
				{"SE","UK","DE","FR","CZ","CH","AT","IT"});
		
		System.out.println(m);
		
		m.add("SE","UK");
		m.add("SE","DE");
		m.add("UK","FR");
		m.add("DE","FR");
		m.add("DE","IT");
		m.add("DE","CZ");
		m.add("CH","FR");
		m.add("CH","IT");
		m.add("CH","AT");
		
		
		m.dfs();
		
		LinkedGraph l = new LinkedGraph(new String[]
				{"SE","UK","DE","FR","CZ","CH","AT","IT"});
		
		System.out.println(l);
		
		l.add("SE","UK");
		l.add("SE","DE");
		l.add("UK","FR");
		l.add("DE","FR");
		l.add("DE","IT");
		l.add("DE","CZ");
		l.add("CH","FR");
		l.add("CH","IT");
		l.add("CH","AT");
		
		l.dfs();
		

	}

}
