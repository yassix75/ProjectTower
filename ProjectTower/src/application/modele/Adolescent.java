package application.modele;
public class Adolescent extends Ennemis {

	public Adolescent(Jeu jeu, int pv, int vit) {
		super(jeu, 20, 8);
	}
	public void moinsPv(Adolescent ados) {
		ados.moinsPv(0);//baissera de pv 2 si larcher le touche, de 10 si le mage le touche ou de 5 si le mortier le touche
	}
}
