import java.io.IOException;


public class TestTop {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Graphs g = new Graphs();
		
		 //System.out.println(g); //�߰��� �� �Ǿ����� Ȯ��
		
		 g.topsort();
		 System.out.println();
		 g.topsort_grade();//topological sortingȮ��

	}

}
