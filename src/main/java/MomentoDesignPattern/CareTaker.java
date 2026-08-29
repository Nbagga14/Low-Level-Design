package MomentoDesignPattern;

import java.util.Stack;

public class CareTaker {

    private Stack<MomentoEditor> history = new Stack<>();

    public void saveContent(MomentoEditor momentoEditor)
    {
        history.push(momentoEditor);
    }

    public void undoContent()
    {
        if(history.size()>1)
        {
            history.pop();
            history.peek().readContent();
        }
        else if(history.size()==1)
        history.peek().readContent();

    }


}
