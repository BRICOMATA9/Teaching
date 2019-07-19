/**
 * Log all messages to the console
 */

public class ConsoleLog implements Log
{
	public void logMessage(String message) {
		System.out.println( (new java.util.Date()) + " " + message);
	}
}
