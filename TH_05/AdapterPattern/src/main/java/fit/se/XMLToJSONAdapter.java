package fit.se;

import org.json.JSONObject;
import org.json.XML;

public class XMLToJSONAdapter implements DataConverter{
    private JsonAdaptee jsonAdaptee;
    public XMLToJSONAdapter(JsonAdaptee jsonAdaptee){
        this.jsonAdaptee = jsonAdaptee;
    }
    @Override
    public String convertData(String data) {
        System.out.println("Converting XML data to JSON");
        String json = parseXMLToJson(data);
        jsonAdaptee.convertJson(json);
        return json;
    }
    public  String parseXMLToJson(String xml){
        JSONObject json = XML.toJSONObject(xml);
        return json.toString(4);
    }
}
