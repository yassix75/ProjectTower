package application.modele;
public class Adolescent extends Ennemis {

	public Adolescent(Jeu jeu) {
		super(jeu, 20,1);
		super.id = "#A"+compteur;//cherche id ds la superclasse
		compteur++;
	}

	@Override
	protected void decrementerPv(Object attaque) {
		// TODO Auto-generated method stub
		
	}
}