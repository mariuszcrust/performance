package tutorial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public enum ListType {
	ARRAYLIST {
		public List<Integer> getList() {
			return new ArrayList<Integer>();
		}
	},
	LINKEDLIST {
		public List<Integer> getList() {
			return new LinkedList<Integer>();
		}
	};
	
	abstract List<Integer> getList();

}
