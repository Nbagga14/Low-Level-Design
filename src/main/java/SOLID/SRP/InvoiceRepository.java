package SOLID.SRP;

public class InvoiceRepository {

    int amount;

    public InvoiceRepository(int amount)
    {
        this.amount = amount;
    }

    public void saveRepository()
    {
        System.out.println("Saving repository");
    }
}
