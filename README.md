# consumir API de indicadores da World Bank (JAVA)

### Recursos Usados
Lista de recursos usados no desafio

| Recurso | Link |
| ------ | ------ |
| World Bank API | http://api.worldbank.org/v2/country/%7BCODIGO_DO_PAIS%7D/indicator/SI.POV.DDAY?format=json |
| Códigos de países | http://api.worldbank.org/v2/country |
| Biblioteca GSON | gson-2.8.5.jar (facilita pra pegar propriedades do JSON e atribuir em atributos de uma classe) |

### Descrição
Implementado parte do BackEnd em Java para consumir a API de indicadores da World Bank. Como não há FrontEnd em Angular, foi feita uma classe Main para eventuais testes.
É verificado se a entrada com o código de país não é nula, se não está vazia e se está dentro do escopo de códigos de países.

Para acessar os dados retornados pela API utilizou-se de uma classe com um método que inicia uma conexão, usa-se também uma classe auxilixar para converter o JSON em texto e uma biblioteca para atribuição de valores no array de retorno.

```java
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
```

Agradeço pela oportunidade em participar deste desafio! \o/
