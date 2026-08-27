package SOLID.LSP.Bad;

public class NonflyingBird extends Bird{

    public void fly()
    {
        throw new UnsupportedOperationException("This bird can't fly");
    }
}
