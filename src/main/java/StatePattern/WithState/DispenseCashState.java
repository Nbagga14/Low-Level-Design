package StatePattern.WithState;

public class DispenseCashState implements ATMStates{

    private ATM atm;

    public DispenseCashState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void initializeTransaction() {
        throw new RuntimeException("Transaction is already in progress");
    }

    @Override
    public void dispenseCash() {
        System.out.println("Logic for Dispensing Cash");
        atm.setCurrentState(new CancelTransactionState(atm));
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Cannot cancel during cash dispensing");
    }

    @Override
    public void transactionCompleted() {

    }
}
