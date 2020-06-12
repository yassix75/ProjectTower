package application.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Tours {
	
	private DoubleProperty xProperty ;
	private DoubleProperty yProperty ;
	protected String id;
	protected Jeu jeu;
	public static int compteur=0;
	
	public Tours(double x, double y, Jeu jeu) {
		this.jeu = jeu;	
		this.xProperty =new SimpleDoubleProperty(x) ;
		this.yProperty =new SimpleDoubleProperty(y) ;
	}
	
	
	public int getCompteur() {
		return compteur;
	}
	
	public void setCompteur(int newCompteur) {
		compteur=newCompteur;
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
		return id;
	}
	
	public Jeu getJeu() {
		return this.jeu;
	}
	
	public abstract void agit();
	
	public void attaque(Ennemis e) {
		int x = 0;
		int y = 0;
		int attaque = 1;
		if(Math.sqrt(Math.pow(e.getX()-x, 2)+Math.pow(e.getY()-y,2))<=9)

			e.decrementerPv(attaque);
			}
		
	
        
	
	public String toString() {
		return "Position: x="+ this.xProperty + " y="+ this.yProperty+ "\n Id:" + this.id;		
	}
}

