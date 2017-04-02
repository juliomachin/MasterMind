package es.unileon.prg1.mastermind;
import org.apache.logging.log4j.Logger;
/**
 *  @author Alejandro Moya Garcia, Pablo Gonzalez de la Iglesia, Juan Carlos
 *         Gutierrez Vicente, Ignacio Rodriguez Basante
 */
import org.apache.logging.log4j.LogManager;
public class Mastermind{
	private static final Logger logger = LogManager.getLogger(Mastermind.class);
	

	private Tablero tablero;
	private Combinacion combinacionSecreta;

	final int NUM_COLORES = 6;
	/**
	 * Constructor de la clase Mastermind
	 * @param length
	 * 			longitud que tendrá la combinacion secreta
	 * @param numeroIntentos
	 * 			numero intentos de los que dispondrá el usuario
	 * @param repeticion
	 * 			si la combinacion aleatoria tendra repeticion o no
	 * @throws MastermindException
	 */
	public Mastermind(int length, int numeroIntentos, boolean repeticion)throws MastermindException{
		StringBuffer msg = new StringBuffer();
			if(length<=0){
				msg.append("Error, longitud incorrecta:"+length+". La longitud debe ser un numero mayor que cero\n");
			}
			if(numeroIntentos<=0){
				msg.append("\nError, numero de intentos incorrecto:"+numeroIntentos+". El numero de intentos debe ser mayor que cero\n");
			}
			if((length>NUM_COLORES)&&(repeticion==false)){
				msg.append("Error, si no hay colores repetidos no puede haber mas posiciones que colores\n");
			}
			
		if(msg.length()!=0){
			throw new MastermindException(msg.toString());
		}else{
				this.tablero = new Tablero(length,numeroIntentos);
				this.combinacionSecreta = new Combinacion(repeticion,length);
				logger.info("Combinacion aleatoria generada: "+this.combinacionSecreta.toString());
				
			}
		}
		/**
		 * Ayuda para los test
		 * @throws MastermindException
		 */
	public Mastermind() throws MastermindException{
		this.tablero = new Tablero(4,4);
		this.combinacionSecreta = new Combinacion("RGBY",4);
	}
/**
 * Devuelve la longitud de la combinacion secreta
 * @return
 */
	public int getLongitudCombSecreta(){
		return this.combinacionSecreta.getLongitud();
	}
	/**
	 * @param combinacionIntroducida
	 * 			combinacion introducida por el usuario
	 * 
	 * Compara dos combinaciones y las añade al tablero
	 * @throws MastermindException 
	 */
	public void compararCombinaciones(Combinacion combinacionIntroducida) throws MastermindException{
		Combinacion combinacionIntroducidaCopia=new Combinacion(combinacionIntroducida);
		Combinacion combinacionCopia=new Combinacion(this.combinacionSecreta);
		Combinacion combinacionAciertos=combinacionCopia.compararAciertos(combinacionIntroducidaCopia);
		logger.info("Resultado de comparar las combinaciones: "+ combinacionAciertos.toString()); 
		this.tablero.incluyeLinea(combinacionIntroducida,combinacionAciertos);
	}
	

	
	
	/**
	 *Dice si el usuario ha terminado, bien haya ganado o perdido
	 * @param intentosActuales
	 * 			intentos hasta el momento
	 *
	 * @throws MastermindException 
	 */
	 public boolean hasTerminado(int intentosActuales) throws MastermindException{
		boolean terminado = false;
		
		
		if((intentosActuales > this.tablero.getNumeroIntentos()) || this.hasGanado(intentosActuales)=="¡Has ganado!"){
			logger.info("Se ha acabado la partida");
			terminado = true;

			
		}
		
		return terminado;
	 }
	 
	 
	 /**
		 *Dice si el usuario ha ganado o perdido
		 * @param intentos
		 * 			intentos hasta el momento
		 * 
		 * 
		 * @throws MastermindException 
		 */
	 public String hasGanado(int intentos) throws MastermindException{
		Ficha acierto=new Ficha('O');
		 boolean ganado=true;
		 String mensajeFinal;
		for(int i=0;i<this.combinacionSecreta.getLongitud();i++){
			if(!tablero.getUltimoAcierto().getFicha(i).esIgual(acierto)){
				ganado =false;
			}
		}
		 if(!ganado){
			 mensajeFinal="Has perdido...\n La combinacion secreta era"+this.combinacionSecreta.toString();
		}else{
			mensajeFinal="¡Has ganado!";
		}
		return mensajeFinal; 
	 }
	 
	 
	 /**
	 * Devuelve un String con toda la informacion referente al Mastermind.
	 */
	public String toString(){
			StringBuffer msg = new StringBuffer();
			msg.append(this.combinacionSecreta+"\n");
				//Descomentar la linea superior para ver la combinacion secreta por pantalla.
			msg.append(tablero);
			msg.append("Introducir una combinación de "+this.combinacionSecreta.getLongitud()+" colores");
			msg.append("\nR/G/Y/B/P/C/salir");
			return msg.toString();
	}
}


