package es.unileon.prg1.mastermind;
/*
 *  @author Alejandro Moya Garcia, Pablo Gonzalez de la Iglesia, Juan Carlos
 *         Gutierrez Vicente, Ignacio Rodriguez Basante
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Teclado{
    
    /**
     * Lee una linea por consola.
     *
     *
     * @return String Una linea con el comando.
     */
    public static String leerLinea() {
        String linea="";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            linea = br.readLine().toUpperCase();
        }
        catch(Exception e){
            e.printStackTrace();
        } 
        
        return linea;
    }
    
}
