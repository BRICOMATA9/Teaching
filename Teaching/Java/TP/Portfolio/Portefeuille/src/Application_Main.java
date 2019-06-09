


import static javafx.concurrent.Worker.State.FAILED;

import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import vue.Interface_JavaFX_Swing;
import vue.Panel_connexion;
import vue.Panel_interface;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Utilisateur
 */
public class Application_Main extends JApplet {
    
    //   private static JFXPanel fxContainer;
	private static final long serialVersionUID = 1L;
	private JFXPanel jfxPanel;
	private static WebEngine engine;
	static Panel_connexion panelconnexion = new Panel_connexion();
	//static Panel_interface interface_netbeans = new Panel_interface();
	private final JPanel panelswing = new JPanel(new BorderLayout());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }
             
                JApplet applet = new Application_Main();
               
            	Interface_JavaFX_Swing browser = new Interface_JavaFX_Swing();
				browser.setVisible(true);
				browser.setLocationRelativeTo(null);
				Interface_JavaFX_Swing.loadURL("http://finance.yahoo.com/news/#yui_3_18_1_1_1448528732030_1089");
				applet.init();
                applet.start();
            }
        });
    }
    
    @Override
    public void init() {
      jfxPanel = new JFXPanel();
       
        // create JavaFX scene
        Platform.runLater(new Runnable() {
            
            @Override
            public void run() {
                createScene();
            }
        });
    }
    

	private void createScene() {
		
		Platform.runLater(new Runnable() {
			@Override 
			public void run() {

				WebView view = new WebView();
				engine = view.getEngine();
				engine.getLoadWorker()
				.exceptionProperty()
				.addListener(new ChangeListener<Throwable>() {

					public void changed(ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) {
						if (engine.getLoadWorker().getState() == FAILED) {
							SwingUtilities.invokeLater(new Runnable() {
								@Override public void run() {
									JOptionPane.showMessageDialog(
											panelswing,
											(value != null) ?
													engine.getLocation() + "\n" + value.getMessage() :
														engine.getLocation() + "\nUnexpected error.",
														"Loading error...",
														JOptionPane.ERROR_MESSAGE);
								}
							});
						}
					}
				});

				jfxPanel.setScene(new Scene(view));
				
			}
		});
		
	}

	public static void loadURL(final String url) {
		Platform.runLater(new Runnable() {
			@Override 
			public void run() {
				String tmp = toURL(url);
				if (tmp == null) {
					tmp = toURL("http://" + url);
				}

				engine.load(tmp);
			}
		});
	}

	private static String toURL(String str) {
		try {
			return new URL(str).toExternalForm();
		} catch (MalformedURLException exception) {
			return null;
		}
	}
    
}