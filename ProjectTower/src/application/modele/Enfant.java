package application.modele;

public class Enfant extends Ennemis{

	public Enfant(Jeu jeu, int pv, int vit) {
		super(jeu, 10, 4);
	}
	public void moinsPv(Enfant enfant) {
		enfant.moinsPv(0);//baissera de pv 2 si larcher le touche, de 10 si le mage le touche ou de 5 si le mortier le touche
	}
}
