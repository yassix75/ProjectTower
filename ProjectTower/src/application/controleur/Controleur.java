package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Jeu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class Controleur implements Initializable{
	private Jeu jeu;
	
	 @FXML
	    private Pane LaMap;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.jeu = new Jeu(57, 42);
		;
		/*afficherPlateau();
		Image image = new Image("/application/vue/tpligth.png");
		
		 ImageView iv1 = new ImageView();
        iv1.setImage(image);
        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setFitWidth(100);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);*/
		Image image = new Image("/application/vue/tpligth.png");
		
		ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitHeight(600);
        iv1.setFitWidth(700);
        this.LaMap.getChildren().add(iv1);
    		 
	}
	
	private void afficherPlateau() {
		for (int x = 0; x < jeu.getLargeur(); x++) {
			for(int y = 0; y < jeu.getHauteur(); y++ ) {
				int codeTuile = jeu.codeTuile(x, y);
			}
		}
	}
	 @SuppressWarnings("unused")
	private void unTour() {
		 
	 }
	//chargez llimage + objet de type image
		//utiliser ViewPort(internet)-select a piece of image - codetuile une par une
		//tilePane.add - limage de la tuile coresspondante est ajoute - dessine plateau
	
}