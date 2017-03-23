
public class TestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArraySet a = new ArraySet();
		a.add("CA");
		a.add("US");
		a.add("MX");
		a.add("RU");
		a.add("US");
		a.add("MX");
		
		System.out.println(a.size());
		a.print();
		
		a.remove("CA");
		a.remove("US");
		a.remove("MX");
		
		System.out.println(a.size());
		a.print();
		a.add("AR");
		
		ArraySet b = new ArraySet();
		b.add("AR");
		b.add("RU");
		b.add("SC");

		if(TestEqualSet.equalSet(a, b)==true)
			System.out.println("µÎ °´Ã¼°¡ °°½À´Ï´Ù.");
		else if(TestEqualSet.equalSet(a, b)==false)
			System.out.println("µÎ °´Ã¼°¡ ´Ù¸¨´Ï´Ù.");
	}


	
}
