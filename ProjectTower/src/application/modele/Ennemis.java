package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;

public /*abstract*/ class Ennemis {
	protected IntegerProperty x, y;
	protected Jeu jeu;//plateau
	protected int pv, vit;
						//vitesse	
	private String id;
	//private ImageView iv1;
	
	public static int compteur = 0;//iteration de  int pour lattribution d'ID(je ne sais pas si ya besoin, au cas ou)

	public Ennemis(int x, int y, Jeu jeu,int pv, int vit) {
		this.pv=pv;
		this.x = new SimpleIntegerProperty();
		this.x.set(x);
		this.y = new SimpleIntegerProperty();
		this.y.set(y);
		this.vit = vit;
		this.jeu=jeu;	
		
		this.id="E"+compteur;
		compteur++;
	}
	
	public Ennemis(Jeu jeu,int pv, int vit/*, String URL*/) {
		this.pv=pv;
		this.vit = vit;
		this.jeu=jeu;	
	//	this.iv1 =  new ImageView("file:src/application/vue/" + URL);
		this.id="E"+compteur;
		compteur++;
	}
	
	public int getX() {
		return x.getValue();
	}

	public void setX(int x) {
		this.x.set(x); 
	}
	
	public int getY() {
		return y.getValue();
	}

	public void setY(int y) {
		this.y.set(y); 
	}
	
	public IntegerProperty getXProperty() {
		return this.x;
	}

	public IntegerProperty getYProperty() {
		return this.y;
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
	
	public boolean nonSatisfait() {
		return this.pv>0;
	}
	
	public void Satisfait() {
		this.pv = 0;
	}
	 public String getId() {
		 return this.id;
	 }
}
