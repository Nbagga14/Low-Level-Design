package MultiThreading.RaceConditions;

class SocialMedia {

    private volatile int likes;

    // volatile → visibility for read operations
    // synchronized → protection for write/update operations

    public void updateLikes() {
        likes++;
    }

    public int getLikes() {
        return likes;
    }
}

public class RaceConditionSolution {

    public static void main(String[] args) throws InterruptedException {

        SocialMedia socialMedia = new SocialMedia();

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                socialMedia.updateLikes();
            }
        });

        Thread reader = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Likes: " + socialMedia.getLikes());
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();

        System.out.println("Final Likes: " + socialMedia.getLikes());
    }
}