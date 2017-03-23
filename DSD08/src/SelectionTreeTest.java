
public class SelectionTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SelectionTree s = new SelectionTree();
		
		s.addSub(new int[] {1,9,11,19,21,31,41,51,61,71});
		s.addSub(new int[] {7,17,27,37,47,50,57,60,67,77});
		s.addSub(new int[] {2,12,22,29,32,39,42,52,62,72});
		s.addSub(new int[] {4,14,24,34,44,54,64,69,74,79});
		s.addSub(new int[] {8,18,28,38,48,58,68,70,78,80});
		s.addSub(new int[] {5,10,15,20,25,35,45,55,65,75});
		s.addSub(new int[] {3,13,23,33,43,49,53,59,63,73});
		s.addSub(new int[] {6,16,26,30,36,40,46,56,66,76});

		s.sort();
		s.printSort();
		

	}

}
