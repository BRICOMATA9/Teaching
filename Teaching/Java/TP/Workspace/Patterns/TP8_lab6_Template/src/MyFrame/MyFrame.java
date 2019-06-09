package MyFrame;
/**
 * An example from the Java API where the
 * template method is practiced.
 */

import java.awt.*;
import javax.swing.*;

/**
 * JFrame contains an update() method that controls
 * the algorithm for updating the screen.
 * We can hook into update() by overriding the
 * paint() method.
 */
public class MyFrame extends JFrame {

 public MyFrame(String title) {
  super(title);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  this.setSize(300,300);
  this.setVisible(true);
 }

 /**
  * How we hook into the update() method.
  * By default, the paint() method in the java.awt.Component
  * class is empty (it's a hook). As the update() method
  * calls the paint() method, if we override it, we can
  * control what is painted on the screen.
  * 
  * To illustrate how the hook works, run this program first
  * using the paint() method shown below. Next, comment out
  * this method and run it again.
  */
  
 public void paint(Graphics graphics) {
  super.paint(graphics);
  String msg = "Patterns are Great!";
  graphics.drawString(msg, 100, 100);
 }
 

 public static void main(String[] args) {
  MyFrame myFrame = new MyFrame("Head First Design Patterns");
 }
}
