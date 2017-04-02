package es.unileon.prg1.mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

/**
 * 
 *  @author Alejandro Moya Garcia, Pablo Gonzalez de la Iglesia, Juan Carlos
 *         Gutierrez Vicente, Ignacio Rodriguez Basante
 */
public class CombinacionTest {
	Combinacion combinacion;
	Combinacion combinacionDe5;
	Combinacion combinacionDe3;
	Combinacion combinacionIntroducida;

	@Before
	public void setUp() throws MastermindException  {

		combinacion = new Combinacion(true, 4);
		combinacionDe5 = new Combinacion("BGYBG",5);
		combinacionDe3 = new Combinacion("BRY",3);
		combinacionIntroducida = new Combinacion("RGYB",4);

	}

	/**
	 * Comprueba que se construye correctamente una combinacion que recibe un
	 * String de parámetro
	 */
	@Test
	public void testConstructorCombinacionIntroducida() {
		assertEquals(combinacionIntroducida.getFicha(0).getColor(), 'R');
		assertEquals(combinacionIntroducida.getFicha(1).getColor(), 'G');
		assertEquals(combinacionIntroducida.getFicha(2).getColor(), 'Y');
		assertEquals(combinacionIntroducida.getFicha(3).getColor(), 'B');

	}
/**
 * Comprueba que se genera excepcion al introducir una combinacion de menor longitud de la permitida
 * @throws MastermindException
 */
	@Test(expected=MastermindException.class)
	public void testCombinacionValida1() throws   MastermindException {
		Combinacion combinacionAComprobar = new Combinacion("RGYB",5);
		
	}
	/**
	 * Comprueba que una combinacion con colores no permitidos y de la misma
	 * longitud que la secreta no sea valida
	 * @throws  
	 * @throws FichaException
	 * 			
	 * @throws MastermindException 
	 */
	@Test(expected=MastermindException.class)
	public void testCombinacionValida2() throws   MastermindException {
		Combinacion combinacionAComprobar = new Combinacion("HOLA",4);
		
	}
	@Test
	/**
	 *
	 * Comprueba que devuelve correctamente la longitud de la combinacion
	 */
	public void testGetLongitud() {

		assertEquals(combinacion.getLongitud(), 4);
		assertNotSame(combinacion.getLongitud(), 5);
	}

	@Test
	/**
	 * Comprueba el correcto funcionamiento del constructor copia. Al modificar
	 * los colores de las fichas se modifican solo en el objeto combinacion
	 * copiado y no en el original.
	 */
	public void testConstructorCopia() throws  MastermindException {

		Combinacion copiaCombinacion = new Combinacion(combinacionIntroducida);
		assertNotSame(combinacionIntroducida, copiaCombinacion);
		copiaCombinacion.getFicha(1).setColor('C');
		assertNotSame(copiaCombinacion.getFicha(1), combinacionIntroducida.getFicha(1));

	}

	
	

	/**
	 * Comprueba que se devuleve correctamente el color de una ficha de la
	 * combinacion
	 * 
	 * @throws MastermindException 
	 */
	@Test
	public void testGetColorAt() throws  MastermindException {
		Combinacion combinacion = new Combinacion("RBYP",4);
		assertEquals(combinacion.getFicha(1).getColor(), 'B');
	}

	/**
	 * Comprueba que se cambia correctamente el color de una ficha de la
	 * combinacion
	 * 
	 * @throws MastermindException 
	 */
	@Test
	public void testSetColorAt() throws  MastermindException {
		Combinacion combinacion = new Combinacion("RGYP",4);
		combinacion.getFicha(2).setColor('B');
		assertNotSame(combinacion.getFicha(2).getColor(), 'Y');
		assertEquals(combinacion.getFicha(2).getColor(), 'B');

	}

	@Test
	/**
	 * Comprueba que dos combinaciones sin repeticion iguales devuelven su
	 * correspondiente resultado
	 */
	public void testComprobarAciertosSinRepeticion1() throws MastermindException {

		Combinacion combinacionEsperada = new Combinacion("OOOO",4);
		for (int i = 0; i < combinacionIntroducida.getLongitud(); i++) {
			assertEquals(combinacionIntroducida.compararAciertos(combinacionIntroducida).getFicha(i).getColor(),
					combinacionEsperada.getFicha(i).getColor());
		}
	}

	/**
	 * Comprueba que dos combinaciones sin repeticion con una ficha de color y
	 * posicion iguales y otra ficha que solo coincide en color, devuelven su
	 * correspondiente resultado.
	 * @throws  MastermindException
	 * 
	 */
	@Test
	public void testComprobarAciertosSinRepeticion2() throws  MastermindException {

		Combinacion combinacionEsperada = new Combinacion("OX--",4);
		Combinacion combinacionDiferente = new Combinacion("PCRB",4);
		for (int i = 0; i < combinacionIntroducida.getLongitud(); i++) {
			Combinacion combinacionCopiada = new Combinacion(combinacionIntroducida);
			Combinacion combinacionDiferenteCopiada=new Combinacion(combinacionDiferente);
			assertEquals(combinacionCopiada.compararAciertos(combinacionDiferenteCopiada).getFicha(i).getColor(),
					combinacionEsperada.getFicha(i).getColor());
		}
	}

	/**
	 * Comprueba que dos combinaciones sin repeticion con fichas de igual color
	 * en ambas combinaciones pero distintas posiciones devuelven su
	 * correspondiente resultado
	 * 
	 * @throws MastermindException 
	 */
	@Test
	public void testComprobarAciertosSinRepeticion3() throws  MastermindException{

		Combinacion combinacionDiferente = new Combinacion("BRGY",4);
		Combinacion combinacionEsperada = new Combinacion("XXXX",4);
		for (int i = 0; i < combinacionIntroducida.getLongitud(); i++) {
			Combinacion combinacionCopiada = new Combinacion(combinacionIntroducida);
			assertEquals(combinacionCopiada.compararAciertos(combinacionDiferente).getFicha(i).getColor(),
					combinacionEsperada.getFicha(i).getColor());
		}

	}

	/**
	 * Comprueba que dos combinaciones sin repeticion con ninguna ficha en comun
	 * devuelven su correspondiente resultado
	 * @throws  MastermindException
	 * 
	 */
	@Test
	public void testComprobarAciertosSinRepeticion4() throws  MastermindException{

		Combinacion combinacionEsperada = new Combinacion("---",3);
		Combinacion combinacionDiferente = new Combinacion("GCP",3);
		for (int i = 0; i < combinacionDe3.getLongitud(); i++) {
			Combinacion combinacionCopiada = new Combinacion(combinacionDe3);
			assertEquals(combinacionCopiada.compararAciertos(combinacionDiferente).getFicha(i).getColor(),
					combinacionEsperada.getFicha(i).getColor());
		}

	}

	/**
	 * Comprueba que al comparar dos combinaciones con repeticion iguales con el
	 * mismo color repetido 5 veces se devuelve su correspondiente resultado
	 * 
	 * @throws MastermindException 
	 */
	@Test
	public void testComprobarAciertosConRepeticion1() throws  MastermindException {
		Combinacion combinacionRs = new Combinacion("RRRRR",5);
		Combinacion combinacionEsperada = new Combinacion("OOOOO",5);
		for (int i = 0; i < combinacionRs.getLongitud(); i++) {
			Combinacion combinacionCopiada = new Combinacion(combinacionRs);
			assertEquals(combinacionCopiada.compararAciertos(combinacionRs).getFicha(i).getColor(),
					combinacionEsperada.getFicha(i).getColor());
		}
	}

	/**
	 * Compara dos combinaciones con los mismos colores. Cada color ocupa un
	 * lugar distinto en cada combinación. Comprueba que se devuelva el
	 * resultado correspondiente.
	 * 
	 * @throws MastermindException 
	 */
	@Test
	public void testComprobarAciertosConRepeticion2() throws  MastermindException{
		Combinacion combinacionDe5Diferente = new Combinacion("GBBGY",5);
		Combinacion combinacionEsperada = new Combinacion("XXXXX",5);
		for (int i = 0; i < combinacionDe5.getLongitud(); i++) {
			Combinacion combinacionCopiada = new Combinacion(combinacionDe5);
			assertEquals(combinacionCopiada.compararAciertos(combinacionDe5Diferente).getFicha(i).getColor(),
					combinacionEsperada.getFicha(i).getColor());
		}

	}

	/**
	 * Compara dos combinaciones con repeticion idénticas y comprueba que se
	 * devuelva el corrspondiente reusltado.
	 *   
	 * @throws MastermindException 
	 */
	@Test
	public void testComprobarAciertosConRepeticion3() throws  MastermindException{

		Combinacion combinacionEsperada = new Combinacion("OOOOO",5);
		for (int i = 0; i < combinacionDe5.getLongitud(); i++) {
			Combinacion combinacionCopiada = new Combinacion(combinacionDe5);
			assertEquals(combinacionCopiada.compararAciertos(combinacionDe5).getFicha(i).getColor(),
					combinacionEsperada.getFicha(i).getColor());
		}
	}

	/**
	 * Compara dos combinaciones con repeticion formadas por fichas de un único
	 * color pero distinto en cada combinacion. Comprueba que se devuelve el
	 * resultado adecuado.
	 *  
	 * @throws MastermindException 
	 */
	@Test
	public void testCompararAciertosConRepeticion4() throws  MastermindException{
		Combinacion combinacionRs = new Combinacion("RRRRR",5);
		Combinacion combinacionBs = new Combinacion("BBBBB",5);
		Combinacion combinacionEsperada = new Combinacion("-----",5);
		for (int i = 0; i < combinacionRs.getLongitud(); i++) {
			Combinacion combinacionCopiada = new Combinacion(combinacionRs);
			assertEquals(combinacionCopiada.compararAciertos(combinacionBs).getFicha(i).getColor(),
					combinacionEsperada.getFicha(i).getColor());
		}
	}

	/**
	 * Compara dos combinaciones con repeticion con distintos colores en cada
	 * una de ellas. Comprueba que se devuelve el resultado adecuado.
	 * 
	 * @throws MastermindException 
	 */
	@Test
	public void testCompararAciertosConRepeticion5() throws  MastermindException{
		Combinacion unaCombinacionDe5 = new Combinacion("RYBBY",5);
		Combinacion otraCombinacionDe5 = new Combinacion("PCPGC",5);
		Combinacion combinacionEsperada = new Combinacion("-----",5);
		for (int i = 0; i < unaCombinacionDe5.getLongitud(); i++) {
			Combinacion combinacionCopiada = new Combinacion(unaCombinacionDe5);
			assertEquals(combinacionCopiada.compararAciertos(otraCombinacionDe5).getFicha(i).getColor(),
					combinacionEsperada.getFicha(i).getColor());
		}
	}

	/**
	 * Compara dos combinaciones con repeticion. Una de ellas tiene el caracter
	 * repetido todas las veces. Comprueba que se devuelva el resultado
	 * adecuado.
	 *  
	 * @throws MastermindException 
	 */
	@Test
	public void testCompararAciertosConRepeticion6() throws  MastermindException{
		Combinacion unaCombinacion = new Combinacion("CCBC",4);
		Combinacion combinacionEsperada = new Combinacion("O---",4);
		Combinacion otraCombinacion = new Combinacion("BBBB",4);
		for (int i = 0; i < unaCombinacion.getLongitud(); i++) {
			Combinacion combinacionCopiada = new Combinacion(unaCombinacion);
			assertEquals(combinacionCopiada.compararAciertos(otraCombinacion).getFicha(i).getColor(),
					combinacionEsperada.getFicha(i).getColor());
		}
	}
	/**
	 * Comprueba que una combinacion con 2 fichas iguales devuelve el reusltado al compararla con otra que solo tiene una igual
	 * @throws MastermindException
	 */
	@Test
	public void testCompararAciertosConRepeticion7() throws MastermindException{
		Combinacion unaCombinacion=new Combinacion("RGG",3);
		Combinacion otraCombinacion=new Combinacion("RGB",3);
		
		Combinacion aciertos=new Combinacion("OO-",3);
		for (int i=0;i<unaCombinacion.getLongitud();i++){
			Combinacion copia=new Combinacion(unaCombinacion);
			Combinacion copiaIntroducida=new Combinacion(otraCombinacion);
			assertEquals(copia.compararAciertos(copiaIntroducida).getFicha(i).getColor(),aciertos.getFicha(i).getColor());
		}
	}
	@Test
	/**
	 * Comprueba el funcionamiento del toString
	 */
	public void testToString(){
		assertEquals(combinacionIntroducida.toString(),"[R][G][Y][B]");
	}
	
	
	


}
