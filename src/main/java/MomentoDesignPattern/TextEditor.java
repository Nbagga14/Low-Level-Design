package MomentoDesignPattern;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

public class TextEditor {

    MomentoEditor momentoEditor = new MomentoEditor();

    public void writeContent(String headline, String content)
    {
        momentoEditor.headline =headline;
        momentoEditor.content=content;;

    }

    public void getContent()
    {
        System.out.println("Momento Editor headline is"+ momentoEditor.headline);
        System.out.println("Momento Editor content is"+ momentoEditor.content);
    }
}
