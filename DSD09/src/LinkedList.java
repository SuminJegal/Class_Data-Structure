
public class LinkedList {
	private Node start;
	private Node p, containP;
	private int size=0;
	private Node pop;
	private int popCount = 1;

	private class Node{
		private Tree data;
		private Node next;
		
		public Node(Tree data){
			this.data = data;
		}
		
		public Node(Tree data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public void add(char obj) {
		containP = contains(obj);
		if(containP==null){
			if(start==null){
				start = new Node(new Tree(obj));
				p = start;
				size++;
			}
			else{
				p.next = new Node(new Tree(obj));
				p = p.next;
				size++;
			}
			
		}
		else {
			containP.data.freq();
		}
		
	}

	public Node contains(Object obj) {
		if(start==null) return null;
		else{
			for(Node q=start; q!=null; q = q.next) 
				if(obj.equals(q.data.alphabet))	return q;
			return null;
		}
	}
	
	public Tree pop(){
		if(popCount++ == 1)
			pop = start;
		if(pop == null)
			return null;
		Tree temp = pop.data;
		pop = pop.next;
		return temp;
	}
	
	public int size(){
		return size;
	}
	
	public void print(){
		for(Node q=start; q.next!=null; q = q.next)
			System.out.println(q.data.alphabet+": "+q.data.freq);
	}
	

}
