
public class ArrayListStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayListStack stack = new ArrayListStack();
		
		stack.push("Monday");
		stack.push("Tuesday");
		stack.push("Wednesday");
		stack.pop();
		stack.pop();
		stack.push("Thursday");
		stack.push("Friday");
		stack.pop();
		stack.push("Saturday");
		stack.push("Sunday");
		stack.pop();
		stack.pop();
		
		stack.print();

	}

}
