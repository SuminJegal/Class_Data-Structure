
public class MatrixGraph {
	
	int size;
	String[] vertices;
	boolean[][] a;
	String[] depthfs;
	String[] stack;
	boolean[] visit;
	int stacksize;
	
	public MatrixGraph(String[] args){
		size = args.length;
		vertices =  new String[size];
		depthfs = new String[size];
		stack = new String[size];
		visit = new boolean[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];
		}
	
	public void add(String v, String w){
		int i= index(v), j = index(w);
		a[i][j] = a[j][i] = true;
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
			if(a[i][j])buf.append(vertices[j]);
		return buf+" ";
	}
	
	public void dfs(){
		stack[0] = vertices[0];
		stacksize++;
		int i = 0;
		while(stacksize != 0){
			depthfs[i] = stack[(--stacksize)];
			visit[index(depthfs[i])] = true;
			stack[(stacksize)] = null;
			for(int j=0; j<size; j++){
				boolean checkst=false;
				for(int k=0; k<stacksize; k++)
					if(vertices[j].equals(stack[k])) checkst = true;
				if(a[index(depthfs[i])][j]==true && visit[j]==false && checkst==false)
					stack[stacksize++] = vertices[j];
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
