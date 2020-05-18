package model;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class TileLayer {
	// on a une matrice cr�e 
	private static  int[][] map; //map pas static car on est en oriant� objet donc le changer
	
	// Recuperer une image

	private BufferedImage tileSheet;
	//Un constructeur pour initialiser la map 
	public TileLayer(int width , int height )
	{
		map = new int[height][width];
	}


	//Une fonction pour copier le contenu du fichier texte vers la 
	public static TileLayer FromFile(String fileName){

		TileLayer layer = null;
    //tmplayout est une matrice temporaire
		 ArrayList<ArrayList<Integer>> tempLayout = new ArrayList<>();
         		 
	//recuperer le contenu du fichier text
		 try(BufferedReader br = new BufferedReader((new FileReader(fileName))))
		 {
           String currentLine;
    //Parcourrir le fichier text lign par ligne 
           while((currentLine = br.readLine()) !=null)
           {
    //Si la ligne est vide continuer 
        	   if(currentLine.isEmpty())
        		   continue;
    // Si la ligne n'est pas vide cr�e une variable qui s'apl row (tableau d'entier)
        	   ArrayList<Integer> row =  new ArrayList<>();
        	   String[] values = currentLine.trim().split(" ");
        	   for(String s:values)
        	   {
        		   if(!s.isEmpty())
        		   {
        			   int id = Integer.parseInt(s);
        			   row.add(id);
        		   }
        	   }
        	   tempLayout.add(row);
           }
		 }
		 catch(IOException e){

		  System.out.print(e);

		 }

		 int width = tempLayout.get(0).size();
		 int height = tempLayout.size();
		 layer = new TileLayer(width, height);
		 for(int y=0;y< height;y++)
		 {
			 for(int x=0;x<width;x++)
			 {
				 layer.map[y][x]= tempLayout.get(y).get(x);
			 }
		 }



		return layer;

	}

	public BufferedImage LoadTileSheet(String fileName){

	BufferedImage img = null;
	try {
		img = ImageIO.read(new File(fileName));
	}
	catch(IOException e){
		System.out.println("Could not load Image!");
	}
     return img;
	}

	public 	void DrawLayer( Graphics g){   //Pk ??
		for(int y=0; y<map.length;y++ )
		{
			for (int x=0; x<map[y].length;x++)
			{
             int index = map[y][x];
             int yoffset=0;

			}
		}
	}
	
	public static int[][] getMap()
	{
		return map;
	}

	public static void main(String[] args) {
		TileLayer t = TileLayer.FromFile("C:\\Users\\toto\\git\\ProjectTower\\ProjectTower\\src\\model\\map.txt");
		System.out.println(t.map[0].length);
	}
}