package mod07;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {

	private static Map<Long, long[]> cache = new WeakHashMap<Long, long[]>();
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(10000);
		
		long key = 0;
		while(true) {
			cache.put(key++, new long[10000]);
			
			if(key % 10000 == 0) {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!" + key);
			}
		}
	}
}
