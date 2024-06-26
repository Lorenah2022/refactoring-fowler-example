package ubu.gii;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1
 * 
 * 
 */
public class VideoClubTest {
	protected static Movie m01,m02, m11, m12, m2;
	protected static Customer c1;
	
	@BeforeAll
	public static void setUp() {
		m11 = new Movie("Sky Captain", 1);
		m12 = new Movie("Alejandro Magno", 1);
		m01 = new Movie("Accion Mutante", 0);
		m2 = new Movie("Hermano Oso", 2);
		m02 = new Movie("Dune", 0);

		c1 = new Customer("Manuel");
		
		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m01, 1);
		Rental r3 = new Rental(m2, 10);
		Rental r4 = new Rental(m02,6);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);
		c1.addRental(r4);

	}

	@AfterAll
	public static void tearDown() throws Exception {}

	@Test
	public void testStatement() {

		
		String salida = c1.statement();

		String salidaEsperada = new String("Rental Record for Manuel\n"
				+ "\tSky Captain\t15.0\n" + "\tAccion Mutante\t2.0\n"
				+ "\tHermano Oso\t12.0\n" + "\tDune\t8.0\n" + "Amount owed is 37.0\n"
				+ "You earned 5 frequent renter points");
		
		assertTrue(salidaEsperada.equals(salida),"Calcula mal el alquiler");

	}
	
	@Test
	public void testhtmlStament() {


		String salida = c1.htmlStatement();

		String salidaEsperada = new String("<h1>Rental Record for Manuel</h1>\n"
				+ "Sky Captain : 15.0<br>\n" + "Accion Mutante : 2.0<br>\n"
				+ "Hermano Oso : 12.0<br>\n" + "Dune : 8.0<br>\n" + "<p>Amount owed is 37.0</p>\n"
				+ "<p> You earned 5 frequent renter points </p>");
		
	
		
		assertTrue(salidaEsperada.equals(salida),"Calcula mal el alquiler");

	}

}