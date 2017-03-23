
public class CircularQueue implements Queue{
	private Object[ ] a; 
	private Object temp;
	private int front =0, rear=0; 
	
	public CircularQueue(int capacity) { 
		a = new Object[capacity];  
		} 
	
	public void add(Object object) {    
		if(isFull()==true) 
			System.out.println("connot add "+ object +" : queue is full"); 
		else{
			rear = (rear+1)%a.length;
			a[rear] = object;
			System.out.println("add : " + a[rear]);
			print();
		}
	} 
	
	public Object first() {    
		if(isEmpty()==true) {
			System.out.println("cannot first : queue is empty"); 
			return null;
		}
		else{
			System.out.println("first : " + a[(front+1)%a.length]);
			print();
			return a[(front+1)%a.length];
		}
	}
	
	public Object remove() {  
		if(isEmpty()==true) {
			System.out.println("cannot remove : queue is empty");
			return null;
		}
		else{
			front = (front+1)%a.length;
			System.out.println("remove : " + a[front]);
			temp = a[front];
			a[front] = null;
			print();
			return temp;
		}
	} 
	
	public int size() {   
		if(rear>=front) return rear-front;
		else return(rear)+(a.length-front);
	}
	
	public boolean isEmpty() {    
		return (front == rear);
	} 
	
	public boolean isFull() {
		return (((rear+1)%a.length)==front);
	}
	
	public void print(){
		System.out.print("Queue : ");
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}
