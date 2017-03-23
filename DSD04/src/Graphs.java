import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Graphs {
	
	int size;
	String[] vertices; //�������� �迭
	Node[] a;  //��������Ʈ
	int[] stack; //���� �׳� �迭�� ���� ���� ����1 Ǯ �� ���
	int stackSize=0;
	PriorityQueue<Integer> priQ; //�켱���� ť ����2 Ǯ �� ���
	
public Graphs() throws IOException{
		
		int n = 0; //vertices�� �ε���
		int m = 0; //�����϶� ���ǰ����� ���� ������ Ȯ���ϴ°�
		String temp = "";
		
		FileInputStream stream = new FileInputStream("Vertex");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		while((token.nextToken()!=StreamTokenizer.TT_EOF)){
			switch(token.ttype){
			case StreamTokenizer.TT_NUMBER:
				if(token.lineno()==1){ //�� �����̶�� 
					size = (int)token.nval; //������ ����
					vertices = new String[size];
					a = new Node[size];
					m = size+1;
					for(int i=0; i<size; i++)
						a[i] = new Node(i);
					stack =  new int[size];
					priQ = new PriorityQueue<>();
				}
				else
					a[n-1].grade = (int)token.nval; //�ƴ϶�� �г�
				break;
			case StreamTokenizer.TT_WORD:
				if(token.lineno() <size+2 && token.lineno()>1)
					vertices[n++]=token.sval; //size+2���� �۴ٸ� ������ �̸�
				else{ //�ƴ϶�� ���Ⱓ��
					if(m<token.lineno()){
						temp = token.sval; //�Ͻ������� temp�� �޾��ش�.
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
		int grade; //�г�
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
