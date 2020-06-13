package application.vue;

import application.modele.Projectile;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ObservateurListeProjectile implements ListChangeListener<Projectile> {

	private Pane plateau;

	public ObservateurListeProjectile(Pane plateau) {
		super();
		this.plateau = plateau;
	}

	public void spriteProjectile(Projectile projectile) {
		Circle p;

			p = new Circle(2, Color.RED);


		p.setId(projectile.getId());
		p.translateXProperty().bind(projectile.xProperty()) ;
		p.translateYProperty().bind(projectile.yProperty()) ;
		plateau.getChildren().add(p);
	}

	public void supprimerProjectile(Projectile projectile) {
		this.plateau.getChildren().remove(this.plateau.lookup("#" + projectile.getId()));
	}

	@Override
	public void onChanged(Change<? extends Projectile> c) {

		while(c.next()){

			// on cree leur sprite dès qu'un projectile est ajouter à la liste .
			for (Projectile nouveau: c.getAddedSubList()){
				spriteProjectile(nouveau);
			}

			// on enleve leur sprite dès qu'un projectile est retirer de la liste.
			for (Projectile project: c.getRemoved()){
				supprimerProjectile(project);
			}
		}



	}

}

