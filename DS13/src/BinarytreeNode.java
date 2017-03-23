

public class BinarytreeNode {
	
	int element;
	BinarytreeNode leftchild;
	BinarytreeNode rightchild;
	
	public BinarytreeNode(int element){
		this.element = element;
	}
	
	public BinarytreeNode(int element, BinarytreeNode leftchild,BinarytreeNode rightchild){
		this.element = element;
		this.leftchild = leftchild;
		this.rightchild = rightchild;
	}
	
	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public BinarytreeNode getLeftchild() {
		return leftchild;
	}

	public void setLeftchild(BinarytreeNode leftchild) {
		this.leftchild = leftchild;
	}

	public BinarytreeNode getRightchild() {
		return rightchild;
	}

	public void setRightchild(BinarytreeNode rightchild) {
		this.rightchild = rightchild;
	}

}
