package Extras.CommandPattern.TemplatePattern.WithTemplate;

import static java.lang.System.out;

public abstract class TemplateMethod {

   void templateFactory() {
        openFile();
        parseData();
        closeFile();
    }

    public void openFile(){
        System.out.println("Opening file");
    }
    public void closeFile(){
        System.out.println("Closing file");
    }
    public abstract void parseData();
}


