package Extras.CommandPattern.MomentoPattern;

public class MomentoEditor {

    String headline;
    String content;

    public void writeContent(String headline, String content)
    {
        this.headline = headline;
        this.content =content;
    }

    public void readContent()
    {
        System.out.print("Headline: " + headline + "\nContent: " + content);
    }


}
