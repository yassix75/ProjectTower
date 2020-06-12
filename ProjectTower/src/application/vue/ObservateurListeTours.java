package application.vue;

import application.modele.Ennemis;
import application.modele.TourelleArcher;
import application.modele.Tours;



import javafx.collections.ListChangeListener;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class ObservateurListeTours implements ListChangeListener<Tours> {

	private Pane plateau;

	public ObservateurListeTours(Pane plateau) {
		super();
		this.plateau = plateau;
	}

	public void acteurSprite(Tours tour) {
		Circle circle ;
		ImageView texture = null;
		if(tour instanceof TourelleArcher) {
			texture=new ImageView("textures/mortier.png");
		}else {
			texture=new ImageView("textures/archer2.png");
		}
		texture.setFitHeight(70);
		texture.setFitWidth(70);
		texture.xProperty().bind(tour.xProperty());
		texture.yProperty().bind(tour.yProperty());
		this.plateau.getChildren().add(texture);
	}
	
	private void enleverSprite (Ennemis ennemiSatisfait) {
		this.plateau.getChildren().remove(this.plateau.lookup("#" + ennemiSatisfait.getId()));
	}


	@Override
	public void onChanged(Change<? extends Tours> c) {

		while(c.next()){
			// on cree leur sprite dès qu'un ennemis est ajouter à la liste .
			for (Tours newTour: c.getAddedSubList()){
				acteurSprite(newTour);
			}
		}
	}
	/*	@Override
	public void onChangedd(Change<? extends Ennemis> c) {

		while(c.next()){
			// on cree leur sprite dès qu'un ennemis est ajouter à la liste .
			for (Ennemis ennemiSatisfait: c.getRemoved()){
				enleverSprite (ennemiSatisfait);
			}t
		}
	}*/

	// gestion des ennemis morts
				// on enleve leur sprite dès qu'un ennemis est retirer de la liste .
}

