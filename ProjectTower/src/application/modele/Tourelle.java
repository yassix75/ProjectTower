package application.modele;

import application.modele.Jeu;
import application.modele.Terrain;
import application.modele.Tours;

public class Tourelle extends Tours {


	public Tourelle(double x, double y, Jeu jeu) {
		super(x, y, jeu);
	} 
	
	//Booléen qui prend en paramètre la zone d'attaque de la tourelle (à tant de pixel) et un ennemi
	//vérifie si cette ennemi est à la portée de la tourelle et peut donc se faire tirer dessus par celui-ci
	public boolean ennemisProcheTirTourelleMultiple(double zoneAttaque) {
				return true;
	}

	@Override
	public void agit() {
		
	}


}
