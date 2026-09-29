package MultiThreading.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class BookMyShow {

    private int availableSeats = 10;

    private final ReentrantReadWriteLock lock =
            new ReentrantReadWriteLock();



    public void checkSeats() {

        System.out.println(
                Thread.currentThread().getName()
                        + " → Trying to get READ lock..."
        );

        lock.readLock().lock();

        try {
            System.out.println(
                    Thread.currentThread().getName()
                            + " → READ LOCK ACQUIRED"
            );

            Thread.sleep(5000); // Hold READ lock for 5 sec

            System.out.println(
                    Thread.currentThread().getName()
                            + " → Finished READING"
            );

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        } finally {
            lock.readLock().unlock();

            System.out.println(
                    Thread.currentThread().getName()
                            + " → READ LOCK RELEASED"
            );
        }
    }


    // User is CHANGING the data
    public void bookSeat() {

        System.out.println(
                Thread.currentThread().getName()
                        + " → Trying to get WRITE lock..."
        );

        lock.writeLock().lock();

        try {
            System.out.println(
                    Thread.currentThread().getName()
                            + " → WRITE LOCK ACQUIRED"
            );

            Thread.sleep(2000); // Hold WRITE lock for 2 sec

            if (availableSeats > 0) {
                availableSeats--;

                System.out.println(
                        Thread.currentThread().getName()
                                + " → Seat booked!"
                );
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        } finally {
            lock.writeLock().unlock();

            System.out.println(
                    Thread.currentThread().getName()
                            + " → WRITE LOCK RELEASED"
            );
        }
    }
}


public class Main {

    public static void main(String[] args) throws InterruptedException {

        BookMyShow bms = new BookMyShow();


        // Multiple READERS
        Thread user1 = new Thread(
                () -> bms.checkSeats(), "User-1"
        );

        Thread user2 = new Thread(
                () -> bms.checkSeats(), "User-2"
        );

        Thread user3 = new Thread(
                () -> bms.checkSeats(), "User-3"
        );


        // WRITER
        Thread user4 = new Thread(
                () -> bms.bookSeat(), "User-4"
        );


        // Start all READERS first
        user1.start();
        user2.start();
        user3.start();


        // Make sure READERS get the lock first
        Thread.sleep(1000);


        // Now WRITER tries to get the lock
        user4.start();
    }
}

// ReadWriteLock = Multiple users can READ together,
//                 but WRITE requires exclusive access.
//
// ReadLock  → Multiple users can READ together,
//             but wait if someone is WRITING.
//
// WriteLock → Only one user can WRITE,
//             while both READERS and other WRITERS wait.
//
// Easy rule:
// READ  → READ allowed together
// WRITE → Nobody else allowed


// Multiple users are only READING