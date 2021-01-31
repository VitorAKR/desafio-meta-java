
package desafio_meta.model;

import com.google.gson.Gson;
import desafio_meta.util.Util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Vitor Reiter
 */
public class ApiService {
    static String site = "http://api.worldbank.org/v2/country/";
    static int successCode = 200;
    
    public static ArrayList<Country> findCountry(String codCountry) throws Exception{
        String formattedUrl = site + codCountry + "/indicator/SI.POV.DDAY?format=json";
        
        try{
            //abrir conexão com url formatada pra consumir a API da World Bank
            URL url = new URL(formattedUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            //verificar se o código foi 200, ou seja, conectou ou não
            if(connection.getResponseCode() != successCode){
                throw new RuntimeException("HTTP error code: " + connection.getResponseCode());
            }else{
                System.out.println("Status: " + connection.getResponseCode());
            }
            
            BufferedReader answer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String jsonToString = Util.convertJsonToString(answer);
            //System.out.println(jsonToString);
            
            //library gson-2.8.5.jar adicionada 
            Gson gson = new Gson();
            ArrayList<Country> countryRows = gson.fromJson(jsonToString, ArrayList.class);
            
            
            return countryRows;
        }catch(Exception e){
            throw new Exception("ERRO: " + e);
        }
        
    }
    
}
