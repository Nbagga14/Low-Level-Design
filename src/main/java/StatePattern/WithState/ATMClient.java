package StatePattern.WithState;

public class ATMClient {

   public static void main(String[] args) {

       ATM atm = new ATM();
       atm.initializeTransaction();
       atm.dispenseCash();
       atm.completeTransaction();
//        atm.dispenseCash();
        //atm.dispenseCash(); this will fail because user cannot dispense cash when trasnaction state is canceleld as done in above step.

    }
}
