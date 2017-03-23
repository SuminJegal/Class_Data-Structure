import java.util.ArrayList;


public class ArrayListQueue extends ArrayList{

	
	public void addd(Object object) {
		
		add(size(), object);
	}


	public Object first() {
		
		Object temp = get(0);
		return temp;
	}


	public Object remove() {
		
		Object temp = remove(0);
		return temp;
	}


	public int size() {
		
		return super.size();
	}

	public void print() {
		for(int i=0; i<size(); i++){
			System.out.print(get(i)+" ");
		}
		System.out.println();
	}


}
