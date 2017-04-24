package es.unileon.prg1.mastermind;
/**
 * 
 * 
 *
 */
public class Tablero {

private int siguiente;
private Combinacion[] matrizCombinAciertos;
private Combinacion[] matrizIntentos;
/**
 * Constructor de la clase tablero
 * @param length
 * 		numero de columnas del tablero
 * @param nIntentos
 * 		filas del tablero
 * @throws MastermindException
 */
	public Tablero (int length, int nIntentos) throws MastermindException{
		this.matrizCombinAciertos = new Combinacion[nIntentos];
		this.matrizIntentos = new Combinacion[nIntentos];
		iniciaTablero(length);
		siguiente=nIntentos-1;
	}
/**
 * Inicializa un tablero con guiones
 * @param length
 * 		numero de columnas del tablero
 * @throws MastermindException
 */
	public void iniciaTablero(int length) throws MastermindException{
		StringBuffer guiones=new StringBuffer();
		for(int i=0;i<this.matrizCombinAciertos.length;i++){
			for (int j=0; j<length; j++){
				guiones.append("-");	
			}
			matrizCombinAciertos[i]=new Combinacion(guiones.toString(),length);
			matrizIntentos[i]=new Combinacion(guiones.toString(),length);
			guiones.delete(0,guiones.length());
		}
	}

	
	/**
	 * Anyade al tablero una combinacion y su correspondiente acierto respecto a la secreta
	 * @param combinacionIntroducida
	 * 			combinacion introudcida por el usuario
	 * @param combinacionAciertos
	 * 			combinacion reusltnate de comparar con la secreta la del usuario
	 */
	public void incluyeLinea(Combinacion combinacionIntroducida, Combinacion combinacionAciertos){
		this.matrizCombinAciertos[siguiente]=combinacionAciertos;
		this.matrizIntentos[siguiente--]=combinacionIntroducida;
	}
	/**
	 * Devuelve el numero de intentos totales
	 * @return numero de filas del tablero
	 */
	public int getNumeroIntentos(){
	
		return this.matrizCombinAciertos.length;
	}
	/**
	 * Devuelve la ultima combinacion de aciertos
	 * @return la ultima combinaicon de aciertos
	 */
	public Combinacion getUltimoAcierto(){
		return this.matrizCombinAciertos[siguiente+1];
	}
	/**
	 * transforma el tablero a String
	 */
	public String toString(){
		String stringImprimir = "";
		for(int i = 0; i < matrizCombinAciertos.length; i++){
			stringImprimir += matrizIntentos[i].toString();
			stringImprimir += "\t";
			stringImprimir += matrizCombinAciertos[i].toString();
			stringImprimir += "\n";
		}
		return stringImprimir;
		
	}

}

