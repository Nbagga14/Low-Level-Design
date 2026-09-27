package MultiThreading.MultiThreadByRunnableInterface;

class SendSMSRunnable implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Starting SMS Thread");
            Thread.sleep(2000);
            System.out.println("SMS Sent!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SendEmailRunnable implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Starting EMAIL Thread");
            Thread.sleep(3000);
            System.out.println("EMAIL Sent!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CalculateETARunnable implements Runnable {


    @Override
    public void run() {
        try {
            System.out.println("Starting ETA Thread");
            Thread.sleep(5000);
            System.out.println("ETA Calculated!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class OrderService {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        SendSMSRunnable smsRunnable = new SendSMSRunnable();
        SendEmailRunnable emailRunnable = new SendEmailRunnable();
        CalculateETARunnable etaRunnable = new CalculateETARunnable();

        Thread smsThread = new Thread(smsRunnable);
        Thread emailThread = new Thread(emailRunnable);
        Thread etaThread = new Thread(etaRunnable);

        smsThread.start();
        emailThread.start();
        etaThread.start();

        try{
            smsThread.join();
            emailThread.join();
            etaThread.join();
            long end = System.currentTimeMillis();
            System.out.println("All tasks completed in " + (end - start) + "ms");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
