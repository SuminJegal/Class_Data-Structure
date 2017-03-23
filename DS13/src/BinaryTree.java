

public class BinaryTree {
	
	BinarytreeNode head;
	int size=0;
	
	public BinaryTree(){
		size = 0;
		head = null;
	}
	
	public BinaryTree(int x){
		size += 1;
		head = new BinarytreeNode(x);
	}
	
	public BinaryTree(BinarytreeNode tree){
		head = tree;
	}
	
	
	public boolean add(int x){
		if(searches(x)==false){
			if(x<head.element){
				if(head.leftchild!=null){
					BinaryTree temp = new BinaryTree(head.leftchild);
					temp.add(x);
				}
				else{
					head.leftchild = new BinarytreeNode(x);
				}
				return true;
			}
			else{
				if(head.rightchild!=null){
					BinaryTree temp = new BinaryTree(head.rightchild);
					temp.add(x);
				}
				else{
					head.rightchild = new BinarytreeNode(x);
				}
				return true;
			}
		}
		else
			return false;
	}
	
	public boolean search(int x){
		System.out.println("ºñ±³ : " + x + " " + head.element);
		if(x<head.element){
			if(head.leftchild!=null){
				BinaryTree temp = new BinaryTree(head.leftchild);
				return (temp.search(x));
			}
			else
				return false;
		}
		else if(x>head.element){
			if(head.rightchild!=null){
				BinaryTree temp = new BinaryTree(head.rightchild);
				return (temp.search(x));
			}
			else
				return false;
		}
		else 
			return true;
	}
	
	public boolean searches(int x){
		if(x<head.element){
			if(head.leftchild!=null){
				BinaryTree temp = new BinaryTree(head.leftchild);
				return (temp.searches(x));
			}
			else
				return false;
		}
		else if(x>head.element){
			if(head.rightchild!=null){
				BinaryTree temp = new BinaryTree(head.rightchild);
				return (temp.searches(x));
			}
			else
				return false;
		}
		else 
			return true;
	}
	
	
	public void inorderPrint(BinarytreeNode root){
		if(root!=null) {
			inorderPrint(root.leftchild);
			System.out.print(root.element+" ");
			inorderPrint(root.rightchild);
		}
		else
			return;
	}
	
	public boolean delete(int x){
		if(this == null) return false;
		else{
			if(x < this.head.element) {
				BinaryTree sub = new BinaryTree(this.head.leftchild);
				return sub.delete(x);
			}
			else if(x > this.head.element) {
				BinaryTree sub = new BinaryTree(this.head.rightchild);
				return sub.delete(x);
			}
			else{
				if(this.head.leftchild == null && this.head.rightchild==null){
					this.head = null;
					return true;
				}
				else if(this.head.leftchild == null) {
					this.head = this.head.rightchild;
					return true;
				}
				else if(this.head.rightchild == null) {
					this.head = this.head.leftchild;
					return true;
				}
				else {
					BinaryTree temp = new BinaryTree(this.head.rightchild);
					BinarytreeNode temp2 = temp.delminimum();
					temp2.leftchild = this.head.leftchild;
					this.head = temp2;
					return true;
				}	
			}
		}
	}
	
	private BinarytreeNode delminimum(){
		BinarytreeNode x = this.head;
		BinarytreeNode y = this.head;
		while(x.leftchild != null)
			x = x.leftchild;
		if(x.leftchild !=null){
			while(y.leftchild != x)
				y = y.leftchild;
			y.leftchild = null;	
		}
		return x;
	}

}
