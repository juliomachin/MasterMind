package es.unileon.prg1.mastermind;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * 
 * 
 *
 */
public class MastermindMain {
	private static final Logger logger = LogManager.getLogger(MastermindMain.class);
	public static void main(String[] args) throws MastermindException {
		int longitud=0, numeroIntentos=0;
		boolean repeticion;
		logger.info("Numero de argumentos introducidos: "+args.length);
		logger.info("Longitud de la combinacion introducida: "+args[0]);
		logger.info("Numero de intentos introducidos: "+ args[1]);
		logger.info("Repeticion: "+ args[2]);
		StringBuffer error=new StringBuffer();
		if (args.length > 3) {
			error.append("Numero incorrecto de argumentos: "+args.length+" . Debe introducir 3\n");
		} 
		try{
			try {
				
				longitud = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				error.append("Valor erróneo:" + args[0] + ".Introduzca un número entero mayor que cero.");
			}

			try {
				numeroIntentos = Integer.parseInt(args[1]);
			} catch (NumberFormatException e2) {
				error.append("Valor erróneo:" + args[1] + ".Introduzca un número entero mayor que cero.");
			}
			repeticion = Boolean.parseBoolean(args[2]);
			if (!args[2].equals("true" )&& !args[2].equals("false")) {
				error.append("Valor erróneo:" + args[2] + ". Introduzca 'true' o 'false'\n");
			}

			try {
				Mastermind mastermind = new Mastermind(longitud, numeroIntentos, repeticion);
				Interfaz interfaz = new Interfaz(mastermind);
				interfaz.iniciarJuego();
			} catch (MastermindException mastermindException) {
				error.append(mastermindException.getMessage());
			}
			
		}catch(ArrayIndexOutOfBoundsException e3){
			error.append("Numero de argumentos incorrecto:"+args.length+". Debe introducir 3\n");
		}
		if(error.length()!=0){
				System.out.println(error.toString());
				
			}
	}
}

 
