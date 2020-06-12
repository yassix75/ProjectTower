package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Jeu;
import application.vue.JeuVue;
import application.vue.ObservateurListeProjectile;
import application.vue.ObservateurListeTours;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import application.modele.TourelleArcher;
import application.modele.TourelleMortier;
import application.modele.Tours;;

public class Controleur implements Initializable {
	
	@FXML
    private RadioButton buttonsorcier;
	
	@FXML
    private Button buttoncreationtour;
	
	@FXML
    private Pane panePrem;
	
	@FXML
    private RadioButton bouttonarcher;
	
    @FXML
    private TilePane mapTiledPane;

    @FXML
    private Pane paneMap;
    
    @FXML
    private Pane paneTour;

    @FXML
    private Pane paneEnnemis;
  
    @FXML
    private Pane paneTours;
   
    @FXML
    private VBox vbox;
    
    @FXML
    private Button lancer;

    @FXML
    private ToggleGroup Tourelle;
    
    @FXML
    private RadioButton archer;
    
    @FXML
    private RadioButton mortier;
   
    private Timeline gameLoop;
	
	private int nbTours;
    
	private boolean jeuEstFini;
	
	private Jeu jeu;
	
	private JeuVue jeuVueEnnemis;
	
	private JeuVue jeuVueMap;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	this.jeuEstFini=false;
    	this.jeu = new Jeu(57, 42);
		this.jeuVueMap = new JeuVue(jeu, paneMap);
		this.jeuVueEnnemis = new JeuVue(jeu, paneEnnemis);
		jeuVueMap.afficherMap(jeu);		
		this.jeu.getListeActeurs().addListener(new ObservateurListeTours(this.paneTours)) ;
		this.jeu.getListeProjectile().addListener(new ObservateurListeProjectile(this.paneTours));
		this.paneTours.setOnMouseClicked(clic -> {
			System.out.println("J'AI CLIQUE");
			double x = clic.getX();
			double y = clic.getY();
			x=this.jeu.placerTourelleMilieuTuileCoordonnee(x);
			y=this.jeu.placerTourelleMilieuTuileCoordonnee(y);    
			radioButton( x,  y) ;
		});
		gameLoop();
		gameLoop.play();
	}
  
    public void radioButton(double x, double y) {
    	RadioButton selectedToggleButton =(RadioButton) Tourelle.getSelectedToggle();	        
				Tours tour = null;      
				if(selectedToggleButton.getText().equals("Archer")) {						
					tour = new TourelleArcher(x,y,jeu);
				}				
				else if(selectedToggleButton.getText().equals("Mortier")) {
					tour = new TourelleMortier(x,y,jeu);				
				}
				else if(selectedToggleButton.getText().equals("Sorcier")) {
						tour = new TourelleMortier(x,y,jeu);				
					}
				this.jeu.ajouterTours(tour);
    }  
    
    @FXML
	 void Lancer(ActionEvent event) {
	 }
              
    private void gameLoop() {  
    	gameLoop = new Timeline();
    	nbTours = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf = new KeyFrame( 
                Duration.seconds(0.4),//slow = +
                (e -> {
                	this.jeu.tourDeJeuActeur();
                	this.jeu.tourDeJeuProjectile();
                    if (nbTours == 500 || this.jeuEstFini) {
                    	System.out.println("*********************************");
                        System.out.println("GAME OVER");
                        System.out.println("*********************************");
                        gameLoop.stop();
                    } 
                    else {			                      
                    	jeu.unTour(nbTours, jeuVueEnnemis);        
                    }	
                    nbTours++;
                }));
        gameLoop.getKeyFrames().add(kf);
	}
}