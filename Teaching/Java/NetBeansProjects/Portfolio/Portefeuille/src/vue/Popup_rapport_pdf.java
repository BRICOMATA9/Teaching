package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import modele.Rapport_PDF;
import modele.Recuperer_infos_rapport_pdf;

public class Popup_rapport_pdf extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> liste_jours = new ArrayList<String>();
	private static ArrayList<String> liste_mois = new ArrayList<String>();
	private static ArrayList<Integer> liste_annees = new ArrayList<Integer>();
	public  static JRadioButton checkbox_tri_user = new JRadioButton();
	public  static JRadioButton checkbox_tri_entreprise = new JRadioButton();
	//private static String FILE = "Rapport_PDF/SecondPdf.pdf";
	public static String date_depart;


	public Popup_rapport_pdf(JFrame parent, String title, boolean modal){

		super(parent, title, modal);
		remplir_combobox();
		this.setSize(500, 150);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();

	}
	@SuppressWarnings({ "unchecked",  "rawtypes" })
	private void initComponent() {

		ButtonGroup group = new ButtonGroup();
		group.add(checkbox_tri_user);
		group.add(checkbox_tri_entreprise);

		Calendar c = Calendar.getInstance();
		int jour = c.get(Calendar.DAY_OF_MONTH);
		int mois = c.get(Calendar.MONTH);
		int year= c.get(Calendar.YEAR);

		JComboBox combobox_jour = new JComboBox(liste_jours.toArray());
		JComboBox combobox_mois = new JComboBox(liste_mois.toArray());
		JComboBox combobox_annee = new JComboBox(liste_annees.toArray());

		combobox_jour.setSelectedItem(jour);
		combobox_mois.setSelectedItem(mois);
		combobox_annee.setSelectedItem(year);


		JPanel content = new JPanel();
		//	content.setBorder(BorderFactory.createTitledBorder("Editer un rapport PDF"));
		content.setPreferredSize(new Dimension(500,50));
		JLabel label = new JLabel("Date du début du rapport PDF");



		content.add(label);
		content.add(combobox_jour);
		content.add(combobox_mois);
		content.add(combobox_annee);

		JPanel choix_affichage = new JPanel();
		choix_affichage.setPreferredSize(new Dimension(500,50));
		JLabel label2= new JLabel("Trier les informations :");

		checkbox_tri_user.setText(" par utilisateur");
		checkbox_tri_entreprise.setText(" par entreprise");

		choix_affichage.add(label2);
		choix_affichage.add(checkbox_tri_user);
		choix_affichage.add(checkbox_tri_entreprise);

		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");
		JButton cancelBouton = new JButton("Annuler");
		control.add(okBouton);
		control.add(cancelBouton);

		okBouton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String jour= combobox_jour.getSelectedItem().toString();
				String mois= combobox_mois.getSelectedItem().toString();
				int annee= Integer.parseInt(combobox_annee.getSelectedItem().toString());

				String date_depart1 =Recuperer_infos_rapport_pdf.recupererdate(jour, mois, annee);
				date_depart=date_depart1;
				try {
					Document document = new Document();

					JFileChooser filechooser = new JFileChooser();
					filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					//filechooser.showOpenDialog(null);
					//System.out.println(filechooser.getSelectedFile());
					//String path=filechooser.getSelectedFile().toString()+"/Rapport_Activite.pdf";


					PdfWriter.getInstance(document, new FileOutputStream("/Users/Jeredentan/Desktop/RapportPDF/Rapport_Activite.pdf"));
					document.open();
					Rapport_PDF.addMetaData(document);
					Rapport_PDF.addTitlePage(document);
					Rapport_PDF.addContent(document,date_depart1);
					document.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});

		cancelBouton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}

		});

		this.getContentPane().add(content, BorderLayout.NORTH);
		this.getContentPane().add(choix_affichage, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);

		this.setVisible(true); 
	}


	public static void remplir_combobox(){
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);


		for(int i=1; i<10;i++){
			liste_jours.add("0"+i+"");
		}
		for(int i=10;i<32;i++){
			liste_jours.add(""+i+"");
		}
		for(int i=1;i<10;i++){
			liste_mois.add("0"+i+"");
		}
		for(int i=10;i<13;i++){
			liste_mois.add(""+i+"");
		}

		for(int i=2000;i<year+1;i++){
			liste_annees.add(i);
		}

		/*System.out.println("year"+year);
		System.out.println("liste jours "+liste_jours);
		System.out.println("liste mois "+ liste_mois);
		System.out.println("liste ans"+ liste_annees);*/	

	}

}
