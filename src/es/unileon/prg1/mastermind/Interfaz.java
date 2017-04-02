package es.unileon.prg1.mastermind;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * 
 *  @author Alejandro Moya Garcia, Pablo Gonzalez de la Iglesia, Juan Carlos
 *         Gutierrez Vicente, Ignacio Rodriguez Basante
 */
public class Interfaz {
	private static final Logger logger = LogManager.getLogger(Interfaz.class);
	private Mastermind mastermind;
/** 
 * Constructor de la clase Interfaz
 * @param mastermind
 * 		
 * 
 */
	public Interfaz(Mastermind mastermind){
		this.mastermind=mastermind;
	}
	
	/**
	 * Comienza una partida
	 * @throws MastermindException 
	 */
	public void iniciarJuego() throws MastermindException{
		logger.info("Iniciando juego");
		int intentos=1;
		String linea = new String();
		boolean combinacionCorrecta;
		System.out.println(mastermind);
		do{
			
			linea=Teclado.leerLinea();
			logger.info("Linea introducida por el usuario: "+linea);
			salir(linea);
			
			do{
				combinacionCorrecta=true;
				try{
					Combinacion combinacionIntroducida=new Combinacion(linea,mastermind.getLongitudCombSecreta());
					logger.info("Combinacion introducida por el usuario: "+combinacionIntroducida.toString());
					mastermind.compararCombinaciones(combinacionIntroducida);
				}catch(MastermindException exception){
					System.out.println(exception.getMessage());
					linea=Teclado.leerLinea();
					logger.info("Nueva linea introducida por el usuario tras el error: "+linea);
					salir(linea);
					combinacionCorrecta=false;	
				}catch(ArrayIndexOutOfBoundsException exception2){
					combinacionCorrecta=false;
				}
			}while(!combinacionCorrecta&&!salir(linea));
			
			System.out.println(mastermind);
			logger.info("Intento numero:"+intentos+" finalizado");
		}while(!mastermind.hasTerminado(++intentos));	
		System.out.println(mastermind.hasGanado(intentos));
		logger.info("Mensaje final: "+mastermind.hasGanado(intentos));
	}

	
	/**
	 * Comprueba si el usuario ha decidido salir del programa. Si ha introducido salir (no case sensitive) se sale del programa
	 * @param linea
	 * 			linea introducida por el usuario
	 * @return
	 * 			Si la linea es "salir" o no
	 */
	public boolean salir(String linea){
		boolean correcto=false;
		if (linea.equalsIgnoreCase("salir")){
			logger.info("El usuario decide salir");
			logger.info("Se acaba el pograma");
			System.out.println("Hasta la proxima!");
			System.exit(0);
			correcto=true;
		}
		return correcto;
	}
	
	
	
}