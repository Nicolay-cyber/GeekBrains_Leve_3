package Lesson_6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass
{
    Task2 task2;
    Task3 task3;
    @Before
    public void init()
    {
        task2 = new Task2();
        task3 = new Task3();
    }

    // TASK # 2

    @Test
    public void testTask2_1()
    {
        Assert.assertArrayEquals(new int[]{1, 7}, task2.cut(new int[]{4, 3, 4, 1, 7}));
    }
    @Test
    public void testTask2_2()
    {
        Assert.assertArrayEquals (new int[]{}, task2.cut(new int[]{4, 5, 0, 4}));
    }
    @Test(expected = RuntimeException.class)
    public void testTask2_3()
    {
        Assert.assertArrayEquals (new int[]{}, task2.cut(new int[]{5, 0, 0}));
    }

    //TASK # 3

    @Test
    public void testTask3_1()
    {
        Assert.assertTrue(task3.check(new int[]{0, 4, 4, 1, 0}));
    }
    @Test
    public void testTask3_2()
    {
        Assert.assertFalse(task3.check(new int[]{0, 4, 4, 0}));
    }
    @Test
    public void testTask3_3()
    {
        Assert.assertFalse(task3.check(new int[]{10, 34, 1, 11}));
    }
    @Test
    public void testTask3_4()
    {
        Assert.assertFalse(task3.check(new int[]{10, 34, 0, 11}));
    }
}
