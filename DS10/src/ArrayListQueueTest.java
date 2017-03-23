
public class ArrayListQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayListQueue queue = new ArrayListQueue();
		
		queue.addd("DE");
		queue.addd("PA");
		queue.addd("NJ");
		queue.remove();
		queue.remove();
		queue.addd("GA");
		queue.addd("CT");
		queue.remove();
		queue.addd("MA");
		queue.addd("MD");
		queue.remove();
		queue.remove();
		
		queue.print();

	}

}
