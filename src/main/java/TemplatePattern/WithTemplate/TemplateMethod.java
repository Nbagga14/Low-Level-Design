package TemplatePattern.WithTemplate;

public abstract class TemplateMethod {

    public void OpenFile() {
        System.out.println("Opening File");
    }

    public void CloseFile() {
        System.out.println("Closing File");
    }

    public abstract void parseData();

    void TemplateFactory() {
        OpenFile();
        CloseFile();
        parseData();
    }
}
