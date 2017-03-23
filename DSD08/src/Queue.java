
public class Queue{
	private static final int MAX_SIZE = 30;
	private int front = 0,rear = 0;
	private int size=0;
	Object obj[] = new Object[MAX_SIZE];
	
	
	public Queue(){
		front = 0;
		rear = 0;
	}
	
	public void add(Object object) {
		if((rear + 1)%MAX_SIZE == front){
			System.out.println("ť�� Full");
		}
		else {
			obj[rear] = object;
			rear = (rear+1) % MAX_SIZE;
			size++;
		}
		// TODO Auto-generated method stub
	}

	public Object first() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object remove() {
		
		if(isEmpty()){
			System.out.println("ť�� empty.");
			System.out.println("---------");
			return null;
		} else {
			Object removeObj = obj[front];
			obj[front] = null;
			front = (front+1)%MAX_SIZE;
			size--;
			return removeObj;
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public void print(){
		for(int i = 0; i< obj.length; i++){
		System.out.print(obj[i] +" ");
		}
		System.out.println("");
	}
	
	public boolean isEmpty(){
		return front == rear ? true : false;
	}
	
}

