package StatePattern.WithState;

public class CancelTransactionState implements ATMStates {

    private final ATM atm;

    public CancelTransactionState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void initializeTransaction() {
        throw new RuntimeException("Transaction is cancelled");
    }

    @Override
    public void dispenseCash() {
        throw new RuntimeException("Transaction is cancelled");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Logic for cancelling transaction");
        atm.setCurrentState(new CancelTransactionState(atm));
    }

    @Override
    public void transactionCompleted() {
        atm.setCurrentState(new CompletedTransactionState(atm));
    }
}
