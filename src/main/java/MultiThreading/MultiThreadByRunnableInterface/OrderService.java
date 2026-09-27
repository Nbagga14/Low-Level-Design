package MultiThreading.MultiThreadByRunnableInterface;

import java.util.concurrent.*;

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

class CalculateETARunnable implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            System.out.println("Starting ETA Thread");
            Thread.sleep(5000);
            String eta = "ETA Calculated!";
            return eta;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Error: Thread was interrupted";
        }
    }
}


public class OrderService {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // Create ExecutorService to manage threads (pool of 3)
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Create Runnable tasks for SMS and Email
        SendSMSRunnable smsRunnable = new SendSMSRunnable();
        SendEmailRunnable emailRunnable = new SendEmailRunnable();
        CalculateETARunnable etaRunnable = new CalculateETARunnable();

        // Submit SMS and Email tasks (no result required - Runnable)
        executorService.submit(smsRunnable);
        executorService.submit(emailRunnable);

        // Submit ETA task and get Future object for result (Callable)
        Future<String> etaResult = executorService.submit(etaRunnable);

        try {
            // Get the result from the Future object for ETA
            System.out.println("ETA Result: " + etaResult.get());

            long end = System.currentTimeMillis();
            System.out.println("All tasks completed in " + (end - start) + "ms");

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the ExecutorService
            executorService.shutdown();
        }
    }
}
