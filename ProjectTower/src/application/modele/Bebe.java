package application.modele;

public class Bebe extends Ennemis {

	public Bebe(Jeu jeu, int pv, int vit) {
		super(jeu, 5, 2/*, "bebe.png"*/);
	}
	
	/*public void moinsPv(Bebe bebe) {
		bebe.moinsPv();//baissera de pv 2 si larcher le touche, de 10 si le mage le touche ou de 5 si le mortier le touche
	}
	*/
}
