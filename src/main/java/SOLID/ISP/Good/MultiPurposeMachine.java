package SOLID.ISP.Good;

public class MultiPurposeMachine implements Print,Scan{
    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void Scan() {
        System.out.println("Scanning document...");

    }
}
