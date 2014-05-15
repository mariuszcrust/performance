package mod05.zad06;

import java.util.Collection;
import java.util.Random;

public class CollectionRunnable implements Runnable {
	public static final int REPEATS = 100;
	private Collection<Integer> collection;
	private int addChance;

	public CollectionRunnable (Collection<Integer> collection, int addChance) {
		this.collection = collection;
		this.addChance = addChance;
	}
	
	public void run() {
		Random random = new Random();
		int toAdd = 0;
		for (int i = 0; i < REPEATS; i++) {
			int operation = random.nextInt(100) + 1;
			if (operation <= addChance) {
				collection.add(toAdd);
			} else {
				toAdd += countSum(collection);
			}
		}
	}
	
	protected int countSum(Collection<Integer> collection) {
		int sum = 0;
		for (Integer value : collection) {
			sum += value;
		}
		return sum;
	}

	public Collection<Integer> getCollection() {
		return collection;
	}

	//for caliper
	public void setAddChance(int addChance) {
		this.addChance = addChance;
	}
	
//	//for caliper
//	public String toString() {
//		return collection.getClass().getSimpleName();
//	}
}
