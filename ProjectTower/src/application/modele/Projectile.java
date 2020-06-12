package application.modele;

import application.modele.Tours;
import application.modele.Jeu;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Projectile {

	private Tours positionTourelle;
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
}

