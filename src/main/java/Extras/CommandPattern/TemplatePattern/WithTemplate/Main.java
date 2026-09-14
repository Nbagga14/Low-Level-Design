package Extras.CommandPattern.TemplatePattern.WithTemplate;

public class Main {
    public static void main(String[] args) {
       TemplateMethod jsonParser = new JSONParser();
        jsonParser.templateFactory();
       TemplateMethod csvParser = new CSVParser();
       csvParser.templateFactory();
        }
    }

