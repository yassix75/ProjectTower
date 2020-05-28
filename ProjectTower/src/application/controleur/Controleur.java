package application.controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Jeu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class Controleur implements Initializable{
	private Jeu jeu;

    @FXML
    private TilePane mapTiledPane;
    
    @FXML
    private Pane pane;
    
  //  private Map<int, String> dictionnaireImage = new HashMap< int,String>();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.jeu = new Jeu(57, 42);
		afficherMap(jeu);
	}
	
	public void afficherMap(Jeu jeu) {
		
		for (int x = 0; x < jeu.getLargeur()-1; x++) {
			for(int y = 0; y < jeu.getHauteur()-1; y++ ) {
				int leCodeTuile = jeu.getCodeUneTuile(x, y);
				if (leCodeTuile == 41) {
					afficheTuile("TuileNeige41.png",x,y);
				}
				else if (leCodeTuile == 386) {
					afficheTuile("TuileChemin386.png",x,y);
				}
				else if (leCodeTuile == 78) {
					afficheTuile("TuileBat78.png",x,y);
				}
				else if (leCodeTuile == 38) {
					afficheTuile("TuileBois38.png",x,y);
				}
				else if (leCodeTuile == 39) {
					afficheTuile("TuileBois39.png",x,y);
				}
				else if (leCodeTuile == 56) {
					afficheTuile("TuileBois56.png",x,y);
				}
				else if (leCodeTuile == 57) {
					afficheTuile("TuileBois57.png",x,y);
				}
				else if (leCodeTuile == 65) {
					afficheTuile("TuileMbord65.png",x,y);
				}
				else if (leCodeTuile == 74) {
					afficheTuile("TuileMbord74.png",x,y);
				}
				else if (leCodeTuile == 67) {
					afficheTuile("TuileMmur67.png",x,y);
				}
				else if (leCodeTuile == 68) {
					afficheTuile("TuileMmur68.png",x,y);
				}
				else if (leCodeTuile == 17) {
					afficheTuile("TuileMtoit17.png",x,y);
				}
				else {
					afficheTuile("TuileNeige41.png",x,y);
				}
			}
		}		
	}
	
	public void afficheTuile(String URL,int x, int y) {
		ImageView tuile =new ImageView("file:src/application/vue/" + URL);
		tuile.setFitHeight(12);
		tuile.setFitWidth(tuile.getFitHeight());
		tuile.setTranslateX(12*x); 
        tuile.setTranslateY(tuile.getTranslateX()/x*y);
		pane.getChildren().add(tuile);
	}
	
	public void remplirTile() {
		int x = 0, y = 0;
		
		Image image = new Image("/application/vue/tpligth.png");
		ImageView iv1 = new ImageView();
        iv1.setImage(image);
        Rectangle2D r1 = new Rectangle2D(x, y, 57, 42);
        iv1.setViewport(r1);
		while( y <= r1.getMaxY() && x <= r1.getMaxX()) {
			if (x == r1.getMaxX()) {
				x = 0;
				y++;
			}
			else {
				new ImageView().setViewport(r1);	
				x++;
			}
		}
	}
	 
	@SuppressWarnings("unused")
	private void unTour() {
	 }
}