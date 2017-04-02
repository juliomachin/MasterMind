package es.unileon.prg1.mastermind;

import java.util.Random;

/**
 * 
 * @author Alejandro Moya Garcia, Pablo Gonzalez de la Iglesia, Juan Carlos
 *         Gutierrez Vicente, Ignacio Rodriguez Basante
 *
 */
public class Combinacion {


	private Ficha[] fichas;

	final int NUM_COLORES = 6;

	/**
	 * Constructor de la clase Combinacion.Genera una combinacion aleatoria con o sin repeticion de colores. 
	 * 
	 * @param repeticion
	 * 			Si hay repeticion o no
	 * @param longitud
	 *            Longitud de la combinacion
	 */

	public Combinacion(boolean repeticion, int length) throws MastermindException {
		int[] auxiliar = { 0, 1, 2, 3, 4, 5 };
		int random = 0, numeroColores = NUM_COLORES;
		Random numeroaleatorio = new Random();
		numeroaleatorio.setSeed(System.nanoTime());

		
		
		this.fichas = new Ficha[length];

		if (!repeticion) {
			
			for (int i = 0; i < length; i++) {
				random = auxiliar[numeroaleatorio.nextInt(numeroColores)];
				fichas[i] = new Ficha('-');
				fichas[i].numeroAColor(auxiliar[random]);
				auxiliar[random] = auxiliar[numeroColores - 1];
				numeroColores--;
			}

		} else {

			for (int i = 0; i < length; i++) {
				random = numeroaleatorio.nextInt(NUM_COLORES);
				fichas[i] = new Ficha('-');
				fichas[i].numeroAColor(random);
			}
		}
	}

	/**
	 * Constructor copia de la clase Combinacion. Crea una combinacion igual que
	 * la que recibe como parametro
	 * 
	 * @param otraCombinacion
	 *            Combinacion a copiar
	 * @throws MastermindException 
	 * 
	 * 
	 */
	public Combinacion(Combinacion otraCombinacion) throws MastermindException {
		this.fichas = new Ficha[otraCombinacion.getLongitud()];
		for (int i = 0; i < otraCombinacion.getLongitud(); i++) {
			fichas[i] = new Ficha('-');
			fichas[i].setColor(otraCombinacion.getColorAt(i));
		}
	}

	/**
	 * Transforma a combinacion un String introducido por el usuario. Si la longitud de la combinación introducida es distinta a la de la aleatoria lanza una excepcion
	 * 
	 * @param combinacion
	 *            linea introducida por el usuario
	 * @param longitud
	 * 				Longitud de la combinacion aleatoria generada
	 * @throws MastermindException 
	 * 
	 */
	public Combinacion(String combinacion, int longitud) throws  MastermindException{
		StringBuffer error=new StringBuffer();
		if(combinacion.length()!=longitud){
			error.append("Longitud erronea: "+combinacion.length()+" , debe introducir una combinacion de "+longitud+" caracteres.");
		}
			this.fichas = new Ficha[longitud];
			for (int i = 0; i < combinacion.length(); i++) {
				
				
				try{
				this.fichas[i] = new Ficha(combinacion.charAt(i));
				}catch(MastermindException exception){
					error.append(exception.getMessage());
				}catch(ArrayIndexOutOfBoundsException exception2){
					
				}

			}
			if(error.length()!=0){
				throw new MastermindException(error.toString());
			}
		
	}

	/**
	 * Metodo que devuelve la longitud (número de fichas) de una combinacion
	 * 
	 * @return longitud de la combinación 
	 */
	public int getLongitud() {
		return this.fichas.length;
	}



	/**
	 * Obtiene el color de una de las fichas de la combinacion
	 * 
	 * @param posicion
	 *           posicion que ocupa la ficha en la combinacion
	 * @return color de la ficha
	 */
	public char getColorAt(int posicion) {
		return this.fichas[posicion].getColor();
	}

	/**
	 * Devuelve una ficha de la combinacion
	 * 
	 * @param posicion
	 *       posicion de la ficha en la combinacion
	 * @return Ficha de la posición dada
	 *        
	 * @throws MastermindException 
	 */
	public Ficha getFicha(int posicion){
		return this.fichas[posicion];
	}

	/**
	 * Compara la combinacion introducida por el usuario con la combinacion
	 * aleatoria generada por el juego. Compara ficha a ficha, si coinciden
	 * color y posicion escribe una 'O' en la combinacion de aciertos. Si es
	 * solo posicion una 'X'. Si no se escribe -.
	 * 
	 * @param combinacionIntroducida
	 *            Combinacion introducida por el usuario
	 * @return Una combinacion con los aciertos producidos
	 * @throws MastermindException 
	 *
	 * 
	 */

	public Combinacion compararAciertos(Combinacion combinacionIntroducida) throws MastermindException   {
		int siguiente = 0, i = 0, j = 0;
		Combinacion combinacionAciertos = new Combinacion(false, combinacionIntroducida.getLongitud());
		while (i < this.getLongitud() && siguiente < this.getLongitud()) {
				if (combinacionIntroducida.getFicha(i).esIgual(this.fichas[i])) {
					combinacionAciertos.getFicha(siguiente++).setColor('O');
					this.fichas[i].fichaSinColor();
					combinacionIntroducida.getFicha(i).setColor('O');
			}
			
			i++;
		}
		i = 0;
		while (i < this.getLongitud() && siguiente < this.getLongitud()) {
			while (j < this.getLongitud() && siguiente < this.getLongitud()) {
				if (combinacionIntroducida.getFicha(i).esIgual(this.fichas[j])&&i!=j) {
					combinacionAciertos.getFicha(siguiente++).setColor('X');
					this.fichas[j].fichaSinColor();
					
					j=this.getLongitud();//para salir del bucle "j"
				}
				j++;
			}
			i++;
			j = 0;
		}
		while (siguiente < this.getLongitud()) {
			combinacionAciertos.getFicha(siguiente++).setColor('-');

		}

		return combinacionAciertos;
	}

	/**
	 * Pasa una combinacion a String
	 * @return la combinacion en tipo String
	 */
	public String toString(){
		StringBuffer salida= new StringBuffer();
		for(int i=0;i<this.getLongitud();i++){
			salida.append(this.fichas[i].toString());
		}
		return salida.toString();
	}

}
