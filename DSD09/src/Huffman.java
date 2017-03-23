import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Huffman {

	boolean isAlphabet;
	Tree temp; // list���� pop�� �� null�ƴҶ����� ���ֱ�
	LinkedList list; // ť�� �ֱ� ���� Ƚ�� ����&���� �ϴ� �ڷᱸ��
	PriorityQueue<Tree> priQ;
	StringBuffer book;
	StringBuffer code = new StringBuffer();
	ArrayStack stack= new ArrayStack(10);;
	
	public Huffman() {

		list = new LinkedList();
		priQ = new PriorityQueue<Tree>();
		book = new StringBuffer();
		
		int lineNumber = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader("book.txt"));
			String line = in.readLine();
			while (line != null) {
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					for (int i = 0; i < word.length(); i++)
						list.add(word.charAt(i));
					book.append(word);
					book.append(" ");
				}
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		for (temp = list.pop(); temp != null; temp = list.pop()) {
			priQ.add(temp);
		}
		
		makeHuffman();
		
	}

	private void makeHuffman() {
		while(priQ.size()!=1) { 
			Tree t = new Tree();
			t.leftchild = priQ.poll();// �켱����ť queue���� �켱 ������ ���� ���� �����ؼ� ����
			t.rightchild = priQ.poll();
			t.freq = t.leftchild.freq + t.rightchild.freq;
			priQ.add(t); // �켱����ť queue�� ���� ������ Ʈ���� ����
		}
		
	}
	
	public void encoding(){
		char c;
		for(int i=0; i<book.length(); i++){
			c = book.charAt(i);
			if(c!= ' '){
				setCode(c, priQ.peek());
				while(stack.size()!=0)
					code.append(stack.pop());
			}
			else
				code.append("\n");
		}
		System.out.println(code);
		
	}
	
	private boolean setCode(char c, Tree tree){ //���ڵ��Ҷ� �ܾ� �ϳ��ϳ� �ڵ� ��ȣ �ֱ�
		boolean judge=false;
		if(tree.leftchild==null && tree.rightchild==null){
			return (tree.alphabet == c);
		}
		else{
			if(tree.leftchild!=null){
				judge = setCode(c, tree.leftchild);
				if(judge)
					stack.push('0');
			}
			if(tree.rightchild!=null && judge == false){
				judge = setCode(c, tree.rightchild);
				if(judge)
					stack.push('1');
			}
			return judge;
		}
	}
	
	public void decoding(){
		Tree tree = priQ.peek();
		Tree resetTree = tree;
		for(int i=0; i<code.length(); i++){
			char c = code.charAt(i);
			if(tree.leftchild==null && tree.rightchild==null){
				System.out.print(tree.alphabet);
				tree = resetTree;
				i--;
			}
			else if(c=='0')
				tree = tree.leftchild;
			else if(c=='1')
				tree = tree.rightchild;
			if(c=='\n'){
				if(i%2==0)
					System.out.println();
				continue;
			}
		}
		
	}

}
