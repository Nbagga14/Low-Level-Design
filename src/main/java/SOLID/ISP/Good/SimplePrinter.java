package SOLID.ISP.Good;

public class SimplePrinter implements Print{
    @Override
    public void print() {
        System.out.println("Printing document...");
    }
}
