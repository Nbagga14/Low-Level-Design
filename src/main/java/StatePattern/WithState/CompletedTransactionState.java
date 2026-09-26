package StatePattern.WithState;

public class CompletedTransactionState implements ATMStates{
    private final ATM atm;
    public CompletedTransactionState(ATM atm)
    {
        this.atm=atm;
    }
    @Override
    public void initializeTransaction() {
    throw new RuntimeException("Transaction is completed");
    }

    @Override
    public void dispenseCash() {
        throw new RuntimeException("Transaction is completed");
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Transaction is completed");
    }

    @Override
    public void transactionCompleted() {
        System.out.print("Transaction completed");
    }
}
