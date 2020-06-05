package application.modele;

import javafx.beans.property.IntegerProperty;

public abstract class Ennemis {
	protected IntegerProperty xIntegerProperty;
	protected IntegerProperty yIntegerProperty;
	protected Jeu jeu;//plateau
	protected int pv;
	protected int pa;
	protected int vit;//vitesse
	protected int compteur;//iteration de  int pour lattribution d'ID(je ne sais pas si ya besoin, au cas ou)
	
	
	
	
	
	public Ennemis() {
		
	}

}
