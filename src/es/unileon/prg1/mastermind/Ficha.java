package es.unileon.prg1.mastermind;
/**
 * 
 * @author Alejandro Moya Garcia, Pablo Gonzalez de la Iglesia, Juan Carlos
 *         Gutierrez Vicente, Ignacio Rodriguez Basante
 */
public class Ficha {
	
	private char color;
	/**
	 * Constructor de la clase Ficha.
	 * @param color
	 * 			color de la Ficha
	 */
	public Ficha(char color)throws MastermindException{
		StringBuffer error=new StringBuffer();
		if(!fichaPermitida(color)){
			error.append("\nError. "+ color+" no es un color permitido");
		}
		if(error.length()!=0){
			throw new MastermindException(error.toString());
		}else{
			this.color = color;
		}
		
	}	
	/**
	 * 
	 * @param otraFicha
	 * 			Ficha a comparar
	 * @return si son del mismo color o no
	 */
	public boolean esIgual(Ficha otraFicha){
		return this.getColor()==otraFicha.getColor();
	}
	
 /**
  * Metodo para obtener el color de una ficha
  * @return color de la ficha
  */
	public char getColor() {
		return this.color;
	}
/**
 * Metodo para cambiar el color de una ficha.
 * @param color
 * 			color a cambiar
 */
	public void setColor(char color)throws MastermindException {
		
		StringBuffer error=new StringBuffer();
		if(!fichaPermitida(color)){
			error.append("\nError."+ color+" no es un color permitido");
		}
		if(error.length()!=0){
			throw new MastermindException(error.toString());
		}else{
			this.color = color;
		}
	}
	
/**
 * Metodo que elimina el color de una ficha.
 * @throws MastermindException 
 */
	public void fichaSinColor() throws MastermindException{
		this.setColor('-');
	}

/**
 * Metodo que asigna un color aleatorio a la ficha.
 * @param aleatorio
 * 			numero asociado a un color
 * @throws MastermindException 
 */
	public void numeroAColor(int aleatorio) throws MastermindException{
		switch(aleatorio){
		case 0:
			this.setColor('R');
			break;
		case 1:
			this.setColor('G');
			break;
		case 2:
			this.setColor('B');
			break;
		case 3:
			this.setColor('Y');
			break;
		case 4:
			this.setColor('P');
			break;
		case 5:
			this.setColor('C');
			break;
		}
		
	}
	/**
	 * Comprueba si un color está permitido o no
	 * @param color
	 * 			un color
	 * @return
	 * 		Si el color está permitido o no
	 */
	public boolean fichaPermitida(char color){
		char[] coloresDisponibles = {'R', 'G', 'B', 'Y', 'P', 'C' ,'-','O','X','_'};
		boolean permitida=false;
		for(int i=0;i<coloresDisponibles.length;i++){
			if(color==coloresDisponibles[i]){
				permitida=true;
			}
		}
		return permitida;
	}
	/**
	 * Pasa a String una ficha
	 */
	public String toString(){
		String salida;
		if(this.color=='-'){
			salida=" - ";
		}else{
		salida= "["+this.color+"]";
		}
	return salida;
	}
	
}
