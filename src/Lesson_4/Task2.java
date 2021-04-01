package Lesson_4;

public class Task2 {
    private final Object printer = new Object();
    private final Object scanner = new Object();

    public Task2() throws InterruptedException
    {
        print();
        scan();
        copy();
    }
    public void print()
    {
        new Thread(() ->
        {
            try {
                synchronized (printer)
                {
                    System.out.println("Printing");
                    Thread.sleep(1000);
                    System.out.println("Print over");
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }).start();
    }
    public void scan() throws InterruptedException
    {
        new Thread(() ->
        {
            try {
                synchronized (scanner)
                {
                    System.out.println("Scanning");
                    Thread.sleep(1000);
                    System.out.println("Scan over");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public void copy() throws InterruptedException
    {
        new Thread(() ->
        {
            try {
                synchronized (scanner)
                {
                    synchronized (printer)
                    {
                        System.out.println("Copping");
                        Thread.sleep(1000);
                        System.out.println("Copping over");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
