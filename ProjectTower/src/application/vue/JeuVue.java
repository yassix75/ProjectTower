package application.vue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Jeu;
import javafx.beans.property.IntegerProperty;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class JeuVue {
	
	@FXML
    private Pane panePrem;

    @FXML
    private TilePane mapTiledPane;

    @FXML
    private Pane paneMap;

    @FXML
    private Pane paneEnnemis;

    private Jeu jeu;
    
	public JeuVue(Jeu jeu, Pane paneMap) {
		this.jeu = jeu;
		this.paneMap = paneMap;
	}
	
	public void afficherMap() {
		
		for(int x = 0; x <= jeu.getLargeur()-1; x++ ) {
			for (int y = 0; y <= jeu.getHauteur()-1; y++) {
				int leCodeTuile = jeu.getCodeUneTuile(x, y);			
				switch (leCodeTuile) {
				
					case 386 :
						afficheTuile("TuileChemin386.png",x,y);
						break;
	
					case 78 :
						afficheTuile("TuileBat78.png",x,y);
						break;
						
					case 38 :
						afficheTuile("TuileBois38.png",x,y);
						break;
						
					case 39 :
						afficheTuile("TuileBois39.png",x,y);
						break;
						
					case 56 :
						afficheTuile("TuileBois56.png",x,y);
						break;
						
					case 57 :
						afficheTuile("TuileBois57.png",x,y);
						break;
						
					case 65 :
						afficheTuile("TuileMbord65.png",x,y);
						break;
						
					case 74 :
						afficheTuile("TuileMbord74.png",x,y);
						break;
						
					case 67 :
						afficheTuile("TuileMmur67.png",x,y);
						break;
						
					case 68 :
						afficheTuile("TuileMmur68.png",x,y);
						break;
						
					case 17 :
						afficheTuile("TuileMtoit17.png",x,y);
						break;
						
					default:
						afficheTuile("TuileNeige41.png",x,y);
						break;
				}
			}
		}		
	}
	
	public void afficheTuile(String URL,int x, int y) {
		ImageView tuile = new ImageView("file:src/application/vue/" + URL);
		tuile.setFitHeight(16);
		tuile.setFitWidth(tuile.getFitHeight());
		tuile.setTranslateX(16*x); 
        tuile.setTranslateY(tuile.getTranslateX()*y/x);
		paneMap.getChildren().add(tuile);
	}
	
    public void creerEtBougerCercle() {
    	Circle r = new Circle(3);
      //  int posX = 0;
        r.setFill(Color.RED);
        r.setId("rond");
        r.setTranslateX(0);
        r.setTranslateY(0);
        paneMap.getChildren().add(r);
    
        
        
        
        /*   for (int i = 0; i < paneEnnemis.getChildren().size(); i++) {
            if (this.) == 0) {
                paneEnnemis.getChildren().get(i).setTranslateX(paneEnnemis.getChildren().get(i).getTranslateX() + 16);
                paneEnnemis.getChildren().get(i).setTranslateY(paneEnnemis.getChildren().get(i).getTranslateY());
            } else {
                paneEnnemis.getChildren().get(i).setTranslateX(paneEnnemis.getChildren().get(i).getTranslateX());
                paneEnnemis.getChildren().get(i).setTranslateY(paneEnnemis.getChildren().get(i).getTranslateY() + 16);
            }
            posX += 16;
        }*/
    }
}