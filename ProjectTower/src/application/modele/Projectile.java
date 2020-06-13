package application.modele;

import application.modele.Tours;
import application.modele.Jeu;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Projectile {

	private  Tours positionTourelle;
    private String id;
	private DoubleProperty xProperty ;
	private DoubleProperty yProperty ;
 


	public Projectile(Tours tourelleDepart, Jeu jeu) {


		this.positionTourelle=tourelleDepart;
		this.xProperty =new SimpleDoubleProperty(tourelleDepart.getX()) ;
		this.yProperty =new SimpleDoubleProperty(tourelleDepart.getY()) ;
	}



	public double getX() {
		return xProperty.getValue();
	}

	public void setX(double newPositionX) {
		xProperty.setValue(newPositionX) ;
	}

	public DoubleProperty xProperty() {
		return this.xProperty ;
	}

	public double getY() {
		return yProperty.getValue() ;
	}

	public void setY(double newPositionY) {
		yProperty.setValue(newPositionY) ;
	}

	public final DoubleProperty yProperty(){
		return this.yProperty ;
	}

	public String getId() {
		return this.id;
	}

	public void agit() {

			//Regarde la différence de coordonées entre le projectile est l'ennemi
			//pour savoir vers où le projectile doit se déplacer



			//Modification des coordonées de la projectile en fonction du calcul précédent


			//Cas où le projectile à toucher l'ennemi
			//Retire  les pv à l'ennemi
			//Si 'ennemi n'a plus de pv et est donc mort il est retirer de la liste d'acteur et le joueur gagne de l'argent
			//Le projectile est aussi retirer de la liste de projectile

		///////UTILISER POINT2D!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//Je vais demander pour le point2D ouiii et on va ajoute la tour mage
		//en gros c recopier pareil que les autres classe de tour 
	}



}

