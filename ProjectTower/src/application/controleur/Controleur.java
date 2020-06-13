package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;
import application.modele.Ennemis;
import application.modele.Jeu;
import application.vue.JeuVue;
import application.vue.ObservateurListeProjectile;
import application.vue.ObservateurListeTours;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import application.modele.CreerSprite;
import application.modele.Terrain;
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
	
	private CreerSprite sprite;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	this.jeuEstFini=false;
		this.jeu = new Jeu(57, 42); 
    	JeuVue jeuVueMap = new JeuVue(jeu, paneMap);
    	JeuVue jeuVueTours = new JeuVue(jeu, paneTours);
		jeuVueMap.afficherMap(jeu);
		sprite = new CreerSprite(paneTours);		
		this.jeu.getListeActeurs().addListener(new ObservateurListeTours(this.paneTours)) ;
		this.jeu.getListeProjectile().addListener(new ObservateurListeProjectile(this.paneTours));

		this.paneTours.setOnMouseClicked(clic -> {
			System.out.println("J'AI CLIQUE");
			double x = clic.getX();
			double y = clic.getY();
			x=this.jeu.placerTourelleMilieuTuileCoordonnee(x);
			y=this.jeu.placerTourelleMilieuTuileCoordonnee(y);    
			initialize( x,  y) ;
		});
		gameLoop();
		gameLoop.play();
	}
    //dire que lorsque l'on clique sur un toggle sa apl ajt tourelle 
  
    public void initialize(double x, double y) {
    	RadioButton selectedToggleButton =(RadioButton) Tourelle.getSelectedToggle();
    	System.out.println("LE TOGGLE "+selectedToggleButton );
		        
				Tours tour = null;
           // System.out.println(selectedToggleButton.getText());       
				if(selectedToggleButton.getText().equals("Archer")) {						
					tour = new TourelleArcher(x,y,jeu);
				}
				
				else if(selectedToggleButton.getText().equals("Mortier")) {
					tour = new TourelleMortier(x,y,jeu);
				
				}
				else if(selectedToggleButton.getText().equals("Sorcier")) {
						tour = new TourelleMortier(x,y,jeu);
					
					}

				
				// this..tourelleSprite(tour, x, y);
				this.jeu.ajouterTours(tour);
    }  
    
    @FXML
	 void Lancer(ActionEvent event) {
		 //System.out.println("Appuie sur Lancer");
	 }
              
    private void gameLoop() {  
    	gameLoop = new Timeline();
    	nbTours = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf = new KeyFrame( //(nbre de frame par seconde)
                Duration.seconds(0.4),//slow = +
                (e -> {
                	this.jeu.tourDeJeuProjectile();
                    if (nbTours == 500 || this.jeuEstFini) {
                    	System.out.println("*********************************");
                        System.out.println("GAME OVER");
                        System.out.println("*********************************");
                        gameLoop.stop();
                    } else {			                      
                       unTour(nbTours);        
                    }
                    nbTours++;
                }));
        gameLoop.getKeyFrames().add(kf);
	}
    
	private void unTour(int nbTour) {
		JeuVue jeuVueEnnemis = new JeuVue(this.jeu, paneEnnemis);
		int rdm = Jeu.getRandomInt(1, 4);		
		if (nbTour % rdm == 0) {
			//System.out.println(this.jeu.getListEnnemis());	
			this.jeu.creationNouveauEnnemi();
			//System.out.println("Les ennemis ne vont pas tarder à vous attaquer");
			jeuVueEnnemis.afficheEnnemis(this.jeu.getListEnnemis());
		}
		for (Ennemis ennemis : this.jeu.getListEnnemis()) {
			ennemis.seDeplace();
			if(ennemis.atteintMaison()) {
				this.jeuEstFini=true;
			}
		}
		//System.out.println(this.jeuEstFini);
		/*
		for(int i = 0; i < this.jeu.getListEnnemis().size(); i++) {   ///////verif pv de ennemi
			ennemi = this.jeu.getListEnnemis().get(i);
			if (ennemi.Satisfait()) {
				this.jeu.getListEnnemis().remove(i);
			}
		System.out.println(" loop");			
		}*/
	}
	/*
	 * Faire une loop qui parcours la liste des ennemis et des tours -> determine les ennemis qui sont à range des tours avec x et y
	 * Faire tirer la tour quand elle est à portée d'un ennemi -> ajoter dans la liste observable projectile 
	 * Lancer le projetile -> deplacement (position du projectile - position de l'ennemi)
	 * 
	 */  //des que le mec podse une tour decrementer les pv du premier monstre de la liste 
}