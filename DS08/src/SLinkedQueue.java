
public class SLinkedQueue implements Queue{
	
	private Node head;
	private Node rear;
	private int size;

	@Override
	public void add(Object object) {
		if(size==0) 
			head = rear = new Node(object, rear);
		else {
			rear.next = new Node(object,rear.next);
			rear = rear.next;
		}
		++size;
		print();
	}

	@Override
	public Object first() {
		if (size==0) {
			System.out.println("cannot first : queue is empty");
			return null;
		}
		else return head.object;
	}

	@Override
	public Object remove() {
		if (size==0) {
			System.out.println("cannot remove : queue is empty");
			return null;
		}
		else{
			Object temp;
			temp = head.object;
			head = head.next;
			--size;
			if(size==0) rear = null;
			print();
			return temp;
		}
	}

	@Override
	public int size() {
		return size;
	}

	private class Node{
		Object object;
		Node next;
		public Node(Object objcet){
			this.object = object;
		}
		public Node(Object object, Node next){
			this.object = object;
			this.next = next;
		}
	}
	
	public void print(){
		System.out.print("Queue : ");
		if(size==0) System.out.print("");
		else
				for(Node p=head;p!=null;p=p.next){
					System.out.print(p.object+" ");
				}	
		System.out.println();
	}
	
}