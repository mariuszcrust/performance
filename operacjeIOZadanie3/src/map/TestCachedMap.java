package map;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestCachedMap {
		
	private static final int MAX_ENTRIES = 5;

	public static void main(String[] args) {
		      LinkedHashMap<Integer, Integer> withoutAccessOrder = new LinkedHashMap<Integer, Integer>(MAX_ENTRIES, .75F, false) {

				private static final long serialVersionUID = 1L;

				protected boolean removeEldestEntry(Map.Entry eldest) {
		            if(size() > MAX_ENTRIES) {
		            	System.out.println("To remove: " + eldest.getKey());
		            	return true;
		            }
		            
		            return false;
		         }
		      };
		      showMap(withoutAccessOrder);

		      System.out.println("" + withoutAccessOrder);
		      
		      System.out.println("----");
		      
		      LinkedHashMap<Integer, Integer> withAccessOrder = new LinkedHashMap<Integer, Integer>(MAX_ENTRIES, .75F, true) {

					private static final long serialVersionUID = 1L;

					protected boolean removeEldestEntry(Map.Entry eldest) {
			            if(size() > MAX_ENTRIES) {
			            	System.out.println("To remove: " + eldest.getKey());
			            	return true;
			            }
			            
			            return false;
			         }
			      };
			      
			      showMap(withAccessOrder);

			      System.out.println("" + withAccessOrder);

		   }

	private static void showMap(LinkedHashMap<Integer, Integer> map) {
		for(int i = 0; i <= MAX_ENTRIES; i++) {
			  map.put(i, i);
			  map.get(2);
			  map.get(4);
		  }
	}

}
