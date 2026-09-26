package TemplatePattern.WOTemplate;

public class WithoutTemplate {

    public static void main(String[] args) {

        CSVParser csvParser = new CSVParser();
        csvParser.openFile();
        csvParser.ParseData();
        csvParser.closeFile();

        System.out.println();

        JsonParser jsonParser = new JsonParser();
        jsonParser.openFile();
        jsonParser.ParseData();
        jsonParser.closeFile();

    }

}
