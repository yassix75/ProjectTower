package application.modele;
public class Adolescent extends Ennemis {

	public Adolescent(Jeu jeu) {
		super(jeu, 20,1);
		super.id = "#A"+compteur;
		compteur++;
	}
}