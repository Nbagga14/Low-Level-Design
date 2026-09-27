package MultiThreading.MultiThreadByExtendingThreadClass;


class SMSThread extends Thread {
    public void run(){
        try{
            System.out.println("SMS Thread started");
            Thread.sleep(2000); // Delay of 2 seconds
            System.out.println("SMS Sent!");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class EmailThread extends Thread{
    public void run(){
        try{
            System.out.println("Email Thread started");
            Thread.sleep(3000); // Delay of 2 seconds
            System.out.println("Email Sent!");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CalculateETAThread extends Thread{
    public void run(){
        try{
            System.out.println("CalculateETA Thread started");
            Thread.sleep(5000); // Delay of 2 seconds
            System.out.println("Calculated ETA using Thread!");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class OrderService {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        SMSThread smsThread = new SMSThread();
        EmailThread emailThread = new EmailThread();
        CalculateETAThread calculateETAThread = new CalculateETAThread();

        smsThread.start();
        emailThread.start();
        calculateETAThread.start();

        try{
            smsThread.join();
            emailThread.join();
            calculateETAThread.join();
            long end = System.currentTimeMillis();
            System.out.println("All tasks completed in " + (end - start) + "ms");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
