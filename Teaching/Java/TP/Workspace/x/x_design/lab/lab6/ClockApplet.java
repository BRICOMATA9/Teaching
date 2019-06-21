/**
 * This applet displays the time of day.
 *
 * The calls to System.out.println() are purely for debugging - use
 * the Java console with your browser to see these output statements.
 *
 */
 
import java.applet.*;
import java.awt.*;

public class ClockApplet extends Applet implements Runnable
{
   private volatile Thread clockThread;
   private boolean ok = false;
   private Object mutex = new Object();

   public void run() {
      while (true) {
         try {
	    // sleep for one second
            Thread.sleep(1000);
       	
	    // now repaint the date and time 
            repaint();
        
	    // check if we need to suspend ourself 
            synchronized (mutex) {
               while (ok == false)
                     mutex.wait();
            }
         }
         catch (InterruptedException e) { }
      }
   }
   
   // this method is called when the applet is 
   // started or we return to the applet
   public void start() {
      if ( clockThread == null ) {
         System.out.println("creating thread");
         ok = true;
         clockThread = new Thread(this);
         clockThread.start();
      }
      else {
         System.out.println("resuming thread");
         synchronized(mutex) {
            ok = true;
            mutex.notify();
         }
      }
   }
   
   // this method is called when we
   // leave the page the applet is on
   public void stop() {
         System.out.println("suspending thread");
         synchronized(mutex) {
            ok = false;
         }
   }
   
   public void paint(Graphics g) {
      g.drawString( new java.util.Date().toString(), 10, 30);
      System.out.println( new java.util.Date().toString());
   }
   
}
