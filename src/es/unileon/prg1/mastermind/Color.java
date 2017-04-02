package es.unileon.prg1.mastermind;

public class Color {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	private Colors color;

	@Override
	public String toString(){
		String result = null;

		switch (this.color){
		case BLACK:
			result = ANSI_BLACK+"[O]"+ANSI_RESET;
			break;
		case RED:
			result = ANSI_RED+"[R]"+ANSI_RESET;
			break;
		case GREEN:
			result = ANSI_GREEN+"[G]"+ANSI_RESET;
			break;
		case YELLOW: 
			result = ANSI_YELLOW+"[Y]"+ANSI_RESET;
			break;
		case BLUE:
			result = ANSI_BLUE+"[B]"+ANSI_RESET;
			break;
		case PURPLE:
			result = ANSI_PURPLE+"[P]"+ANSI_RESET;
			break;
		case CYAN:
			result = ANSI_CYAN+"[C]"+ANSI_RESET;
			break;
		case WHITE: 
			result = ANSI_WHITE+"[X]"+ANSI_RESET;
			break;
		case NONE:
			result = " - ";
			break;
		}
		return result;
	}

}
