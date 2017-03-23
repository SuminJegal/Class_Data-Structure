
public class ArraySet implements SetADT{
	
	private Object[] objects = new Object[1000];
	private int size, i;
	
	public boolean add(Object object){ 
		if(contains(object)==false){
			objects[size++] = object;
			return true;
		}
		else 
			return false;
	}
	
	public boolean contains(Object object){ 
		for(int i=0; i<size; i++)
			if(objects[i] == object) return true;
		return false;
	}
	
	public Object getFirst(){ 
		i=0;
		return objects[i++];
	}
	
	public Object getNext(){
		return objects[i++];
	}
	
	public boolean remove(Object object){
		for(int i=0; i<size; i++)
			if(objects[i]==object){
				System.arraycopy(objects, i+1, objects, i, size-1-i);
				objects[--size]=null;
				return true;
			}
		return false;
	}
	
	public int size(){
		return size;
	}
	
	public void print(){
		for(int i=0; i<size; i++)
			System.out.print(objects[i]+" ");
		System.out.println();
	}

}
