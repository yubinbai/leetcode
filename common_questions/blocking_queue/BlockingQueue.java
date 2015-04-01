import java.util.*;
import java.util.concurrent.*;

public class BlockingQueue {
	private ArrayDeque<Object> queue = new ArrayDeque<Object>();

	public synchronized Object dequeue() {
		while (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				return null;
			}
		}
		return queue.remove();
	}
	public synchronized void enqueue(Object e) {
		queue.add(e);
		notify();
	}
	public static void main(String[] args) throws Exception {
		BlockingQueue queue = new BlockingQueue();

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}

class Producer implements Runnable {

	protected BlockingQueue queue = null;

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			queue.enqueue("1");
			Thread.sleep(1000);
			queue.enqueue("2");
			Thread.sleep(1000);
			queue.enqueue("3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class Consumer implements Runnable {

	protected BlockingQueue queue = null;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}