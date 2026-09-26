package StatePattern.WithState;

public class ATM {
    private ATMStates currentState;

    public ATM() {
        this.currentState = new InitializeTransactionState(this);
    }

    public ATMStates getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ATMStates state) {
        this.currentState = state;
    }

    public void initializeTransaction() {
        currentState.initializeTransaction();  // Delegate to state
    }

    public void dispenseCash() {
        currentState.dispenseCash();  // Delegate to state
    }

    public void cancelTransaction() {
        currentState.cancelTransaction();  // Delegate to state
    }

    public void completeTransaction()
    {
        currentState.transactionCompleted();
    }
}
