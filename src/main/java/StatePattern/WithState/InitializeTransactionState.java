package StatePattern.WithState;

public class InitializeTransactionState implements ATMStates{
    private ATM atm;

    public InitializeTransactionState(ATM atm)
    {
        this.atm=atm;
    }
    @Override
    public void initializeTransaction() {
        System.out.println("Logic for Initializing Transaction");
        atm.setCurrentState(new DispenseCashState(atm));
    }

    @Override
    public void dispenseCash() {
    throw new RuntimeException("Transaction is in initialized state");
    }

    @Override
    public void cancelTransaction() {
        atm.setCurrentState(new CancelTransactionState(atm));

    }

    @Override
    public void transactionCompleted() {
        throw new RuntimeException("Transaction is in initialized state");
    }
}
