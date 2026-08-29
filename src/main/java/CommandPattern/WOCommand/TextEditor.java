package CommandPattern.WOCommand;

public class TextEditor {

    private String editor;

    public TextEditor(String editor)
    {
        this.editor=editor;
    }

    public void boldText()
    {
        System.out.println("This text has been bolded");
    }

    public void italicText()
    {
        System.out.println("This text has been italicised");
    }


    public static void main(String[] args) {

        TextEditor editor = new TextEditor("This is a text editor");
        BoldButton boldButton = new BoldButton(editor); // problem is for each button we have to create a new object of the text editor class
        ItalicButton italicButton = new ItalicButton(editor);

        boldButton.boldText();
        italicButton.italicText();
    }
}




