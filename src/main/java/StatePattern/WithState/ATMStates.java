package StatePattern.WithState;

public interface ATMStates {

    public void initializeTransaction();

    public void dispenseCash();

    public void cancelTransaction();

    public void transactionCompleted();
}
