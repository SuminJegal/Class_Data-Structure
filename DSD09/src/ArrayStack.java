
public class ArrayStack {
	
	private Object[] a;
	private int size=0;
	
	public ArrayStack(int capacity){
		a = new Object[capacity];
	}
	
	public boolean isEmpty() {
		return (size==0);
	}

	public Object peek() {
		if(size==0) throw new IllegalStateException("Stack is empty");
		return a[size-1];
	}

	public Object pop() {
		if(size==0) throw new IllegalStateException("Stack is empty");
		Object object = a[--size];
		a[size] = null;
		return object;
	}

	public void push(Object object) {
		if(size == a.length) resize();
		a[size++] = object;
		
	}

	public int size() {
		return size;
	}
	
	private void resize() {
		Object[] aa = a;
		a = new Object[2*aa.length];
		System.arraycopy(aa, 0, a, 0, size);
	}

}
