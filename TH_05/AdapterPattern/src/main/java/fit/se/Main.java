package fit.se;

public class Main {
    public static void main(String[] args) {
        String xmlData = "<user><name>John</name> <age>22</age></user>";
        DataConverter xmlToJSON = new XMLToJSONAdapter(new JsonAdaptee());
        xmlToJSON.convertData(xmlData);
//        DataConverter jsonToXML = new JSONToXMLAdapter();
//        String xmlResult = jsonToXML.convertData(jsonResult);
//        System.out.println("XML output: "+ xmlResult);


    }
}