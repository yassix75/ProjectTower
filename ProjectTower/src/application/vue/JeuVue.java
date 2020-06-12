package application.vue;

import java.util.ArrayList;
import java.util.HashMap;
import application.modele.Bebe;
import application.modele.Enfant;
import application.modele.Ennemis;
import application.modele.Jeu;
import application.modele.TourelleArcher;
import application.modele.TourelleMortier;
import application.modele.Tours;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

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
    
    private HashMap <Integer, String> dictionnaire;

	private Pane paneTour;
    
	public JeuVue(Jeu jeu, Pane paneMap) {
		this.jeu = jeu;
		this.paneMap = paneMap;
		this.paneEnnemis = paneMap;
		this.dictionnaire = creationDictionnaire();
		this.paneTour = paneMap;   
	}
	 
	public HashMap <Integer,String> creationDictionnaire() {
		HashMap< Integer, String > lienImage = new HashMap< Integer, String>();
		lienImage.put(386, "TuileChemin386.png");
		lienImage.put(78, "TuileBat78.png");
		lienImage.put(38, "TuileBois38.png");
		lienImage.put(39, "TuileBois39.png");
		lienImage.put(56, "TuileBois56.png");
		lienImage.put(57, "TuileBois57.png");
		lienImage.put(65, "TuileMbord65.png");
		lienImage.put(74, "TuileMbord74.png");
		lienImage.put(68, "TuileMmur68.png");
		lienImage.put(67, "TuileMmur67.png");
		lienImage.put(17, "TuileMtoit17.png");
		lienImage.put(41, "TuileNeige41.png");

		return lienImage;
	}

	public void afficherMap(Jeu jeu) {
		String lien ;
		for(int x = 0; x <= jeu.getLargeur()-1; x++ ) {
			for (int y = 0; y <= jeu.getHauteur()-1; y++) {
				int leCodeTuile = jeu.getCodeUneTuile(x, y);
				lien = this.dictionnaire.get(leCodeTuile);
				if(!this.dictionnaire.containsKey(leCodeTuile)) {
					lien = this.dictionnaire.get(41);
				}
				afficheTuile(lien,x,y);
			}
		}
	}
	
	public void afficheTuile(String URL,int x, int y) {
		ImageView tuile = new ImageView("file:src/application/vue/" + URL);
		tuile.setTranslateX(16*x); 
        tuile.setTranslateY(tuile.getTranslateX()*y/x);
		paneMap.getChildren().add(tuile);
	}
	
    public void afficheEnnemis(ArrayList<Ennemis> listEnnemis) {
    	Ennemis lastEnnemis = listEnnemis.get(listEnnemis.size()-1);
    	ImageView iv1 ;
    	String s = "file:src/application/vue/";
    	if (lastEnnemis instanceof Bebe) {
    		iv1 = new ImageView(s + "BebeG.png");    	
    	}
    	
    	else if (lastEnnemis instanceof Enfant) {  		
    		iv1 = new ImageView(s  + "EnfantG.png");   		
    	}
    	
    	else { 		
    		iv1 = new ImageView(s + "AdoG.png");
    	}

    	iv1.setId(lastEnnemis.getId());
    	paneMap.getChildren().add(iv1);
    	iv1.xProperty().bind((lastEnnemis.getXProperty().multiply(16)));
    	iv1.yProperty().bind((lastEnnemis.getYProperty().multiply(16)));
    }
    
    public void tourelleSprite(Tours tour, double x, double y) {
		ImageView iv2;

		if (tour instanceof TourelleArcher ) {
			iv2 = new ImageView("file:src/application/vue/archer2.png");
			iv2.setFitWidth(80);
			iv2.setPreserveRatio(true);
		} 
		
		else if (tour instanceof TourelleMortier) {
			iv2 = new ImageView("textures/mortier.png");
			iv2.setFitWidth(50);
			iv2.setPreserveRatio(true);		
		}
		
		else {
			iv2 = null;
		}
		
		iv2.setTranslateX(x-16);
		iv2.setTranslateY(y-16);
		this.paneTour.getChildren().add(iv2);
	}
}