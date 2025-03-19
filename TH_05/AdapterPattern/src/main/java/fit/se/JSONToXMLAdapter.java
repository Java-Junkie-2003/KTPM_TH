package fit.se;

import org.json.JSONObject;
import org.json.XML;

public class JSONToXMLAdapter implements DataConverter{
    @Override
    public String convertData(String data) {
        return parseJSONToXML(data);
    }

    public String parseJSONToXML(String jsonData){
        JSONObject json = new JSONObject(jsonData);
        return XML.toString(json);
    }
}
