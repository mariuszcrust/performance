package tutorial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class ListBenchmark extends SimpleBenchmark{
	@Param int size;
	private List<Integer> arrayList;
	private List<Integer> linkedList;
	Random randomno = new Random();
	int middle;
	
	public static void main(String[] args) {
		Runner.main(ListBenchmark.class, args);
	}
	
    @Override 
    protected void setUp() {
        // @Param values are guaranteed to have been injected by now
        arrayList = new ArrayList<Integer>(size);
        linkedList = new LinkedList<Integer>();
        middle = size/2;
        
        for(int i = 0; i < size; i++) {
        	arrayList.add(i);
        	linkedList.add(i);
        }
        
      }
	
	public int timeArrayList(int reps) {
		int dummy = 0;
		for (int i = 0; i < reps; i++) {
	        dummy += arrayList.get(middle);
	      }
		return dummy;
	}
	
	public int timeLinkedList(int reps) {
		int dummy = 0;
		for (int i = 0; i < reps; i++) {
			dummy += linkedList.get(middle);
	      }
		
		return dummy;
	}

}
