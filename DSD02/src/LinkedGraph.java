import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class LinkedGraph{
	
	int size;
	String[] vertices;
	Node[] a;
	boolean[] visit;
	String[] prev;
	int[] dist;
	int start;
	
	public LinkedGraph() throws IOException{
		
		int k=0;
		String temp1 = "";
		String temp2 = "";
		
		FileInputStream stream = new FileInputStream("Vertex");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		while((token.nextToken()!=StreamTokenizer.TT_EOF)){
			switch(token.ttype){
			case StreamTokenizer.TT_NUMBER:
				if(token.lineno()==1){
					size = (int)token.nval;
					vertices = new String[size];
					a = new Node[size];
					visit = new boolean[size];
					prev = new String[size];
					dist = new int[size];
					for(int i=0; i<size; i++){
						a[i] = new Node(i);
						dist[i] = Integer.MAX_VALUE;
					}
				}
				else{
					this.add(temp1,temp2,(int)token.nval);
				}
				break;
			case StreamTokenizer.TT_WORD:
				if(token.lineno() <size+2 && token.lineno()>1)
					vertices[k++]=token.sval+"";
				else{
					String temp = token.sval+"";
					temp1 = temp.charAt(0)+"";
					temp2 = temp.charAt(1)+"";
				}
				break;
			}
		}
		stream.close();
		System.out.println("총 "+size+"개의 Vertex가 있습니다. 출발점을 입력하세요");
	}
	
	public void add(String v, String w, int weight){
		a[index(v)].add(index(w),weight);
		a[index(w)].add(index(v),weight);
	}
	
	public String toString() {
		if(size==0) return "{}";
		StringBuffer buf = new StringBuffer("{"+a[0]);
		for(int i = 1; i<size; i++)
			buf.append(","+a[i]);
		return buf+"} ";
	}
	
	private int index(String v) {
		for (int i = 0; i<size; i++)
			if(vertices[i].equals(v)) return i;
		return a.length;
	}
	
	private class Node{
		int to;
		int weight;
		Node next;
		Node(int to){
			this.to = to;
		}
		Node(int to, int weight, Node next){
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
		public String toString(){
			StringBuffer buf = new StringBuffer(vertices[to]);
			if(next != null) buf.append(":");
			for(Node p = next; p != null; p=p.next)
				buf.append(LinkedGraph.this.vertices[p.to]+" ");
			return buf+"";
				
		}
		public void add(int j, int weight){
			next = new Node(j, weight, next);
		}
	}
	
	public void start(){
		Scanner scan = new Scanner(System.in);
		System.out.print("start vertext : ");
		String s = scan.nextLine();
		start = this.index(s);
	}
	
	public void setDist(){
		PriorityQueue<Integer> priQ = new PriorityQueue<>();
		int x=start;
		dist[x] = 0;
		boolean check = false;
		priQ.add(dist[x]);
		int y;
		while(!check){
			y=priQ.poll();
			for (int i=0; i<size; i++)
				if(visit[i]==false && y==dist[i]) x=i;
			visit[x] = true;
			for(Node p = a[x]; p.next!=null;p=p.next)
				if(dist[x]+p.next.weight<dist[p.next.to]){
					dist[p.next.to] = dist[x]+p.next.weight;
					priQ.add(dist[p.next.to]);
					prev[p.next.to] = vertices[x];
				}
			
			check = true;
			for(int i=0; i<size; i++)
				if(!visit[i]) check = false;
		}
	}
	
	public void printpath(){
		for(int i=0;i<size;i++){
			System.out.print(vertices[i]+" : distance "+dist[i]+" / ");
			if(prev[i]==null) System.out.print("start");
			else{
				System.out.print(vertices[i]);
				for(int j=index(prev[i]);dist[j]!=0;j=index(prev[j]))
					System.out.print(" <- "+vertices[j]);
				System.out.print(" <- "+vertices[start]);
			}
			System.out.println();
		}
	}

}
