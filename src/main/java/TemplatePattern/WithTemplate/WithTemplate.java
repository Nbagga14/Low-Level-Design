package TemplatePattern.WithTemplate;

public class WithTemplate {
    public static void main(String[] args) {

        CSVParser csvParser = new CSVParser();
        csvParser.TemplateFactory();
        JSONParser jsonParser = new JSONParser();
        jsonParser.TemplateFactory();

    }
}
