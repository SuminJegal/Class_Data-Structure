

public class BST {
	private int height;
	private BST left, right;
	private Data key;
	
	private class Data{
		String data;
		int count=1;
		
		Data(String obj){
			this.data = obj;
		}
		
		Data(String obj, int count){
			this.data = obj;
			this.count = count;
		}
		
		public String toString(){
			return data + ": " + count;
		}
	}
	
	public static final BST NIL = new BST();
	
	public BST(String obj){
		this.key = new Data(obj);
		left = right = NIL;
	}
	
	public BST(String obj, int c){
		this.key = new Data(obj, 0);
		left = right = NIL;
	}
	
	private BST(){
		left = right = this;
	}
	
	private BST(Data key, BST left, BST right){
		this.key = new Data(key.data, key.count);
		this.left = left;
		this.right = right;
		height = 1+Math.max(left.height, right.height);
	}
	
	public boolean add(String obj){
		int oldSize = size();
		grow(obj);
		return size()>oldSize;
	}
	
	public BST grow(String obj){
		if(this == NIL) return new BST(obj);
		if(this.key.data.equals(obj)){
			this.key.count++;
			return this;
			}
		if(this.key.data.compareTo(obj)>0) left = left.grow(obj);
		else right = right.grow(obj);
		height = 1 + Math.max(left.height, right.height);
		return this;
	}
	
	
	public int size(){
		if(this == NIL) return 0;
		return 1+left.size()+right.size();
	}
	
	public String toString(){
		if(this == NIL) return "";
		return left +""+ key + "\n" + right;
	}
	
	public int height(){
		return height;
	}

}
