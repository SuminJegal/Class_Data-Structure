
public class LinkedGraph {
	
	int size;
	String[] vertices;
	Node[] a;
	String[] depthfs;
	String[] stack;
	boolean[] visit;
	int stacksize;
	
	public LinkedGraph(String[] args) {
		size = args.length;
		vertices = new String[size];
		a = new Node[size];
		depthfs = new String[size];
		stack = new String[size];
		visit = new boolean[size];
		for(int i=0; i<size; i++){
			a[i] = new Node(i);
			vertices[i] = args[i];
		}
	}
	
	public void add(String v, String w){
		a[index(v)].add(index(w));
		a[index(w)].add(index(v));
	}
	
	public String toString() {
		if(size==0) return "{}";
		StringBuffer buf = new StringBuffer("{"+a[0]);
		for(int i = 1; i<size; i++)
			buf.append(","+a[i]);
		return buf+"}";
	}
	
	private int index(String v) {
		for (int i = 0; i<size; i++)
			if(vertices[i].equals(v)) return i;
		return a.length;
	}
	
	private class Node{
		int to;
		Node next;
		Node(int to){
			this.to = to;
		}
		Node(int to, Node next){
			this.to = to;
			this.next = next;
		}
		public String toString(){
			StringBuffer buf = new StringBuffer(vertices[to]);
			if(next != null) buf.append(":");
			for(Node p = next; p != null; p=p.next)
				buf.append(LinkedGraph.this.vertices[p.to]+" ");
			return buf+"";
				
		}
		public void add(int j){
			Node p;
			for(p = this; p.next != null;p=p.next)
				;
			p.next = new Node(j,null);
		}
	}
	
	public void dfs(){
		stack[0] = vertices[0];
		stacksize++;
		int i = 0;
		while(stacksize != 0){
			depthfs[i] = stack[(--stacksize)];
			visit[index(depthfs[i])] = true;
			stack[(stacksize)] = null;
			for(Node p = a[index(depthfs[i])]; p.next!=null; p=p.next){
				boolean checkst=false;
				for(int k=0; k<stacksize; k++)
					if(vertices[p.next.to].equals(stack[k])) checkst = true;
				if(visit[p.next.to]==false && checkst==false)
					stack[stacksize++] = vertices[p.next.to];
			}
			i++;
		}
		System.out.print("{");
		for(int k=0; k<size; k++){
			if(k!=(size-1)) System.out.print(depthfs[k]+"->");
			else System.out.print(depthfs[k]);
		}
		System.out.println("}");
	}

}
