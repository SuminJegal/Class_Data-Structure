import java.util.ArrayList;


public class ArrayListStack extends ArrayList{
	

	public Object peek() {
		Object temp = get(size()-1);
		return temp;
	}


	public Object pop() {
		Object temp = remove(size()-1);
		return temp;
	}


	public void push(Object object) {
		add(size(), object);
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
