/**
 * Log all messages to a log file
 */

import java.io.*;

public class FileLog implements Log
{
	private String fileName;

	public FileLog(String fileName) {
		this.fileName = fileName;
	}

	public void logMessage(String message) {
		try {
			// open the file for appending
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName,true));
			out.write((new java.util.Date()) + " " + message + "\r\n");
			out.close();
		}
		catch (IOException ioe) {
			System.err.println("Error writing to log file.");
		}
	}
}
