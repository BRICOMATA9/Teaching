package controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractAction;
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
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import modele.Formatage_Date;
import modele.Recuperer_infos_rapport_pdf;

public class bouton_rapportpdf extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> liste_jours = new ArrayList<String>();
	private static ArrayList<String> liste_mois = new ArrayList<String>();
	private static ArrayList<Integer> liste_annees = new ArrayList<Integer>();
	public  static JRadioButton checkbox_tri_user = new JRadioButton();
	public  static JRadioButton checkbox_tri_entreprise = new JRadioButton();
	//private static String FILE = "Rapport_PDF/SecondPdf.pdf";
	private static Font Font_Titre = new Font(Font.HELVETICA);
	private static Font Font_Sous_Titre = new Font(Font.HELVETICA);
	private static Font Font_Header=new Font(Font.TIMES_ROMAN);
	public static String date_depart;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Popup_rapport_pdf rap = new Popup_rapport_pdf(new JFrame(),"Rapport PDF", true);

	}

	private static class Popup_rapport_pdf extends JDialog{

		/**
		 * 
		 */



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
						addMetaData(document);
						addTitlePage(document);
						addContent(document,date_depart1);
						document.close();
						
						
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
						setVisible(false);
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


		private static void remplir_combobox(){
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





	// iText allows to add metadata to the PDF which can be viewed in your Adobe
	// Reader
	// under File -> Properties
	private static void addMetaData(Document document) {
		document.addTitle("Rapport PDF");
		document.addSubject("Rapport Activite Employes");
		document.addKeywords("Portefeuille de bourse, Gigaby'TSE, Rapport");
		document.addAuthor("Dentan Jeremie");
		document.addCreator("Dentan Jeremie");
	}



	private static void addTitlePage(Document document)
			throws DocumentException {

		Font_Titre.setSize(15);
		Font_Titre.setColor(Color.red);
		Font_Sous_Titre.setSize(10);
		Font_Sous_Titre.setColor(Color.blue);
		Font_Header.setSize(10);

		Paragraph Titre = new Paragraph();

		Titre.setAlignment(Element.ALIGN_CENTER);

		addEmptyLine(Titre, 1);

		Paragraph Titre_principal = new Paragraph("Rapport d'activite des employes", Font_Titre);
		Paragraph Sous_Titre = new Paragraph("("+bouton_rapportpdf.date_depart+" - "+ Formatage_Date.mettredateenformepourstockage(new Date())+")", Font_Titre);

		Titre.add(Titre_principal);
		Titre.add(Sous_Titre);

		//Paragraph utilisateur = new Paragraph(System.getProperty("user.name"));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		Paragraph h= new Paragraph("Rapport d'activite des employes 																																																				"
				+ "																		"+format.format(new Date()),Font_Header);
		Paragraph Titre_Header = new Paragraph();

		h.setAlignment(Element.ALIGN_LEFT);
		Titre_Header.add(h);


		HeaderFooter header= new HeaderFooter(Titre_Header,false);
		header.setUseVariableBorders(false);

		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);

		//preface.add(new Paragraph("Report generated by: " + System.getProperty("user.name") + ", " + new Date(), 
		//		smallBold));
		//addEmptyLine(preface, 3);
		//preface.add(new Paragraph("This document describes something which is very important ",
		//		smallBold));


		addEmptyLine(preface, 4);

		Phrase h1= new Phrase();	
		HeaderFooter footer1 = new HeaderFooter(h1,true);
		footer1.setAlignment(Element.ALIGN_RIGHT);


		document.setHeader(header);
		document.add(Titre);
		document.add(preface);
		document.setFooter(footer1);

	}

	private static void addContent(Document document, String date_depart) throws DocumentException {

		if(bouton_rapportpdf.checkbox_tri_user.isSelected()==true){
			document.add(Recuperer_infos_rapport_pdf.informations_par_utilisateurs(date_depart));
		}else{
			if(bouton_rapportpdf.checkbox_tri_entreprise.isSelected()==true){
				document.add(Recuperer_infos_rapport_pdf.informations_par_entreprise(date_depart));
			}
		}

	}


	public static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
