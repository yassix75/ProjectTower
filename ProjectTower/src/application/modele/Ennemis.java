package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemis {
	protected IntegerProperty xIntegerProperty;
	protected IntegerProperty yIntegerProperty;
	protected Jeu jeu;//plateau
	protected int pv;
	protected int pa;
	protected int vit;//vitesse
	private SimpleIntegerProperty x;
	private SimpleIntegerProperty y;
	private String id;
	public static int compteur = 0;//iteration de  int pour lattribution d'ID(je ne sais pas si ya besoin, au cas ou)

	public Ennemis(int x, int y, int v, Jeu jeu,int pv) {
		this.pv=pv;
		this.x= new SimpleIntegerProperty();
		this.x.set(x);
		this.y = new SimpleIntegerProperty();
		this.y.set(y);
		this.vit = vit;
		this.jeu=jeu;	
		this.id="E"+compteur;
		compteur++;
	}
	public IntegerProperty getYProperty() {
		return this.y;
	}
	
	public IntegerProperty getXProperty() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getForce() {
		return force;
	}
	
	public void setForce(int force) {
		this.force = force;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public String getTypecadeau() {
		return typecadeau;
	}
	public void setTypecadeau(String typecadeau) {
		this.typecadeau = typecadeau;
		
	}
	public void sedeplacer(int x1, int y1) {
		this.x= (getX()-x1)*getVitesse();
		this.y= (getY()-y1)*getVitesse();
	
	}
	public boolean est_vivant() {
		return force>0;
	}
}
