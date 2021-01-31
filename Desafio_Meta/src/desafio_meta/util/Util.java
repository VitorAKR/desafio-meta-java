
package desafio_meta.util;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Vitor Reiter
 */
public class Util {
    //classe de apoio pra conversão de dados consumidos
    public static String convertJsonToString(BufferedReader bufferedReader) throws IOException{
        String answer, jsonToString = "";
        
        while((answer = bufferedReader.readLine()) != null){
            jsonToString += answer;
        }
        
        return jsonToString;
    }
}
