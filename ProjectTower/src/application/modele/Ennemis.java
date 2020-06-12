package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemis {

	protected IntegerProperty xProperty, yProperty;
	protected Jeu jeu;//plateau
	protected int pv;
	protected int vit;
	protected String id;
	private int deplacementX;
	private int deplacementY;
	public static int compteur = 0;//iteration de  int pour lattribution d'ID(HashMap avec type d'ennemi + Id)
	
	public Ennemis(Jeu jeu,int pv, int vit) {
		this.jeu = jeu;
		this.deplacementX = 1;
		this.deplacementY = 1;
		this.pv = pv;
		this.vit = vit;	
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
	
	public void moinsPv(int pv) {//5-2
		if(pv > this.pv) {
			pv = this.pv;
		}
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
		this.setX(this.getX()-this.deplacementX*this.getVit());
	}
	
	public void seDeplaceB() {
		this.setY(this.getY() + this.deplacementY*this.getVit());
		
	}
	
	public void seDeplaceD() {
		this.setX(this.getX() + this.deplacementX*this.getVit());
		
	}
	
	public void seDeplace() {	
		if(this.pv>0){	     
			
			if ( this.getX() < 42 && this.getY() == 7) {
				this.seDeplaceD();
				System.out.println(this.getId() + " se dirige vers la droite");
			}
			if ( this.getX() == 28 && this.getY() == 7) { 
				this.seDeplaceD();
				System.out.println(this.getId() + " se dirige vers la droite");
			}
			if (this.getX() == 41 && this.getY() < 19) { 
				this.seDeplaceB();		
				System.out.println(this.getId() + " va en bas");																							//deplace vers le bas2, commence a y = a y = 
			}
			if (this.getY() == 19 && this.getX() < 42) {
				this.seDeplaceG();
				System.out.println(this.getId() + " se dirige vers la gauche");
			}
			if (this.getY() < 30 && this.getX() == 28) {
				this.seDeplaceB();		
				System.out.println(this.getId() + " va en bas");
			}
		}
	}	
	
	public boolean atteintMaison() {
		return this.getY() == 30;
	}

	public String toString() {
		return "pv"+pv;
	}
	
}
