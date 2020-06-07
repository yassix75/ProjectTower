package application.vue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Adolescent;
import application.modele.Bebe;
import application.modele.Enfant;
import application.modele.Ennemis;
import application.modele.Jeu;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.VBox;
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

    @FXML
    private VBox vbox;
    
    @FXML
    private Button lancer;

    private Jeu jeu;

	private Object ennemi;
    
	public JeuVue(Jeu jeu, Pane paneMap) {
		this.jeu = jeu;
		this.paneMap = paneMap;
		this.paneEnnemis = paneMap;
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
	
    public void afficheEnnemisChem1(Ennemis ennemi) {
    	// a faire random de tile Y = 0 et 2 (3 possibilite) pour aleatoire apparition des ennemis entre gauche-central-droite
    	ImageView iv1 ;
    	System.out.println("trydfgh");
    	String s = "file:src/application/vue/";
    	//int tileX = ennemi.getX();
    //	int tileY = ennemi.getY();
    // a faire random de 4-8 (5 possibilite) pour la gauche    calcul a partir d'en haut a gauche
    	//int pixX = (16*(tileX+1));
    	//int pixY = (16*(tileY+1));
    	
    	if (ennemi instanceof Bebe) { // x = 16px y = 25px
    		iv1 = new ImageView(s + "BebeG.png");    		
    	}
    	
    	else if (ennemi instanceof Enfant) { // x=32px y=32px   		
    		iv1 = new ImageView(s  + "EnfantG.png");   		
    	}
    	
    	else {//(ennemi instanceof Adolescent) { //prend 3 tile, y = 48px x = 39px   		
    		iv1 = new ImageView(s + "AdoG.png");
    	}
    	paneEnnemis.getChildren().add(iv1);
    	//iv1.setTranslateX(pixX);
       // iv1.setTranslateY(pixY);
    	iv1.translateXProperty().bind(ennemi.getXProperty().multiply(16));
    	iv1.translateYProperty().bind(ennemi.getYProperty().multiply(16));
    	/* while (jeu.getCodeUneTuile(tileX, tileY.add(1)) == 17) {
         	if (jeu.getCodeUneTuile(tileX, tileY.add(1)) == 386 ) {        		
         		iv1.setTranslateX(pixY.add(16));
         		tileY.add(1);
         	}
         	else if(jeu.getCodeUneTuile(tileX+1, tileY) == 386 ) {
         		iv1.setTranslateY(pixX.add(16));
         		tileX.add(1);
         	}
         }
    
    	iv1.setId(ennemi.getId());
    
    	paneEnnemis.getChildren().add(iv1);
    	
    	iv1.setTranslateX(pixX);
        iv1.setTranslateY(pixY);
        
        while (jeu.getCodeUneTuile(tileX, tileY.add(1)) == 17) {
        	if (jeu.getCodeUneTuile(tileX, tileY.add(1)) == 386 ) {        		
        		iv1.setTranslateX(pixY.add(16));
        		tileY.add(1);
        	}
        	else /*if(jeu.getCodeUneTuile(tileX+1, tileY) == 386 ) {
        		iv1.setTranslateY(pixX.add(16));
        		tileX.add(1);
        	}
        }

    	  Circle r = new Circle(5);
    	int tileX = 0;
    	int tileY = 8;
    	int pixX = 16*(tileX+1)+8;
    	int pixY = 16*(tileY+1)+8;
        r.setFill(Color.RED);
        r.setId("rond");
        r.setTranslateX(pixX);
        r.setTranslateY(pixY);
        paneEnnemis.getChildren().add(r);
        
        while (jeu.getCodeUneTuile(tileX, tileY) == 386) {  // || while( tileY+1 !=
        	if (jeu.getCodeUneTuile(tileX, tileY+1) == 386 ) {        		
        		r.setTranslateX(pixY+16);
        		tileY++;
        	}
        	else if(jeu.getCodeUneTuile(tileX+1, tileY) == 386 ) {
        		r.setTranslateY(pixX+16);
        		tileX++;
        	}
        } 
          r.translateXProperty().bind(a.xProperty());
        r.translateYProperty().bind(a.yProperty());
        
        posX+=16;
        posY+=16;

        
           for (int i = 0; i < paneEnnemis.getChildren().size(); i++) {
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