package application.modele;

import application.modele.Jeu;
import application.modele.Terrain;

import application.modele.Tourelle;

public class TourelleArcher extends Tourelle{

	public TourelleArcher(double x, double y, Jeu jeu ) {
	super(x, y, jeu);
	}

	//Regarde si un ennemi est à sa portée (ici de 50 pixels), si c'est le cas, elle tir un projectile de feu sur l'ennemis
	public void tir() {


	}
}
