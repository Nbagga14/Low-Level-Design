package MultiThreading.MultiThreadByExtendingThreadClass;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

class CalculateETAThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            System.out.println("CalculateETA Thread started");
            Thread.sleep(5000);
            String ETA = "Calculated ETA using Thread!";
            return ETA;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Error: Thread was interrupted";
        }
    }
}

public class OrderService {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        SMSThread smsThread = new SMSThread();
        EmailThread emailThread = new EmailThread();
        CalculateETAThread calculateETAThread = new CalculateETAThread();

        smsThread.start();
        emailThread.start();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit Callable task and get Future object
        Future<String> etaFuture = executor.submit(new CalculateETAThread());

        try{
            smsThread.join();
            emailThread.join();

            // Get the result from Future (blocks until result is ready)
            String etaResult = etaFuture.get();
            System.out.println("ETA Result: " + etaResult);

            long end = System.currentTimeMillis();
            System.out.println("All tasks completed in " + (end - start) + "ms");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        executor.shutdown();
    }
}
