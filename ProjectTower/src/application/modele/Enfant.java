package application.modele;

public class Enfant extends Ennemis{

	public Enfant(Jeu jeu) {
		super( jeu, 10, 1);
		super.id = "#E"+compteur;//cherche id de la superclasse
		compteur++;
	}
}
