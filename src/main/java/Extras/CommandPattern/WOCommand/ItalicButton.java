package Extras.CommandPattern.WOCommand;

public class ItalicButton {

    private TextEditor editor;

    public ItalicButton(TextEditor editor)
    {
        this.editor=editor;
    }

    public void italicText()
    {
       editor.italicText();
    }
}
