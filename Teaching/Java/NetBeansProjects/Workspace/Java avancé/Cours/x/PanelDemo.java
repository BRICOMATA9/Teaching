import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PanelDemo
{   public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    /* les composantes de cette interface graphique
       elle sont instanciées dans le constructeur */
    private JPanel redPanel,whitePanel,bluePanel, mainPanel, buttonPanel;
    private JFrame frame;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem menuitem;
    private JButton redButton,whiteButton,blueButton;

    /* les listeners créés à la volée en instanciant les méthodes */
    private ActionListener redListener = new ActionListener() {            
            public void actionPerformed(ActionEvent e){      
                    redPanel.setBackground(Color.RED);
                 }
            };
    private ActionListener whiteListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){      
                    whitePanel.setBackground(Color.WHITE);
                 }
            };
    private ActionListener blueListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){      
                    bluePanel.setBackground(Color.BLUE);
                 }
            };

    private ActionListener menuListener = new ActionListener(){            
                 public void actionPerformed(ActionEvent e){      
                    redPanel.setBackground(Color.LIGHT_GRAY);
                    whitePanel.setBackground(Color.LIGHT_GRAY);
                    bluePanel.setBackground(Color.LIGHT_GRAY);
                 }
            };

    private MouseListener mouseListener = new MouseListener() {
		public void mouseClicked(MouseEvent e){
                   e.getComponent().setBackground(Color.YELLOW);
		    System.out.println(
 			"La Position est " +e.getX() + " " + e.getY());}
                public void mouseEntered(MouseEvent e){}
                public void mouseExited(MouseEvent e){
		    e.getComponent().setBackground(Color.CYAN);
                }
                public void mousePressed(MouseEvent e){}
                public void mouseReleased(MouseEvent e){}
            };

    /* le constructeur */
    public PanelDemo( ) {
        /* d'abord on initialise la fenêtre */
        frame = new JFrame("Panel Demonstration");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        /* on initialise les trois panneaux colorés */
        redPanel = new JPanel( ); 
        whitePanel = new JPanel( );  
        bluePanel = new JPanel( );   
        redPanel.setBackground(Color.LIGHT_GRAY);
        whitePanel.setBackground(Color.LIGHT_GRAY);
        bluePanel.setBackground(Color.LIGHT_GRAY);
        /* on ajoute aux panneaux les listeners */
        redPanel.addMouseListener(mouseListener);
        whitePanel.addMouseListener(mouseListener);
        bluePanel.addMouseListener(mouseListener);

        /* on insère les trois panneaux dans un panneau en grille 
           et on ajoute ce panneau à la fenêtre */ 
        mainPanel = new JPanel( );
        mainPanel.setLayout(new GridLayout(1, 3));
        mainPanel.add(redPanel);
        mainPanel.add(whitePanel);
        mainPanel.add(bluePanel);
        frame.add(mainPanel, BorderLayout.CENTER);
        
        /* on initialise les trois boutons et on y attache les listeners */

        redButton = new JButton("Red");
        redButton.setBackground(Color.RED);
        redButton.addActionListener(redListener);
        
        whiteButton = new JButton("White");
        whiteButton.setBackground(Color.WHITE);
        whiteButton.addActionListener(whiteListener);
        
        blueButton = new JButton("Blue");
        blueButton.setBackground(Color.BLUE);
        blueButton.addActionListener(blueListener);
        
        /* on insère les trois panneaux dans un panneau en flow 
           et on ajoute ce panneau à la fenêtre */ 
        
        buttonPanel = new JPanel( );
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setLayout(new FlowLayout( ));
        buttonPanel.add(redButton);
        buttonPanel.add(whiteButton);
        buttonPanel.add(blueButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        /* on initialise le menu et on y attache les listeners */
        
	menubar = new JMenuBar();

        menu = new JMenu("A Menu");
        menubar.add(menu);

        menuitem = new JMenuItem("Restart");
        menuitem.addActionListener(menuListener);
        menu.add(menuitem);

        frame.setJMenuBar(menubar);

        /* on rend la fenêtre visible */
        frame.setVisible(true);
        }
    
    public static void main(String[] args){
          new PanelDemo();
        }
}

