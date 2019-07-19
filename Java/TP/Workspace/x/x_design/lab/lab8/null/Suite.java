public class Suite
{
	public static void main(String[] args) {
		/**
 		 * We may choose either the console 
		 * or the file log.
		 */
		Log consoleLog = new ConsoleLog();
		Log fileLog = new FileLog("logfile");
		
		// some code
		consoleLog.logMessage("reached some code");

		// and some more code
		fileLog.logMessage("reached some more code");

		// and even some more code
		consoleLog.logMessage("reached even some more code");
	}
}
