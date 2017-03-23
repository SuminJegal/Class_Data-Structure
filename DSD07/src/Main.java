import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	LinkedList list;
	BST bst;
	AVLTree avl;
	HashTable_double hash;
	
	double LinkedListTime = 0;
	double BSTTime = 0;
	double AVLTime = 0;
	double HashTime = 0;

	public Main() throws IllegalAccessException {

		list = new LinkedList();
		bst = new BST("THE",0);
		avl = new AVLTree("THE",0);
		hash = new HashTable_double();

		int lineNumber = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader("Example"));
			String line = in.readLine();
			while (line != null) {
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					addLinkedList(list, word);
					addBST(bst, word);
					addAVL(avl, word);
					addHash(hash, word);
				}
				line = in.readLine();
			}
			in.close();

		} catch (IOException e) {
			System.out.println(e);
		}
		
		print();
		
		System.out.println("BST height : "+ bst.height());
		System.out.println("AVL height : "+ avl.height());
	}

	public static void main(String[] args) throws IllegalAccessException {
		new Main();

	}

	private void addLinkedList(LinkedList SLL, String word) {
		double startTime = System.nanoTime();
		SLL.add(word);
		double endTime = System.nanoTime();
		LinkedListTime += endTime-startTime;
	}

	private void addBST(BST BST, String word) {
		double startTime = System.nanoTime();
		BST.add(word);
		double endTime = System.nanoTime();
		BSTTime += endTime - startTime;
	}

	private void addAVL(AVLTree AVL, String word) {
		double startTime = System.nanoTime();
		AVL.add(word);
		double endTime = System.nanoTime();
		AVLTime += endTime - startTime;
	}

	private void addHash(HashTable_double HASH, String word) throws IllegalAccessException {
		double startTime = System.nanoTime();
		HASH.put(word);
		double endTime = System.nanoTime();
		HashTime += endTime - startTime;

	}
	
	private void print(){
		System.out.println("<LinkedList>");
		System.out.println("LinkedList Time : " + LinkedListTime);
		System.out.println("words count : " + list.size());
		list.print();
		System.out.println();
		
		System.out.println("<BinarySearchTree>");
		System.out.println("BST Time :  " + BSTTime);
		System.out.println("words count : " + bst.size());
		System.out.println(bst);
		System.out.println();
		
		System.out.println("<AVLTree>");
		System.out.println("AVL Time : " + AVLTime);
		System.out.println("words count : " + avl.size());
		System.out.println(avl);
		System.out.println();
		
		System.out.println("<HashTable_Double>");
		System.out.println("HashTable Time : " + HashTime);
		System.out.println("words count : " + hash.size());
		hash.print();
	}

}