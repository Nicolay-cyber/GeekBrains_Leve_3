package Lesson_4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->
        {
            System.out.println("TASK # 1");
            new Task1();
        });
        Thread t2 = new Thread(() ->
        {
            System.out.println("\nTASK # 2");
            try {
                new Task2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        if(t1.isAlive())
        {
            t2.start();
        }
    }
}
