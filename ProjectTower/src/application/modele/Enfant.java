package application.modele;

public class Enfant extends Ennemis{

	public Enfant(Jeu jeu) {
		super( jeu, 10, 1.25);
		super.id = "#E"+compteur;//cherche id de la superclasse
		compteur++;
	}

	@Override
	protected void decrementerPv(Object attaque) {
		// TODO Auto-generated method stub
		
	}
}
