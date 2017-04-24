package es.unileon.prg1.mastermind;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
/**
 *
 * 
 *
 */
public class TableroTest {
Tablero tablero;
Combinacion introducida;
Combinacion secreta;

	@Before
	public void setUp() throws Exception{
		tablero = new Tablero(4,5);
		introducida = new Combinacion("GGGG",4);
		secreta = new Combinacion("GYGG",4);
	}
/**
 * Comprueba que el tablero se inicializa correctamente
 */
	@Test
	public void testIniciaTablero(){
		assertEquals(tablero.toString()," -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n");
	}
	/**
	 * Comprueba que las lienas se anyaden correctamente al tablero
	 * @throws MastermindException
	 */
	@Test
	public void testIncluyeLinea() throws MastermindException{
		
		Combinacion copiaSecreta=new Combinacion(secreta);
		Combinacion copiaIntroducida=new Combinacion(introducida);
		tablero.incluyeLinea(introducida,copiaSecreta.compararAciertos(copiaIntroducida));
		assertEquals(tablero.toString()," -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n -  -  -  - \t -  -  -  - \n[G][G][G][G]\t[O][O][O] - \n");
	}
	/*
	 * Comprueba que se devuelve correctamente el numero de intentos
	 */
	@Test
	public void testGetNumeroIntentos(){
		assertEquals(tablero.getNumeroIntentos(),5);
	}
	/**
	 * Comprueba que se devuelve correctamente la ultima combinacion de aciertos
	 * @throws MastermindException
	 */
	@Test
	public void testGetUltimoAcierto() throws MastermindException{
		Combinacion copiaSecreta=new Combinacion(secreta);
		Combinacion copiaIntroducida=new Combinacion(introducida);
		
		tablero.incluyeLinea(introducida, copiaSecreta.compararAciertos(copiaIntroducida));
		assertEquals(tablero.getUltimoAcierto().toString(),(secreta.compararAciertos(introducida)).toString());
	}
}
