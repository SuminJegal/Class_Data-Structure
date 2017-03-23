
public class Parenthesis {
	
	LinkedStack stack = new LinkedStack();
	String[] a;
	int aSize =0;
	
	public Parenthesis(String s){
		a = new String[s.length()/2];
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='(') 
				stack.push(i);
			else if(s.charAt(i)==')') 
				a[aSize++] = ""+ stack.pop()+ " , " + i;
		}
		if(stack.size()!=0) System.out.println("괄호 쓰기가 맞지 않다");
		else {
			for(int i=0; a[i]!=null; i++)
				System.out.println(a[i]);
			System.out.println("괄호 쓰기가 맞다");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Parenthesis("(3x((4+2/2)-1)x(5-3)");
	}

}
