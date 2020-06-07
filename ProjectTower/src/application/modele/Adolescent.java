package application.modele;
public class Adolescent extends Ennemis {

	public Adolescent(int x, int y, Jeu jeu) {
		super(x, y, jeu, 20,2);
	}
	public void moinsPv(Adolescent ados) {
		ados.moinsPv(0);//baissera de pv 2 si larcher le touche, de 10 si le mage le touche ou de 5 si le mortier le touche
	}
}
