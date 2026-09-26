package StatePattern.WOState;

public class ATM {

    private String state = "IDLE";

    public void initializeTransaction() {

        if (state.equals("IDLE")) {
            System.out.println("Transaction initialized");
            state = "TRANSACTION";
        }
        else {
            System.out.println("Transaction already initialized");
        }
    }

    public void dispenseCash() {

        if (state.equals("IDLE")) {
            System.out.println("Please initialize transaction first");
        }
        else if (state.equals("TRANSACTION")) {
            System.out.println("Cash dispensing...");
            state = "CASH_DISPENSED";
        }
        else if (state.equals("CASH_DISPENSED")) {
            System.out.println("Cash already dispensed");
        }
    }

    public void cancelTransaction() {

        if (state.equals("IDLE")) {
            System.out.println("No transaction to cancel");
        }
        else if (state.equals("TRANSACTION")) {
            System.out.println("Transaction cancelled");
            state = "IDLE";
        }
        else if (state.equals("CASH_DISPENSED")) {
            System.out.println("Cannot cancel after cash is dispensed");
        }
    }


    public static void main(String[] args) {

        ATM atm = new ATM();

        atm.dispenseCash();

        atm.initializeTransaction();

        atm.dispenseCash();

        atm.cancelTransaction();

        atm.dispenseCash();
    }
}