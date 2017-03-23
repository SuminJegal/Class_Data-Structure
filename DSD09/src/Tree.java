

public class Tree implements Comparable<Tree>{
	char alphabet;
	int freq;
	Tree rightchild;
	Tree leftchild;
	
	public Tree(){

	}

	public Tree(char a){
		alphabet = a;
		freq = 1;
	}
	
	public Tree(char a, int f){
		alphabet = a;
		freq = f;
	}
	
	public void freq(){
		freq++;
	}
	
	@Override
	public int compareTo(Tree htree) {
		if(this.freq < htree.freq)
			return -1; 
		else if(this.freq == htree.freq)
			return 0;
		else
			return 1;
		} 
	
	public String toString(){
		return leftchild + " [" + alphabet + " " + freq + "] "+ rightchild;
	}

}
