import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static boolean isGuessed = false;

    public static void main(String[] args) {
        int bound = 1_000_000_001;
        Random random = new Random();
        int number = random.nextInt(0, bound);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000_000; i++) {
                    if (isGuessed) {
                        break;
                    }
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start();

        Thread thread = new Thread();
        int num;
        do {
            num = random.nextInt();
        }
        while (num != number);
        isGuessed = true;
        System.out.println("The thread guessed random number: " + number);


    }
}