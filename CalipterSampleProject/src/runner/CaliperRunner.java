package runner;

import java.util.Locale;

public class CaliperRunner {
    public static void main(String[] args) {
    	//Needed for storing results online - because of Caliper bug: http://code.google.com/p/caliper/issues/detail?id=113	
    	//NOTE: this bug is already fixed in SVN but not in lib release included in this project
    	Locale.setDefault(Locale.US);
    	
        com.google.caliper.Runner.main(args);
    }
}
