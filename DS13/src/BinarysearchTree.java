
public class BinarysearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree tree = new BinaryTree(6);
		
		tree.add(4);
		tree.add(8);
		tree.add(2);
		tree.add(10);
		
		System.out.print("중위 순회 메소드 : ");
		tree.inorderPrint(tree.head);
		System.out.printf("\n\n");
		
		System.out.println("search(9)");
		System.out.println(tree.search(9));
		System.out.println();
		
		System.out.println("search(10)");
		System.out.println(tree.search(10));
		System.out.println();
		
		tree.delete(6);
		
		System.out.println();
		tree.inorderPrint(tree.head);
		
	}

}
