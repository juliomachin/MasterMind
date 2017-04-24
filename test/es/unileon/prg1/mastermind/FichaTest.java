package es.unileon.prg1.mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 *  
 *
 */
public class FichaTest {
	private Ficha ficha;
	
	
	@Before
	
	public void setUp() throws MastermindException {
		this.ficha=new Ficha('R');
	}
	@Test(expected=MastermindException.class)
	public void testExcepcion() throws MastermindException{
		Ficha ficha=new Ficha('K');
	}
/**
 * 
/**
 * Comprueba que devuelva correctamente el color
 */
	@Test
	public void testGetColor() {
		assertEquals(ficha.getColor(),'R');
		assertNotSame(ficha.getColor(),'V');
		
	}
/**
 * Comprueba que se cambie correctamente el color
 * @throws MastermindException 
 * 
 */
	@Test
	public void testSetColor() throws MastermindException {
		ficha.setColor('G');
		assertEquals(ficha.getColor(),'G');
		assertNotSame(ficha.getColor(),'R');
	}
/**
 * Comprueba que se cambie el color a un caracter no perteneciente a los colores disponibles
 * @throws MastermindException 
 * 
 */
	@Test
	public void testSinColor() throws MastermindException {
		
		ficha.fichaSinColor();
		assertEquals(ficha.getColor(), '-');
		assertNotSame(ficha.getColor(),'R');
	}
	/**
	 * Comprueba que se comparen correctamente 2 fichas
	 * @throws MastermindException
	 */
	@Test
	public void testEsIgual() throws MastermindException{
		Ficha otraFicha=new Ficha('R');
		assertTrue(ficha.esIgual(otraFicha));
	}
	/**
	 * Comprueba que se pasa de numero a color correctamente
	 * @throws MastermindException
	 */
	@Test
	public void testNumeroAColor() throws MastermindException{
		Ficha ficha;
		ficha= new Ficha('-');
		ficha.numeroAColor(0);
		assertEquals(ficha.getColor(),'R');
		ficha.numeroAColor(1);
		assertEquals(ficha.getColor(),'G');
		ficha.numeroAColor(2);
		assertEquals(ficha.getColor(),'B');
		ficha.numeroAColor(3);
		assertEquals(ficha.getColor(),'Y');
		ficha.numeroAColor(4);
		assertEquals(ficha.getColor(),'P');
		ficha.numeroAColor(5);
		assertEquals(ficha.getColor(),'C');
	}
	

	

	
}
