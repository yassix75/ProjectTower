package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Terrain {
	private String [][] terrain;
	
	public Terrain() {
		lecteurMap();
	}
	
	public void lecteurMap (){
		String csvFile = "src/application/modele/towerdeflight.csv";
        BufferedReader br = null;
        String line = "";
        this.terrain = new String [57][42];
        int lignecourante = 0;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	System.out.println(line);
            	for(int i = 0; i < line.split(";").length; i++)
            		terrain[lignecourante][i]=line.split(";")[i];
            	lignecourante++;
            }
			for(int x = 0; x < terrain.length; x++) {
				System.out.println();
				for(int y = 0; y < terrain[x].length; y++)
					System.out.print(terrain[x][y] + " ");
			}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
