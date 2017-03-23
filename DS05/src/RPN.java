
public class RPN {
	
	ArrayStack stack;
	String[] a;
	
	public RPN(String[] args){
		stack = new ArrayStack(args.length);
		a = new String[args.length];
		a = xxx(args);
		for(int i = 0; a[i]!=null; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println(calculate(a));
	
	}
	
	private String[] xxx(String[] args) { //중위를 후위로 바꾸는 메소드
		int size=0;
		String[] aa = new String[args.length];
		for (int i = 0; i<args.length; i++){
			String input = args[i];
			if (isAnOperator(input)==false && isParenth(input)==0) 
				aa[size++] = input; 
			else if(isParenth(input)==2) {
				do{
				aa[size++] = (String)stack.pop();
				}while(isParenth(aa[size-1])!=1); 
				aa[--size] = null;
			}
			else {
				if(stack.size()!=0){
					if(isAnOperator((String)stack.peek())==true && isAnOperator(input)){
						if(compareOp((String)stack.peek(), input)==true)
							aa[size++] = (String)stack.pop();
					}
				}
				stack.push(input);
				
			}
		}
		while(stack.size()!=0)
			aa[size++] = (String)stack.pop();
		return aa;
	}
	
	private double calculate(String[] a) { //후위 연산식을 계산 하는 메소드
		for (int i = 0; a[i]!=null; i++) {
			String input = a[i];
			if (isAnOperator(input)==true) { 
				double y = Double.parseDouble((String)stack.pop());
				double x = Double.parseDouble((String)stack.pop());
				double z = evaluate(x,y,input);
				stack.push(""+z);
			}
			else stack.push(input);
		}
		return Double.parseDouble((String)stack.pop());
	}
	
	private boolean compareOp(String s, String ss){ //operator를 비교하는 메소드 distingOp()를 사용하여 비교
		int a, b;
		a = distingOp(s);
		b = distingOp(ss);
		if(a-b>=0) return true;
		else return false;
	}
	
	private int distingOp(String s){ //operator를 구별하는 메소드. 판단해서 +,-와 *,/으로 나눈다.
		if(s.equals("A")||s.equals("S")) return 0;
		else return 1;
	}
	
	private boolean isAnOperator(String s){ //operator인지 확인하는 메소드
		return (s.length() == 1 && "ASMD".indexOf(s) >=0);
	}
	
	private int isParenth(String s){ //괄호인지 아닌지 판단하는 메소드
		if (s.equals("(")) return 1;
		else if(s.equals(")")) return 2;
		else return 0;
	}
	
	private double evaluate(double x, double y, String op) { 
		double z = 0;
		if		 	(op.equals("A"))	z = x + y; 
		else if 	(op.equals("S"))	z = x - y;
		else if 	(op.equals("M"))	z = x * y;
		else							z = x / y;
		return z;	
	}
	
	public static void main (String[] args){
		new RPN(args);
	}

}
