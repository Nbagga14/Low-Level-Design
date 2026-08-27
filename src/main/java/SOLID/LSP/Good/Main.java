package SOLID.LSP.Good;


public class Main {

    public static void main(String[] args)
    {
        Bird bird = new FlyingBird();
        bird.eat();        // ✅ parent easily replaced child

        Bird bird2 = new NonFlyingBird();
        bird2.eat();       // ✅parent easily replaced child

    }
}
