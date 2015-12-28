import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	public Fenetre(){
	this.setTitle("Tic Tac Toe");			// Titre de la Fenetre
	this.setSize(500, 500);					// Taille de la Fenetre
	this.setLocationRelativeTo(null);		// Position centrée sur l'écran
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Termine le processus quand on clique sur la croix rouge pour fermer la fenetre
	this.setVisible(true);					// Rend la fenetre visible
	this.setResizable(false);				// Empeche le redimensionnement de la fenetre
		
	JPanel pan = new JPanel();				// Instanciation d'un objet Jpanel
	
	this.setContentPane(pan);				// L'objet Jpanel est le "panneau de contenu" de la fenetre JFrame
	pan.setBackground(Color.GRAY);			// Couleur de fond de la fenêtre
	
    
	}
}
