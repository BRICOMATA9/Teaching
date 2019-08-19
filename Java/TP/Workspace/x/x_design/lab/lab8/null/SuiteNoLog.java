/**
 * The Suite - this time with no logging
 */

public class SuiteNoLog
{
	public static void main(String[] args) {
		//Log logger = new ConsoleLog();
		//Log logger = new FileLog("logfile");
		Log logger = null;
		
		// some code
		if (logger != null)
			logger.logMessage("reached some code");

		// and some more code
		if (logger != null)
			logger.logMessage("reached some more code");

		// and even some more code
		if (logger != null)
			logger.logMessage("reached even some more code");
	}
}
