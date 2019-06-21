import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.io.*;

/**
 * Titre : 	WebSourceAspiro
 * Auteur : Prieur Johann
 * @version 1.0
 */
  
class WebSourceAspiro extends JFrame implements ActionListener{
	
    JEditorPane page = new JEditorPane(); // On initialise tout le bordel...
  	JToolBar bar = new JToolBar();
  	JTextField url = new JTextField();
  	JEditorPane source = new JEditorPane();
  	JTabbedPane onglet = new JTabbedPane(JTabbedPane.BOTTOM);
  	JLabel url_label = new JLabel("Aller a : ");
  	JButton go = new JButton("Go!");
  	
	public WebSourceAspiro()
	{
		setSize(400, 600); // La c'est surtout la mise en page...
		setTitle("WebSourceAspiro");
    	setResizable(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    	go.addActionListener(this);
    	bar.add(url_label);
    	bar.add(url);
    	bar.add(go);	
    	page.setEditable(false);
    	page.setFont(new java.awt.Font("Dialog", 0, 15));
		JScrollPane scroll_page = new JScrollPane(page, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scroll_source = new JScrollPane(source, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		onglet.addTab("Apercu page", scroll_page);
		onglet.addTab("Code source", scroll_source);
    	getContentPane().setLayout(new BorderLayout());	
    	getContentPane().add("North", bar);	
		getContentPane().add("Center", onglet);							
	}
	
	void getData(URL url) { // La fonction pour recuperer le code source de la page...
        URLConnection conn = null;
        InputStreamReader in;
        BufferedReader data;
        String line;
        StringBuffer buf = new StringBuffer();
        try {
            conn = url.openConnection();
            conn.connect();
            in = new InputStreamReader(conn.getInputStream());
            data = new BufferedReader(in);
            while ((line = data.readLine()) != null)
                buf.append(line + "\n");
            source.setText(buf.toString());
        } catch (IOException e) {}
    }
    
	public void actionPerformed(ActionEvent evt){ //La fonction pour gerer les evenements...
		Object src = evt.getSource();
		if(src == go)
		try
	    {
	    page.setPage(url.getText());
	    URL http = new URL(url.getText());
	    getData(http);
	    setTitle("WebSourceAspiro - "+ url.getText());
	    }
	    catch(Exception e){}
	}
	
	public static void main(String args[]) // Le main...
    	{
		WebSourceAspiro index = new WebSourceAspiro();
		index.setVisible(true);
	}		
}
