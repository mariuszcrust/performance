package mod05.zad06;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import mod03.zad03.Benchmark;

public class Test {
	private static final int MAX_THREADS = 10;

	public static void main(String[] args) throws Exception {
		System.out.println("rozgrzanie");
		execution();
		
		System.out.println("pierwsza seria");
		execution();
	}
	
	private static void execution() throws Exception {	
		
		for(int addChance = 95; addChance > 0; addChance += -10) {
		
			for(int i = 2; i < MAX_THREADS; i +=2) {
				
				ThreadsCommand threadArrayList = new ThreadsCommand(i, new SynchronizedCollectionRunnable(new ArrayList<Integer>(), addChance));
				Benchmark.execute("arrayList threads: " + i+", addChance: "+addChance, threadArrayList, 10);
				System.gc();
				
				ThreadsCommand threadCopyList = new ThreadsCommand(i, new CollectionRunnable(new CopyOnWriteArrayList<Integer>(), addChance));
				Benchmark.execute("copyList threads: " + i+", addChance: "+addChance, threadCopyList, 10);
				System.gc();
			}
		}
	}
}
