package mod05.zad06;

import java.util.ArrayList;
import java.util.Collection;

import mod03.zad03.Command;

public class ThreadsCommand implements Command {
//	static final int COLLECTION_SIZE = 10 * 1000;
	static final int COLLECTION_SIZE = 100;
//	static final int COLLECTION_SIZE = 0;
	private Thread[] threads;
	int threadsNo;
	CollectionRunnable action;
	private static ArrayList<Integer> matrix = new ArrayList<Integer>(COLLECTION_SIZE);

	static {
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			matrix.add(i);
		}		
	}
	
	public ThreadsCommand(int threadsNo, CollectionRunnable action) {
		this.threadsNo = threadsNo;
		this.action = action;
	}
	

	public void pre() throws Exception {
		Collection<Integer> collection = action.getCollection();
		collection.clear();
		collection.addAll(matrix);
//		System.gc();
//		Thread.sleep(10);
 		this.threads = new Thread[threadsNo];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(action);
		}
	}

	public void execute() throws Exception {
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
	}

	public void post() throws Exception {
		threads= null;
	}
}
