package vue;

import static javafx.concurrent.Worker.State.FAILED;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controleur.bouton_connexion;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import modele.Gestion_Tableau_Activite_Entreprises;
import modele.Gestion_alertes;
import modele.Gestion_base_de_donnee;
import modele.Gestion_entreprises_a_risque;
import modele.ModeleDynamiqueObjet;
import modele.Timer_rafraichissement;
import modele.jcomboboxachatvente;
import modele.limite_investissement;

public class Interface_JavaFX_Swing extends JFrame{

	private static final long serialVersionUID = 1L;
	private final JFXPanel jfxPanel = new JFXPanel();
	private static WebEngine engine;
	static Panel_connexion panelconnexion = new Panel_connexion();

	private final JPanel panelswing = new JPanel(new BorderLayout());

	public Interface_JavaFX_Swing() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initComponents();

	}


	private void initComponents() {

		createScene();
		getContentPane().add(panelconnexion);	
		pack();


		Panel_connexion.bouton_connexion.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				
				
				if (bouton_connexion.connexion()==true){
					if(bouton_connexion.utilisateurconnecte.equals("bob")){
						
						construire_interface_bob();
						
					}else{
				
					construire_interface_alice();
				}
				}
			}
		});
	}



	private void createScene() {

		Platform.runLater(new Runnable() {
			@Override 
			public void run() {

				WebView view = new WebView();
				engine = view.getEngine();

				engine.titleProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue, final String newValue) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override 
							public void run() {
								Interface_JavaFX_Swing.this.setTitle("Portefeuille d'actions de Alice");
							}
						});
					}
				});



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
				//jfxPanel.getScene().set

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

	public final void construire_interface_alice(){
		Panel_interface interface_netbeans = new Panel_interface();
		Panel_interface.Panelbas.add(jfxPanel);
		setContentPane(interface_netbeans);	
		Gestion_base_de_donnee.recupererBase(bouton_connexion.utilisateurconnecte);
		ModeleDynamiqueObjet.mettretotalportefeuilledanslabel();
		jcomboboxachatvente.remplir();

		
		setSize(1250,800);
		setTitle("Portefeuille d'actions de  "+bouton_connexion.utilisateurconnecte);
		getContentPane().repaint();
		getContentPane().revalidate();
		setLocationRelativeTo(null);
		Gestion_alertes.colorierlignesalerte();
		Gestion_entreprises_a_risque.recuperer_entreprise_a_risque();
		Timer_rafraichissement.createTimer().start();
	
		limite_investissement.recupererlimiteinvestissement();
		
		
		Panel_interface.bouton_deconnexion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(panelconnexion);
				setSize(800,315);
				getContentPane().repaint();
				getContentPane().revalidate();
				setLocationRelativeTo(null);
				Timer_rafraichissement.createTimer().stop();
		
			}
		});
	}
		
		
		public final void construire_interface_bob(){
			Panel_interface_bob interface_bob = new Panel_interface_bob();
			setContentPane(interface_bob);
			Gestion_Tableau_Activite_Entreprises.rafraichir_tableau();
			setSize(1100,600);
			setLocationRelativeTo(null);
			getContentPane().repaint();
			getContentPane().revalidate();
			Timer_rafraichissement.createTimer().stop();
		
			JFrame frame = new JFrame();
			@SuppressWarnings("unused")
			Popup_avertissement_entreprises_interdites pop = new Popup_avertissement_entreprises_interdites(frame,"test",true);
			
			Panel_interface_bob.bouton_deconnexion.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(panelconnexion);
					setSize(800,315);
					getContentPane().repaint();
					getContentPane().revalidate();
					setLocationRelativeTo(null);
					Timer_rafraichissement.createTimer().stop();
				
				}
			});
		}
		
		
		
		
}



