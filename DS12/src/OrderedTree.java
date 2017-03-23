import java.util.*;

public class OrderedTree {
	
	private Object root;
	private LinkedList subtrees;
	private int size;
	
	public OrderedTree(){
		
	}
	
	public OrderedTree(Object root){
		this.root = root;
		subtrees = new LinkedList();
		size = 1;
	}
	
	public OrderedTree(Object root, LinkedList trees){
		this(root);
		for (Iterator it = trees.iterator(); it.hasNext(); ){
			Object object = it.next();
			if(object instanceof OrderedTree) {
				OrderedTree tree = (OrderedTree)object;
				subtrees.add(tree);
				size += tree.size();
			}
		}
	}
	
	public int size(){
		return size;
	}
	
	public void preorder(){
		System.out.print(this.root+" ");
		if(this.size()!=1){
			for (Iterator it = this.subtrees.iterator(); it.hasNext(); ){
				Object object = it.next();
				((OrderedTree)object).preorder();
			}
		}
		else return;
	}
	
	
	public void levelorder(){
		LinkedList queue = new LinkedList();
		queue.addLast(this);
		while (!queue.isEmpty()){
			OrderedTree tree =  (OrderedTree)queue.removeFirst();
			System.out.print(tree.root + " ");
			for(Iterator it = tree.subtrees.iterator(); it.hasNext();)
				queue.addLast(it.next());
		}
	}
	

	

}
