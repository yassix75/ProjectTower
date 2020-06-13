package application.modele;


import application.modele.Ennemis;
import application.modele.Jeu;
import application.modele.Tours;

public class TourelleMortier extends Tours {

	public TourelleMortier(double x, double y,Jeu jeu) {
		super(x, y,jeu);
	}
	//Regarde si un ennemi est à sa portée (ici de 50 pixels), si c'est le cas, elle tir un projectile de glace sur l'ennemi
	public void tir() {
/*
		Ennemis ennemiViser= ennemieVisable(50);

		if (ennemiViser != null) {
			if(!getJeu().projectileExisteSurEnnemi(ennemiViser.getId())) {
				getJeu().getListeProjectile().add(new ProjectileFeu(this,ennemiViser,getJeu()));

			}
		}
		*/
	}
	@Override
	public void agit() {
		// TODO Auto-generated method stub
		
	}




}