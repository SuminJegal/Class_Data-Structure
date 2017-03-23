
public class AVLTree {
	private int height;
	private AVLTree left, right;
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
	
	public static final AVLTree NIL = new AVLTree();
	
	public AVLTree(String obj){
		this.key = new Data(obj);
		left = right = NIL;
	}
	
	public AVLTree(String obj, int c){
		this.key = new Data(obj, c);
		left = right = NIL;
	}
	
	private AVLTree(){
		left = right = this;
		height = -1;
	}
	
	private AVLTree(Data key, AVLTree left, AVLTree right){
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
	
	public AVLTree grow(String obj){
		if(this == NIL) return new AVLTree(obj);
		if(this.key.data.equals(obj)){
			this.key.count++;
			return this;
			}
		if(this.key.data.compareTo(obj)>0) left = left.grow(obj);
		else right = right.grow(obj);
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		return this;
	}
	
	
	public int size(){
		if(this == NIL) return 0;
		return 1+left.size()+right.size();
	}
	
	public String toString(){
		if(this == NIL) return "";
		return left+ ""+ key + "\n" + right;
	}
	
	private void rebalance(){
		if(right.height > left.height+1){
			if(right.left.height > right.right.height) right.rotateRight();
			rotateLeft();
		}
		else if(left.height > right.height+1){
			if(left.right.height > left.left.height) left.rotateLeft();
			rotateRight();
		}
	}
	
	private void rotateLeft(){
		left = new AVLTree(key,left,right.left);
		key = right.key;
		right = right.right;
	}
	
	private void rotateRight(){
		right = new AVLTree(key,left.right,right);
		key = left.key;
		left = left.left;
	}

	public int height(){
		return height;
	}
}
