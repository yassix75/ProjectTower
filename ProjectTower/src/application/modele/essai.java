package application.modele;

import java.util.Random;

public class essai {
	private static Random random = new Random();

	public static void main(String[] args) {
		System.out.println(getRandomInt(0,10));

	}
	public static int getRandomInt(int min, int max){
		int n;
		do {
			n = random.nextInt(max - min + 1) + min;		
		}
		while(n%2!=1);		
		return n;
	}
}
