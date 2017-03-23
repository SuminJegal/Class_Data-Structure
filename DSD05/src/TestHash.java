
public class TestHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashTable h = new HashTable(17);
		HashTable i = new HashTable(17);
		HashTable j = new HashTable(17);
		
		System.out.println("Linear Probing : ");
		h.put_linear("AT", new Country("Austria","German",32378, 8139299));
		h.put_linear("BE", new Country("Belgium","Dutch",168754, 10182034));
		h.put_linear("DE", new Country("Germany","German",636000, 82087361));
		h.put_linear("DK", new Country("Denmark","Danish",18859, 5356845));
		h.put_linear("ES", new Country("Spain","Spanish",3851800, 39167744));
		h.put_linear("FR", new Country("France","French",679400, 58978172));
		h.put_linear("IT", new Country("Italy","ltalian",116300, 56735130));
		h.put_linear("LU", new Country("Luxembourg","French", 998, 429080));
		h.put_linear("SE", new Country("Sweden","Portuguese",35672, 9918040));
		h.printCollision();
		
		System.out.println("Quadratic Probing : ");
		i.put_quadratic("AT", new Country("Austria","German",32378, 8139299));
		i.put_quadratic("BE", new Country("Belgium","Dutch",168754, 10182034));
		i.put_quadratic("DE", new Country("Germany","German",636000, 82087361));
		i.put_quadratic("DK", new Country("Denmark","Danish",18859, 5356845));
		i.put_quadratic("ES", new Country("Spain","Spanish",3851800, 39167744));
		i.put_quadratic("FR", new Country("France","French",679400, 58978172));
		i.put_quadratic("IT", new Country("Italy","ltalian",116300, 56735130));
		i.put_quadratic("LU", new Country("Luxembourg","French", 998, 429080));
		i.put_quadratic("SE", new Country("Sweden","Portuguese",35672, 9918040));
		i.printCollision();
		
		System.out.println("Double Probing : ");
		j.put_double("AT", new Country("Austria","German",32378, 8139299));
		j.put_double("BE", new Country("Belgium","Dutch",168754, 10182034));
		j.put_double("DE", new Country("Germany","German",636000, 82087361));
		j.put_double("DK", new Country("Denmark","Danish",18859, 5356845));
		j.put_double("ES", new Country("Spain","Spanish",3851800, 39167744));
		j.put_double("FR", new Country("France","French",679400, 58978172));
		j.put_double("IT", new Country("Italy","ltalian",116300, 56735130));
		j.put_double("LU", new Country("Luxembourg","French", 998, 429080));
		j.put_double("SE", new Country("Sweden","Portuguese",35672, 9918040));
		j.printCollision();
	}

}
