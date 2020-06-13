package application.modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.beans.property.IntegerProperty;
 	
public class EnnemisTest {
	private Jeu jeu;
	private Ennemis ennemi = new Bebe(jeu);
	private Ennemis ennemi3 = new Enfant(jeu);
	private Ennemis ennemi2 = new Enfant(jeu);
	private Ennemis ennemi4 = new Adolescent(jeu);
	private Ennemis ennemi5 = new Adolescent(jeu);
	protected IntegerProperty xProperty, yProperty;

	@Test
	void testMoinsPv() {
		ennemi.moinsPv(1);	
		assertEquals(4,this.ennemi.getPv(),"perte d'un point de pv pour le bebe");
		
		ennemi.moinsPv(10);
		assertEquals(0, this.ennemi.getPv(),"perte de plus de point de pv que de pv restant");
	}

	@Test
	void testSatisfait() {
		ennemi.moinsPv(5);
		ennemi2.moinsPv(60);
		ennemi3.moinsPv(2);
		
		assertTrue(ennemi.getPv() <= 0,"True si l'ennemi est satisfait,cas pv = 0");
		assertTrue(ennemi2.getPv() <= 0,"cas pv < 0");		
		assertFalse(ennemi3.getPv() <= 0, "cas pv > 0");
	}

	@Test
	void testSeDeplaceG() {
		ennemi.setX(9);
		ennemi.setY(8);
		ennemi.seDeplaceG();
		
		assertEquals(8,ennemi.getX());
		assertEquals(8,ennemi.getY());
	}

	@Test
	void testSeDeplaceB() {
		ennemi.setX(0);
		ennemi.setY(0);
		ennemi.seDeplaceB();
		
		assertEquals(0,ennemi.getX());
		assertEquals(1,ennemi.getY());
	}

	@Test
	void testSeDeplaceD() {
		ennemi.setX(9);
		ennemi.setY(8);
		ennemi.seDeplaceD();
		
		assertEquals(10,this.ennemi.getX());
		assertEquals(8,ennemi.getY());
	}

	@Test
	void testSeDeplace() {
		ennemi.setX(0);
		ennemi.setY(7);
		
		ennemi2.setX(28);
		ennemi2.setY(7);
		
		ennemi3.setX(41);
		ennemi3.setY(9);
		
		ennemi4.setX(19);
		ennemi4.setY(35);
		
		ennemi5.setX(25);
		ennemi5.setY(28);
		
		ennemi.seDeplace();
		ennemi2.seDeplace();
		ennemi3.seDeplace();
		ennemi4.seDeplace();
		ennemi5.seDeplace();
		
		assertEquals(1, ennemi.getX());
		assertEquals(1, ennemi2.getX());
		assertEquals(1, ennemi3.getX());
		assertEquals(1, ennemi4.getX());
		assertEquals(1, ennemi5.getX());
	}

	@Test
	void testAtteintMaison() {
		fail("Not yet implemented");
	}

}
