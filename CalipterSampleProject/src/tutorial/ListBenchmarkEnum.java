package tutorial;

import java.util.List;
import java.util.Random;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class ListBenchmarkEnum extends SimpleBenchmark{
	@Param ({"10","100"})int size;
	@Param ListType type;;
	private List<Integer> list;
	Random randomno = new Random();
	int middle;
	
	public static void main(String[] args) {
		Runner.main(ListBenchmarkEnum.class, args);
	}
	
    @Override 
    protected void setUp() {
        // @Param values are guaranteed to have been injected by now
        middle = size/2;
        list = type.getList();
        
        for(int i = 0; i < size; i++) {
        	list.add(i);
        }
        
      }
	
	public int timeList(int reps) {
		int dummy = 0;
		for (int i = 0; i < reps; i++) {
	        dummy += list.get(middle);
	      }
		return dummy;
	}

}
