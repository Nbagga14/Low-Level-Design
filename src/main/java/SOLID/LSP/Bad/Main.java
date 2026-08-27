package SOLID.LSP.Bad;

public class Main {

    public static void main(String[] args)
    {
        Bird b1 = new Bird();
        Bird flyingbird = new Bird();
        Bird NonflyingBird = new NonflyingBird();

        NonflyingBird.fly();
    }

 }
