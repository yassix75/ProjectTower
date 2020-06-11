package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemis {

	protected IntegerProperty xProperty, yProperty;
	protected Jeu jeu;//plateau
	protected int pv, vit;
	protected String id;
	private int deplacementx;
	private int deplacementy;
	public static int compteur = 0;//iteration de  int pour lattribution d'ID(HashMap avec type d'ennemi + Id)
	
	public Ennemis(Jeu jeu,int pv, double vit) {
		this.jeu = jeu;
		this.deplacementx = 1;
		this.deplacementy = 1;
		this.pv = pv;
		this.vit = (int) vit;	
		this.xProperty = new SimpleIntegerProperty(0);		
		this.yProperty = new SimpleIntegerProperty(7);
	}
	
	public final void setX(int x) {
		this.xProperty.setValue(x); 
	}
	
	public final void setY(int y) {
		this.yProperty.setValue(y); 
	}
	
	public final int getX() {
		return xProperty.getValue();
	}
	
	public final int getY() {
		return yProperty.getValue();
	}
	
	public final IntegerProperty getXProperty() {
		return this.xProperty;
	}

	public final IntegerProperty getYProperty() {
		return this.yProperty;
	}
	
	public int getPv() {
		return this.pv;
	}
	
	public void setPv(int pv) {
		this.pv = pv;
	}
	
	public void plusPv(int pv) {
		this.pv += pv;
	}
	
	public void moinsPv(int pv) {
		this.pv -= pv;
	}
	
	public int getVit() {
		return this.vit;
	}
	
	public void setVit(int vit) {
		this.vit = vit;
	}
	
	public boolean Satisfait() {
		return this.pv <= 0;
	}
	
	public String getId() {
		 return this.id;
	}
	
	public void seDeplaceG() {
		this.setX(this.getX()-this.deplacementx);
	}
	
	public void seDeplaceB() {
		this.setY( this.getY() + this.deplacementy);
		
	}
	
	public void seDeplaceD() {
		  this.setX( this.getX() + this.deplacementx);
		
	}
	
	public void seDeplace() {	
		if ( this.getX() < 42 && this.getY() == 7) { //deplace vers la droite, commence a x = 0 a x = 41
			this.seDeplaceD();
			System.out.println(this.getId());
			System.out.println("Droite");
		}
		if ( this.getX() == 28 && this.getY() == 7) { //deplace vers la droite, if pour gerer le "conflit" entre droite et bas2
			this.seDeplaceD();
			System.out.println(this.getId());
			System.out.println("Droite");
		}
		if (this.getX() == 41 && this.getY() < 19) { //deplace vers bas1, commence a y = 7 a y = 19
			this.seDeplaceB();		
			System.out.println("Bas1");																							//deplace vers le bas2, commence a y = a y = 
		}
		if (this.getY() == 19 && this.getX() < 42) { //deplace vers le bas, commence a x = 41 a x = 28
			this.seDeplaceG();
			System.out.println(this.getId());
			System.out.println("Gauche");
		}
		if (this.getY() < 30 && this.getX() == 28) { //this.getX() == 28 && this.getY() == 19
			this.seDeplaceB();		
			System.out.println("Bas2");
		}
	}	
	
	public boolean atteintMaison() {
		System.out.println(this.getY());
		return (this.getY() == 30);
	}//oui
}
