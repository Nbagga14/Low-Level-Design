package Extras.CommandPattern.WOCommand;

public class BoldButton{
    private TextEditor editor;
    public BoldButton(TextEditor editor){
        this.editor=editor;
    }

    public void boldText()
    {
        editor.boldText();
    }
    
}
