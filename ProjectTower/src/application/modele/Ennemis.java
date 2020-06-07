package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;

public abstract class Ennemis {
	protected IntegerProperty xProperty, yProperty;
	protected Jeu jeu;//plateau
	protected int pv, vit;
						//vitesse	
	private String id;
	//private ImageView iv1;
	
	public static int compteur = 0;//iteration de  int pour lattribution d'ID(je ne sais pas si ya besoin, au cas ou)

	public Ennemis(int x, int y, Jeu jeu,int pv, int vit) {
		this.pv=pv;
		this.xProperty = new SimpleIntegerProperty();
		this.xProperty.set(x);
		this.yProperty = new SimpleIntegerProperty();
		this.yProperty.set(y);
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
	
	public boolean nonSatisfait() {
		return this.pv > 0;
	}
	
	public void Satisfait() {
		this.pv = 0;
	}
	public String getId() {
		 return this.id;
	}
	public /*abstract*/ void seDeplace() {
		this.xProperty.setValue((this.xProperty.getValue()+1)*this.getVit());
		this.yProperty.setValue((this.yProperty.getValue()+1)*this.getVit());
	}
}
