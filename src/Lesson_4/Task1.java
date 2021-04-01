package Lesson_4;

public class Task1 {
    private final Object object = new Object();
    private volatile char letter = 'A';

    public Task1() {
        new Thread(() ->
        {
            synchronized (object)
            {
                try
                {
                    for (int i = 0; i < 5; i++)
                    {
                        while (letter != 'A')
                        {
                            object.wait();
                        }
                        System.out.print('A');
                        letter = 'B';
                        object.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() ->
        {
            synchronized (object)
            {
                try
                {
                    for (int i = 0; i < 5; i++)
                    {
                        while (letter != 'B')
                        {
                            object.wait();
                        }
                        System.out.print('B');
                        letter = 'C';
                        object.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() ->
        {
            synchronized (object)
            {
                try
                {
                    for (int i = 0; i < 5; i++)
                    {
                        while (letter != 'C')
                        {
                            object.wait();
                        }
                        System.out.print('C');
                        letter = 'A';
                        object.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
