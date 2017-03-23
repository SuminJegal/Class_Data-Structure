
public class ArrayBag {
	private Node start;
	private Node p, r;
	private int size=0;
	private int diffsize=0;

	private class Node{
		private Object data;
		private Node next;
		
		public Node(Object data){
			this.data = data;
		}
		
		public Node(Object data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public void add(Object object) {
		if(contains(object)==false){
			if(start==null){
				start = new Node(object);
				p = start;
				size++;
				diffsize++;
			}
			else{
				p.next = new Node(object);
				p = p.next;
				size++;
				diffsize++;
			}
			
		}
		else {
			p.next = new Node(object);
			p = p.next;
			size++;
		}
		
	}

	public boolean contains(Object object) {
		if(start==null) return false;
		else{
			if(start.data ==object) return true;
			else{
				for(Node q=start; q.next!=null; q = q.next) {
					if(q.next.data == object)
						return true;}
				return false;
			}
		}
	}

	public boolean remove(Object object){
		if(object==start.data){
			start = start.next;
			if(contains(object)==false){
				size--; diffsize--;
			}
			else
				size--;
			return true;
		}
		else{
			for(Node q=start; q.next!=null; q = q.next){
				if(q.next.data == object){
					q.next = q.next.next;
					if(contains(object)==false){
						size--; diffsize--;
					}
					else
						size--;
					return true;
				}
			}
		}
		return false;
	}
	
	public Object getFirst(){ 
		r = start;
		return r.data;
	}
	
	public Object getNext(){
		r = r.next;
		return r.data;
	}
	
	public int size(){
		return size;
	}
	
	public int diffsize() {
		return diffsize;
	}
	
	public void print(){
		System.out.print(getFirst()+" ");
		for(int i=0; i<size-1; i++){
			System.out.print(getNext()+" ");
		}
		System.out.println();
	}
	
	

}
