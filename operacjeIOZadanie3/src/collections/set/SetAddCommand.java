package collections.set;

import java.util.Collection;
import java.util.Random;

import mod03.zad03.Command;

public class SetAddCommand implements Command{
	final Collection<Integer> collection;
	Integer toAdd;
	Random rand = new Random();
	
	public SetAddCommand(final Collection<Integer> collection, int numberOfElements) {
		this.collection = collection;
		for(int i = 0; i < numberOfElements; i++) {
			collection.add(rand.nextInt());
		}	
	}

	public void execute() throws Exception {
		collection.add(toAdd);	
	}

	public void post() throws Exception {
		collection.remove(toAdd);
		
	}

	public void pre() throws Exception {
		do {
			toAdd = rand.nextInt();
		} while(collection.contains(toAdd));
	}

}
