package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Jeu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class Controleur implements Initializable{
	private Jeu jeu;
	
	 @FXML
	    private Pane LaMap;
	 
	 @FXML
	    private TilePane TiledPane;
	 
	 @FXML
	 	private Label l1;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.jeu = new Jeu(57, 42);
		
		//Image Tneige = new Image("/application/vue/TuileNeige41.png");
		//Image Tchemin = new Image("/application/vue/TuileChemin386.png");
	}
	
/*	private void afficherPlateau() {
		for (int x = 0; x < jeu.getLargeur(); x++) {
			for(int y = 0; y < jeu.getHauteur(); y++ ) {
				int codeTuile = jeu.codeTuile(x, y);
			}
		}
	}*/
	public void tabIntMap(int []cTuile) {//1ere methode, import de chque tuile et verification de l'ID
		for (int x = 0; x < jeu.getLargeur(); x++) {
			for(int y = 0; y < jeu.getHauteur(); y++ ) {
				if (cTuile[x] == 386) {
					
				}
			}
			System.out.println();
		}
	}
	public static void remplirTile() {
		int x = 0, y = 0;
		Image image = new Image("/vue/tpligth.png");
		ImageView iv1 = new ImageView();
        iv1.setImage(image);
        Rectangle2D r1 = new Rectangle2D(x, y, 57, 42);
        iv1.setViewport(r1);
		while( y != r1.getMaxY()) {
			if (x == r1.getMaxX()) {
				x = 0;
				y++;
			}
			else {
				new ImageView().setViewport(r1);
				}
		}
	}
	 @SuppressWarnings("unused")
	private void unTour() {
		 
	 }
		//utiliser ViewPort(internet)-select a piece of image - codetuile une par une
		//tilePane.add - limage de la tuile coresspondante est ajoute - dessine plateau
	
}