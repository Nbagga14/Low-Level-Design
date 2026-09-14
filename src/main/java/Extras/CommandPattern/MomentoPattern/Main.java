package Extras.CommandPattern.MomentoPattern;

public class Main {

    public static void main(String[] args) {

       MomentoEditor editor1 = new MomentoEditor();
       editor1.writeContent("First test for momento", "Momento Test 1");

       CareTaker careTaker = new CareTaker();
       careTaker.saveContent(editor1);

       MomentoEditor editor2 = new MomentoEditor();
        editor2.writeContent("Second test for momento", "Momento Test 2");
       careTaker.saveContent(editor2);

       careTaker.undoContent();

    }
}
