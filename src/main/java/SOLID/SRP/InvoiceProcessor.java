package SOLID.SRP;

public class InvoiceProcessor {

    private int amount;

    public InvoiceProcessor(int amount)
    {
        this.amount = amount;
    }

    public void generateInvoice()
    {
        System.out.print("Generating invoice for amount: " + amount);
    }

}
