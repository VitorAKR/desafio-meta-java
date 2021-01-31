package desafio_meta.main;

import desafio_meta.model.ApiService;
import desafio_meta.model.Country;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vitor Reiter
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //este método serve pra fazer a busca 
        System.out.println("Informe código do país (exemplo: BRA): ");
        String codigoDoPais = new Scanner(System.in).nextLine().toUpperCase();
        codigoDoPais.toUpperCase();
        
        //verificar se codigo condiz com a lista passada e não é nula
        if(codigoDoPais != null && !codigoDoPais.isEmpty() && verifyCode(codigoDoPais)){
            
            ArrayList<Country> country = ApiService.findCountry(codigoDoPais);
            
            System.out.println(country);
            
        }else{

            System.out.println("Código do país inválido para realização da pesquisa!");
        }
        
    }
    
    public static boolean verifyCode(String code){
        //todos os codigos possiveis
        String [] codes = {"ABW", "LCN", "HIC", "LNX", "AFG", "SAS", "LIC",
                        "IDX", "AFR", "AGO", "SSF", "SSA", "LMC", "IBD", "ALB",
                        "ECS", "ECA", "UMC", "AND", "ARB", "ARE", "MEA", "ARG",
                        "LAC", "ARM", "ASM", "EAS", "EAP", "ATG", "AUS", "AUT",
                        "AZE", "BDI", "BEA", "BEC", "BEL", "BEN", "BFA", "BGD",
                        "BGR", "BHI", "BHR", "BHS", "BIH", "BLA", "BLR", "BLZ",
                        "BMN", "BMU", "NAC", "BOL", "BRA", "BRB", "BRN", "BSS",
                        "BTN", "BWA", "CAA", "CAF", "CAN", "CEA", "CEB", "CEU",
                        "CHE", "CHI", "CHL", "CHN", "CIV"};
        //converte em List pra verificar se existe
        List<String> list = Arrays.asList(codes);
        if(list.contains(code)) {
            return true;
        }else{
            return false;
        }
        
    }
}
