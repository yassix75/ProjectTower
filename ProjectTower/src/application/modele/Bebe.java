package application.modele;

public class Bebe extends Ennemis {

	public Bebe(Jeu jeu) {
		super(jeu, 5, 1);
		super.id = "#B"+compteur;//cherche id de la superclasse
		compteur++;
	}
}
