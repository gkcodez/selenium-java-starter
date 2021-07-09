package Log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class BasicLog4j {

	static Logger Log = Logger.getLogger(BasicLog4j.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		Log.setLevel(Level.DEBUG);
		Log.trace("This is a Trace Message");
		Log.debug("This is a Debug Message");
		Log.info("This is a Info Message");
		Log.warn("This is a Warning Message");
		Log.error("This is a Error Message");
		Log.fatal("This is a Fatal Message");
	}
}
