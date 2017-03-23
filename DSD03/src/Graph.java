import java.util.PriorityQueue;


public class Graph {

	int size;
	String[] vertices;
	int[][] a;
	int[] parent;
	int setT=0;
	Edge[] edge; //edge들의 weight를 sorting해서 넣은 배열
	int edgenum=0; //edge배열을 관리하는 num
	Edge[] set; //kruskal알고리즘이 적용되어 추가된 set
	int setV=0; //set에 있는 edge들의 weight총 합
	
	public Graph(String[] args){
		size = args.length;
		vertices =  new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new int[size][size];
		parent = new int[size];
		set = new Edge[size-1];
		for(int i =0; i<size; i++){
			parent[i] = -1;
			for(int j=0; j<size; j++)
				if(i!=j) a[i][j]=Integer.MAX_VALUE;
			}
		}
	
	public void add(String v, String w, int n){
		int i= index(v), j = index(w);
		a[i][j] = a[j][i] = n;
		edgenum++;
	}
	
	public String toString(){
		if(size == 0) return "{ }";
		StringBuffer buf = new StringBuffer("{"+vertex(0));
		for(int i =1; i<size;i++)
			buf.append(","+vertex(i));
		return buf+"}";
 	}
	
	private int index(String v){
		for (int i = 0; i<size; i++)
			if(vertices[i].equals(v)) return i;
		return a.length;
	}
	
	private String vertex(int i){
		StringBuffer buf  = new StringBuffer(vertices[i] + ":");
		for(int j = 0; j<size; j++)
			if(a[i][j]<Integer.MAX_VALUE&&a[i][j]>0)buf.append(vertices[j]);
		return buf+" ";
	}
	
	public void sort(){
		edge = new Edge[edgenum];
		edgenum = 0; //0번째 인덱스부터 추가하기 위하여
		for(int i=0; i<size; i++)
			for(int j=i+1; j<size; j++)
				if(a[i][j]<Integer.MAX_VALUE&&a[i][j]>0)
					edge[edgenum++] = new Edge(vertices[i],vertices[j],a[i][j]);
		
		for(int i=edge.length-1; i>0; i--){
			int m=0;
			int j = i;
			for(j=1; j<=i; j++)
				if(edge[j].weight > edge[m].weight) m = j;
			Edge temp = edge[i];
			edge[i] = edge[m];
			edge[m] = temp;
		}
		
		edgenum = 0;
	}
	
	public void kruskal(){
		this.sort();
		while(setT<size-1 && edgenum!=edge.length){
			Edge temp = edge[edgenum++];
			int v1 = collapsingFind(index(temp.v1));
			int v2 = collapsingFind(index(temp.v2));
			if(collapsingFind(v1)!=collapsingFind(v2)){
				set[setT++] = temp;
				weightedUnion(v1,v2);
				setV += temp.weight;
			}
		}
		System.out.println("Kruskal's Algorithm 결과");
		if(setT<size-1){
			System.out.println("No spanning tree");
			return;
		}
		System.out.println("최소 비용 : "+setV);
		System.out.println("사용된 Edge : ");
		for(int i=0; i<set.length; i++)
			System.out.print(vertices[index(set[i].v1)]+vertices[index(set[i].v2)]+":"+set[i].weight+" ");

	}
	
	private int collapsingFind(int i){
		int j = i;
		for(; parent[i]>=0;i=parent[i]) ;
		for(; parent[j]>=0;j=parent[j])
			parent[j] = i;
		return i;
	}
	
	private void weightedUnion(int i, int j){
		if(parent[i]<parent[j]){
			parent[i] += parent[j];
			parent[j]=i;
		}
		else{
			parent[j] += parent[i];
			parent[i]=j;
		}
	}
	
	private class Edge{
		String v1;
		String v2;
		int weight;
		
		Edge(String v1, String v2, int weight){
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
	}
	
}
