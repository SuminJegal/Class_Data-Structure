import java.util.*;


public class TestOrderedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OrderedTree treeA, treeB, treeD;
		OrderedTree treeC = new OrderedTree("C");
		OrderedTree treeE = new OrderedTree("E");
		OrderedTree treeF = new OrderedTree("F");
		OrderedTree treeG = new OrderedTree("G");
		
		LinkedList subtreesB = new LinkedList();
		subtreesB.add(treeE);
		subtreesB.add(treeF);
		treeB = new OrderedTree("B",subtreesB);
		
		LinkedList subtreesD = new LinkedList();
		subtreesD.add(treeG);
		
		treeD = new OrderedTree("D",subtreesD);
		
		LinkedList subtreesA = new LinkedList();
		subtreesA.add(treeB);
		subtreesA.add(treeC);
		subtreesA.add(treeD);
		treeA = new OrderedTree("A",subtreesA);
		
		System.out.print("Preorder : ");
		treeA.preorder();
		
		System.out.println();
		
		System.out.print("Levelorder : ");
		treeA.levelorder();
	}

}
