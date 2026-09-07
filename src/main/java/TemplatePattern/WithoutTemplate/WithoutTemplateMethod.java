package TemplatePattern.WithoutTemplate;

public class WithoutTemplateMethod {

    public static void main(String[] args) {

        csvParser csvParser = new csvParser();
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
