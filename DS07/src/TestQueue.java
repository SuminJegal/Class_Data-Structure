
public class TestQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircularQueue queue  = new CircularQueue(4);
		queue.add("DE");
		queue.add("PA");
		queue.add("NJ");
		queue.remove();
		queue.remove();
		queue.add("GA");
		queue.add("CT");
		queue.remove();
		queue.add("MA");
		queue.add("MD");
		queue.remove();
	}

}
