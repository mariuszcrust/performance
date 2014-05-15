package mod05.zad06;

import java.util.Collection;
import java.util.Collections;

public class SynchronizedCollectionRunnable extends CollectionRunnable {

	public SynchronizedCollectionRunnable (Collection<Integer> collection, int addChance) {
		super(Collections.synchronizedCollection(collection), addChance);
	}
	
	@Override
	protected int countSum(Collection<Integer> collection) {
		synchronized (collection) {
			return super.countSum(collection);			
		}
	}

}
