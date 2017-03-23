
public class TestBag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBag a = new ArrayBag();
		a.add("CA");
		a.add("US");
		a.add("MX");
		a.add("RU");
		a.add("US");
		a.add("MX");
		
		System.out.println("다른 원소의 값은 : "+a.diffsize());
		System.out.println("원소의 갯수는 : "+a.size());
		a.print();
		
		a.remove("CA"); 
		a.remove("US");
		a.remove("MX");
		
		System.out.println("다른 원소의 값은 : "+a.diffsize());
		System.out.println("원소의 갯수는 : "+a.size());
		a.print();
		
		a.add("AR");
		
		System.out.println("다른 원소의 값은 : "+a.diffsize());
		System.out.println("원소의 갯수는 : "+a.size());
		a.print();
		
		a.add("AR");
		a.add("RU");
		a.add("SC");
		
		System.out.println("다른 원소의 값은 : "+a.diffsize());
		System.out.println("원소의 갯수는 : "+a.size());
		a.print();
		
		a.remove("AR"); 
		
		System.out.println("다른 원소의 값은 : "+a.diffsize());
		System.out.println("원소의 갯수는 : "+a.size());
		a.print();
	}
	
	

}
