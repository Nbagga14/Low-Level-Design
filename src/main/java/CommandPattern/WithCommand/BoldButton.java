package CommandPattern.WithCommand;

public class BoldButton implements Command{

    private TextEditor textEditor;

    public BoldButton(TextEditor textEditor)
    {
        this.textEditor=textEditor;
    }
    @Override
    public void execute() {
        textEditor.boldText();
    }


}
