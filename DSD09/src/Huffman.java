import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Huffman {

	boolean isAlphabet;
	Tree temp; // list에서 pop할 때 null아닐때까지 해주기
	LinkedList list; // 큐에 넣기 전에 횟수 측정&저장 하는 자료구조
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
			t.leftchild = priQ.poll();// 우선순위큐 queue에서 우선 순위가 높은 원소 삭제해서 리턴
			t.rightchild = priQ.poll();
			t.freq = t.leftchild.freq + t.rightchild.freq;
			priQ.add(t); // 우선순위큐 queue에 새로 생성된 트리를 삽입
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
	
	private boolean setCode(char c, Tree tree){ //인코딩할때 단어 하나하나 코드 번호 넣기
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
