import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Graphs {
	
	int size;
	String[] vertices; //정점들의 배열
	Node[] a;  //인접리스트
	int[] stack; //내가 그냥 배열로 만든 스택 문제1 풀 때 사용
	int stackSize=0;
	PriorityQueue<Integer> priQ; //우선순위 큐 문제2 풀 때 사용
	
public Graphs() throws IOException{
		
		int n = 0; //vertices의 인덱스
		int m = 0; //간선일때 앞의것인지 뒤의 것인지 확인하는것
		String temp = "";
		
		FileInputStream stream = new FileInputStream("Vertex");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		while((token.nextToken()!=StreamTokenizer.TT_EOF)){
			switch(token.ttype){
			case StreamTokenizer.TT_NUMBER:
				if(token.lineno()==1){ //맨 윗줄이라면 
					size = (int)token.nval; //정점의 갯수
					vertices = new String[size];
					a = new Node[size];
					m = size+1;
					for(int i=0; i<size; i++)
						a[i] = new Node(i);
					stack =  new int[size];
					priQ = new PriorityQueue<>();
				}
				else
					a[n-1].grade = (int)token.nval; //아니라면 학년
				break;
			case StreamTokenizer.TT_WORD:
				if(token.lineno() <size+2 && token.lineno()>1)
					vertices[n++]=token.sval; //size+2보다 작다면 정점의 이름
				else{ //아니라면 방향간선
					if(m<token.lineno()){
						temp = token.sval; //일시적으로 temp에 받아준다.
						m++;
					}
					else
						this.add(temp, token.sval);

				}
				break;
			}
		}
		stream.close();
	}
	
	public String toString() {
		if(size==0) return "{}";
		StringBuffer buf = new StringBuffer("{"+a[0]);
		for(int i = 1; i<size; i++)
			buf.append(", "+a[i]);
		return buf+"} ";
	}
	
	private int index(String v) {
		for (int i = 0; i<size; i++)
			if(vertices[i].equals(v)) return i;
		return a.length;
	}
	
	public void add(String v, String w){
		a[index(v)].add(index(w));
		a[index(w)].inDegree++;
	}
	
	public void topsort(){
		for(int i=0; i<size; i++)
			if(a[i].inDegree==0) stack[stackSize++] = i;
		while(stackSize!=0){
			int i = stack[--stackSize];
			System.out.print(vertices[i]);
			for(Node p = a[i].next; p!=null; p=p.next){
				a[p.to].inDegree--;
				if(a[p.to].inDegree==0) stack[stackSize++] = p.to;
			}
			if(stackSize!=0) System.out.print("->");
		}
	}
	
	public void topsort_grade(){
		for(int i=0; i<size; i++)
			if(a[i].inDegree==0) priQ.add(a[i].grade*100+i);
		while(priQ.size()!=0){
			int i = (int)priQ.poll()%100;
			System.out.print(vertices[i]);
			for(Node p = a[i].next; p!=null; p=p.next){
				a[p.to].inDegree--;
				if(a[p.to].inDegree==0) priQ.add(a[p.to].grade*100+p.to);
			}
			if(priQ.size()!=0) System.out.print("->");
		}
	}
	
	private class Node{
		int grade; //학년
		int inDegree=0; //in_degree
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
				buf.append(Graphs.this.vertices[p.to]+" ");
			return buf+"";
				
		}
		public void add(int j){
			next = new Node(j, next);
		}
		

	}

}
