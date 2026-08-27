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
        if(!history.empty())
        {
            history.pop();
            history.peek().readContent();
        }
    }


}
