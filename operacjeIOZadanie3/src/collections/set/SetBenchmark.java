package collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import mod03.zad03.Benchmark;

public class SetBenchmark {
	
	private static final int REPEATS = 100 * 1000;
	
	private static final int MAX_SIZE = 1000 * 1000;

	public static void main(String[] args) throws Exception {
		System.out.println("----------Warming up----------");
		execution();
		
		System.out.println("\n--------Real execution------ ");
		execution();
		
		System.out.println("\n--------2nd Real execution--");
		execution();
	}
	
	private static void execution() throws Exception {
			
		for(int i = 10; i < MAX_SIZE; i *=10) {
			Set<Integer> treeSet = new TreeSet<Integer>();
			Benchmark.execute("treeSet,       size: " +i, new SetAddCommand(treeSet, i), REPEATS);
			
			Set<Integer> hashSet = new HashSet<Integer>();
			Benchmark.execute("hashSet,       size: " + i, new SetAddCommand(hashSet, i), REPEATS);
			
			Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
			Benchmark.execute("linkedHashSet, size: " +i, new SetAddCommand(linkedHashSet, i), REPEATS);

		}
	}
}
