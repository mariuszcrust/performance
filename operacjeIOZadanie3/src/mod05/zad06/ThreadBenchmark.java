package mod05.zad06;

import mod03.zad03.Command;

public class ThreadBenchmark {

	public static void execute(String id, Command command, int repeats) throws Exception {
		long totalDuration = 0;
		long start = 0;
		long min = Long.MAX_VALUE;
		long max = 0;
		long duration = 0;
		
		for(int i = 0; i < repeats; i++) {
			command.pre();
			
			start = System.nanoTime();
			command.execute();
			duration = System.nanoTime() - start;
			command.post();
			
			totalDuration += duration;
			
			if(duration < min) {
				min = duration;
			}
			
			if(duration > max) {
				max = duration;
			}
		}
		
		System.out.println(id +" \tfor: " + repeats + " execution(s), \tAvg: "+ 
				(totalDuration/repeats) +" \tmax: " + max +" \tmin: "+min);
		
	}
}
