public class SuiteNullLog
{
 public static void main(String[] args) {
  Log logger;

  // select one of the following logging methods
  
  //logger =  new ConsoleLog();
  logger = new NullLog();
  
  // some code
  logger.logMessage("reached some code");

  // and some more code
  logger.logMessage("reached some more code");

  // and even some more code
  logger.logMessage("reached even some more code");
 }
}
