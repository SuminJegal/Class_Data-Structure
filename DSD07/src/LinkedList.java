
public class LinkedList {
	private Node start;
	private Node p, containP;
	private int size=0;

	private class Node{
		private Object data;
		private int count=1;
		private Node next;
		
		public Node(Object data){
			this.data = data;
		}
		
		public Node(Object data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public void add(Object obj) {
		containP = contains(obj);
		if(containP==null){
			if(start==null){
				start = new Node(obj);
				p = start;
				size++;
			}
			else{
				p.next = new Node(obj);
				p = p.next;
				size++;
			}
			
		}
		else {
			containP.count++;
		}
		
	}

	public Node contains(Object obj) {
		if(start==null) return null;
		else{
			for(Node q=start; q!=null; q = q.next) 
				if(obj.equals(q.data))	return q;
			return null;
		}
	}
	
	public int size(){
		return size;
	}
	
	public void print(){
		for(Node q=start; q.next!=null; q = q.next)
			System.out.println(q.data+": "+q.count);
	}
	
	

}
