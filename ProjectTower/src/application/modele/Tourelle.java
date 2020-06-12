package application.modele;

import application.modele.Jeu;
import application.modele.Terrain;
import application.modele.Tours;

public class Tourelle extends Tours {


	public Tourelle(double x, double y, Jeu jeu) {
		super(x, y, jeu);
	} 
	
	//Bool�en qui prend en param�tre la zone d'attaque de la tourelle (� tant de pixel) et un ennemi
	//v�rifie si cette ennemi est � la port�e de la tourelle et peut donc se faire tirer dessus par celui-ci
	public boolean ennemisProcheTirTourelleMultiple(double zoneAttaque) {
				return true;
	}

	@Override
	public void agit() {
		
	}


}
