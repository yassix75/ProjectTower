package application.modele;
//Le terme sprite a plusieurs significations.
//Il est utilisé pour désigner une image ou une animation dans une scène.
import application.modele.Tours;
import application.modele.TourelleArcher;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CreerSprite {

	private Pane paneTour;

	public CreerSprite(Pane paneTour) {
		this.paneTour = paneTour;
	}

	/*public void tourelleSprite(Tours tour, double x, double y) {
		ImageView iv;
		
		if (tour instanceof TourelleArcher ) {
			iv = new ImageView(new Image("file:src/application/vue/"+"archer2.png"));
			iv.setFitWidth(80);
			iv.setPreserveRatio(true);
		}
		else if (tour instanceof TourelleMortier) {
			iv = new ImageView("textures/mortier.png");
			iv.setFitWidth(50);
			iv.setPreserveRatio(true);
		}
		else {//faire une 3eme tour, tour mage
			iv = null;
		}

		iv.setTranslateX(x-16);
		iv.setTranslateY(y-16);
		//plateau.getChildren().add(texture);
	}*/

}