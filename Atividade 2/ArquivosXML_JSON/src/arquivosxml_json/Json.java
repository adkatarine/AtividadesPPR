/*
 *
 */
package arquivosxml_json;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Adlla Katarine
 */
public class Json {
    private JSONObject estabelecimentos;
    private JSONObject points;
    private JSONArray arrayEstabelecimentos;
    
    public Json(){
        this.arrayEstabelecimentos = new JSONArray();
    }

    public JSONArray getArrayEstabelecimentos() {
        return arrayEstabelecimentos;
    }

    public void setArrayEstabelecimentos(JSONArray arrayEstabelecimentos) {
        this.arrayEstabelecimentos = arrayEstabelecimentos;
    }
    
    public void addEstabelecimento(String name, String type, String latitude, String longitude){
        this.estabelecimentos = new JSONObject();
        this.points = new JSONObject();
        this.estabelecimentos.accumulate("name", name);
        this.estabelecimentos.accumulate("type", type);
        this.points.accumulate("lat", Double.valueOf(latitude));
        this.points.accumulate("lgt", Double.valueOf(longitude));
        this.estabelecimentos.accumulate("point", this.points);
        this.arrayEstabelecimentos.put(estabelecimentos);
    }
    
    public void arquivoJson() throws IOException{
        FileWriter writeFile = new FileWriter("Estabelecimentos.json");
        //Escreve no arquivo o conteudo do Array JSON
        writeFile.write(arrayEstabelecimentos.toString());
        writeFile.close();
    }   
}