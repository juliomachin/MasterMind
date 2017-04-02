package es.unileon.prg1.mastermind;
import static org.junit.Assert.*;
/**
 *  @author Alejandro Moya Garcia, Pablo Gonzalez de la Iglesia, Juan Carlos
 *         Gutierrez Vicente, Ignacio Rodriguez Basante
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class MastermindTest {
	Mastermind mastermind;
	Combinacion correcta;
	Combinacion incorrecta;
	Combinacion incorrecta2;
	
	@Before
	public void setUp() throws Exception{
		mastermind = new Mastermind();
		correcta = new Combinacion("RGBY",4);
		incorrecta = new Combinacion ("RGBB",4);
		incorrecta2 = new Combinacion ("GBBB",4);
	}
	/*
	 * Comprueba que se construye la clase correctamente cuando le pasamos los parámetros
	 * apropiados.
	 */
	@Test
	public void testConstructor() throws MastermindException{
		Mastermind constructor = new Mastermind(4,4,false);
		assertEquals(constructor.getLongitudCombSecreta(),4);
	}
	/*
	 * Comprueba si has terminado de jugar teniendo en cuenta el numero de intentos
	 * utilizados y si has acertado la combinacion
	 * @throws MastermindException
	 */
	@Test
	public void testHasTerminado() throws MastermindException{
		
		mastermind.compararCombinaciones(correcta);
		assertEquals(mastermind.hasTerminado(3),true);
		
		mastermind.compararCombinaciones(incorrecta);
		assertEquals(mastermind.hasTerminado(3),false);
		
		mastermind.compararCombinaciones(incorrecta);
		assertEquals(mastermind.hasTerminado(5),true);
		
		
		
	}
	/*
	 * Comprueba si se imprime correctamente la partida
	 */
	@Test
	public void testToString() throws MastermindException{
		assertEquals(mastermind.toString(),"[R][G][B][Y]\n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \nIntroducir una combinación de 4 colores\nR/G/Y/B/P/C/salir");
		
		mastermind.compararCombinaciones(incorrecta);
		assertEquals(mastermind.toString(),"[R][G][B][Y]\n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n[R][G][B][B]\t[O][O][O] - \nIntroducir una combinación de 4 colores\nR/G/Y/B/P/C/salir");
		
		mastermind.compararCombinaciones(incorrecta2);
		assertEquals(mastermind.toString(),"[R][G][B][Y]\n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n[G][B][B][B]\t[O][X] -  - \n[R][G][B][B]\t[O][O][O] - \nIntroducir una combinación de 4 colores\nR/G/Y/B/P/C/salir");

		mastermind.compararCombinaciones(correcta);
		assertEquals(mastermind.toString(),"[R][G][B][Y]\n -  -  -  - \t -  -  -  - \n[R][G][B][Y]\t[O][O][O][O]\n[G][B][B][B]\t[O][X] -  - \n[R][G][B][B]\t[O][O][O] - \nIntroducir una combinación de 4 colores\nR/G/Y/B/P/C/salir");
	}
	/*
	 * Comprueba si has acertado la combinacion
	 * @throws MastermindException
	 */
	@Test
	public void testHasGanado() throws MastermindException{
		mastermind.compararCombinaciones(correcta);
		assertEquals(mastermind.hasGanado(3),"¡Has ganado!");
		
		mastermind.compararCombinaciones(incorrecta);
		assertEquals(mastermind.hasGanado(5),"Has perdido...\n La combinacion secreta era[R][G][B][Y]");
		
		mastermind.compararCombinaciones(incorrecta);
		assertEquals(mastermind.hasGanado(3),"Has perdido...\n La combinacion secreta era[R][G][B][Y]");
	}
	/*
	 *Comprueba si has introducido una longitud Negativa en el juego
	 * @throws MastermindException
	 */
	@Test(expected=MastermindException.class)
	public void testConstructorLongitudNegativa() throws Exception{
		Mastermind mastermind = new Mastermind(-4,5,true);
	}
	/*
	 * Comprueba si has introducido un numero de intentos negativo en el juego
	 * @throws MastermindException
	 */
	@Test(expected=MastermindException.class)
	public void testConstructorIntentosNegativos() throws MastermindException{
		Mastermind mastermind = new Mastermind(4,-5,true);
	}
	/*
	 * Comprueba si has introducido una longitud negativa y un numero de intentos negativo 
	 * en el juego
	 * @throws MastermindException
	 */
	@Test(expected=MastermindException.class)
	public void testConstructorNegativo() throws MastermindException{
		Mastermind mastermind = new Mastermind(-4,-5,false);
	}
	/*
	 * Comprueba si la longitud de la combinacion sin repeticion es mayor
	 * que el numero de colores disponibles
	 * @throws MastermindException
	 */
	@Test(expected=MastermindException.class)
	public void testConstructorSinRepeticion() throws Exception{
		Mastermind mastermind = new Mastermind(7,5,false);
	}
	
}
