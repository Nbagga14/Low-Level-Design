package CommandPattern.WithCommand;

public class ItalicButton implements Command {

    private TextEditor textEditor;

    public ItalicButton(TextEditor textEditor)
    {
        this.textEditor=textEditor;
    }

    @Override
    public void execute() {
        textEditor.italicText();
    }
}
