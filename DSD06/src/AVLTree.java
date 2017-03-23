
public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	
	public static final AVLTree NIL = new AVLTree();
	
	public AVLTree(int key){
		this.key = key;
		left = right = NIL;
	}
	
	private AVLTree(){
		left = right = this;
		height = -1;
	}
	
	private AVLTree(int key, AVLTree left, AVLTree right){
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1+Math.max(left.height, right.height);
	}
	
	public boolean add(int key){
		int oldSize = size();
		grow(key);
		return size()>oldSize;
	}
	
	public AVLTree grow(int key){
		if(this == NIL) return new AVLTree(key);
		if(key == this.key) return this;
		if(key<this.key) left = left.grow(key);
		else right = right.grow(key);
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		return this;
	}
	
	public boolean delete(int key){
		int oldSize = size();
		AVLTree temp = minus(key);
		this.key = temp.key;
		this.right = temp.right;
		this.left = temp.left;
		rebalance();
		return size()<oldSize;
	}
	
	public AVLTree minus(int key){
		if(key == this.key){
			if(this.left==NIL && this.right==NIL) return NIL;
			if(this.left==NIL) return this.right;
			if(this.right==NIL) return this.left;
			else {
				if(this.right.left==NIL)
					return new AVLTree(this.right.key,this.left,this.right.right);
				else {
					AVLTree min;
					for(min = this.right; min.left!=NIL; min = min.left)
						;
					int tempKey = min.key;
					AVLTree temp = this.minus(tempKey);
					return new AVLTree(tempKey,temp.left,temp.right);
				}
			}
		}
		if(key < this.key) left = left.minus(key);
		else right = right.minus(key);
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
		return right+ " " + key + " " + left;
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

	
}
