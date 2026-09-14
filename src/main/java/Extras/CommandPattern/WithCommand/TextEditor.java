package Extras.CommandPattern.WithCommand;

public class TextEditor {

  public void boldText() {
    System.out.println("Text is bold");
  }

  public void italicText(){
    System.out.println("Text is italic");
  }

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        Button button = new Button();

        BoldButton boldButton = new BoldButton(editor); // Now the issue is resolved as we are using the command pattern and no need to create too many button instances
        button.setCommand(boldButton);
        button.click();

        button.setCommand(new ItalicButton(editor));
        button.click();

    }
}
