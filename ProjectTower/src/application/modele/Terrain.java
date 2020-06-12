package application.modele;

import java.util.Random;

import javafx.scene.layout.TilePane;

public class Terrain {
	private int width = 480;
	private int height = 480;


	private int[] mapDesert = {	5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5,  4 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1,
								5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								5 , 5 , 5 , 5 , 5 , 5 , 5 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								5 , 5 , 5 , 5 , 5 , 5 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 51, 
								5 , 5 , 5 , 5 , 5 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 51, 
								5 , 5 , 5 , 5 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 51, 
								6 , 7 , 8 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								5 , 9 , 4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								5 , 10, 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								4 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								1 , 3 , 3 , 3 , 3 , 11, 12, 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								1 , 3 , 3 , 3 , 3 , 13, 14, 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 15, 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 49, 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 46, 47, 48, 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 45, 44, 43, 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2,  3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1, 
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 41, 42, 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 40, 39, 38, 37, 36, 3 , 3 , 3 , 1,
								50, 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 31, 32, 33, 35, 34, 3 , 3 , 3 , 1,
								50, 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 19, 20, 21, 3 , 3 , 3 , 3 , 3 , 3 , 3 , 29, 30, 3 , 26, 3 , 3 , 3 , 3 , 1,
								50, 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 18, 17, 16, 3 , 3 , 3 , 3 , 3 , 3 , 3 , 28, 27, 3 , 25, 3 , 3 , 3 , 3 , 1,
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 24, 23, 3 , 3 , 3 , 1, 
								1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 22, 3 , 3 , 3 , 1,
								1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1};


	public Terrain() {
		

	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public int getNumeroTuile(int indice) {
		return this.mapDesert[indice];
	}

	public int[] getMap() {
		return mapDesert;
	}
	
	
	public int codeTuile(int indice) {
		return this.getNumeroTuile(indice);
	}

	public int getTuileSansClic(double x, double y) {
		double valeurX = x;
		double valeurY = y;
		int indice = 0;
		while (valeurX >= 16) {
			valeurX-=16;
			indice ++;
		}
		while (valeurY >= 16) {
			valeurY-=16;
			indice += 30;
		}
		return indice;
	}

	
	
	//Ces 2 m�thodes emp�chent les ennemis de sortir du chemin et de se balader sur la carte
	public boolean dansTerrain(double d, double e) {
		return (0 <= d && d<this.width && 0<=e && e< this.height);
	}

	public boolean dansChemin(int indice) {
		if(this.codeTuile(indice) ==2 || this.codeTuile(indice) == 50 || this.codeTuile(indice) == 51) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Ces 2 m�thode permettent de r�cup�rer une des 3 tuiles du d�but et fin de chemin 
	//ce qui nous permet de placer les ennemis et la frande Tour au bonne endroit 
	public int getIndiceTuileDebutChemin() {

		int indice = 0;
		//compte nombre d'occurence de 50
		int compteurCase50 = 0;

		//recupere l'indice du 1ere, 2eme et 3eme occurence de 50
		int indice50_1 = 0;
		int indice50_2 = 0;
		int indice50_3 = 0;

		for(int i = 0; i < mapDesert.length; i++) {

			if(mapDesert[i] == 50) {
				compteurCase50++;
			}

			if(mapDesert[i] == 50 && compteurCase50 == 1) {
				indice50_1 = i;
			}
			if(mapDesert[i] == 50 && compteurCase50 == 2) {
				indice50_2 = i;
			}
			if(mapDesert[i] == 50 && compteurCase50 == 3) {
				indice50_3 = i;
			}
		}

		Random random = new Random();
		int alea = random.nextInt(3);

		if (alea == 0) {
			indice = indice50_1;
		}
		if (alea == 1) {
			indice = indice50_2;
		}
		if (alea == 2) {
			indice = indice50_3;
		}

		return indice; 
	}

	public int getIndiceTuileFinChemin() {

		int indice = 0;
		//compte nombre d'occurence de 
		int compteurCase50 = 0;

		//recupere l'indice du 1ere, 2eme et 3eme occurence de 50
		int indice51_1 = 0;
		int indice51_2 = 0;
		int indice51_3 = 0;

		for(int i = 0; i < mapDesert.length; i++) {

			if(mapDesert[i] == 51) {
				compteurCase50++;
			}

			if(mapDesert[i] == 51 && compteurCase50 == 1) {
				indice51_1 = i;
			}
			if(mapDesert[i] == 51 && compteurCase50 == 2) {
				indice51_2 = i;
			}
			if(mapDesert[i] == 51 && compteurCase50 == 3) {
				indice51_3 = i;
			}
		}

		Random random = new Random();
		int alea = random.nextInt(3);

		if (alea == 0) {
			indice = indice51_1;
		}
		if (alea == 1) {
			indice = indice51_2;
		}
		if (alea == 2) {
			indice = indice51_3;
		}

		return indice;
	}
	
	
	//Cette m�thode est peut �tre � placeer dans la classe tourelle
	



}


