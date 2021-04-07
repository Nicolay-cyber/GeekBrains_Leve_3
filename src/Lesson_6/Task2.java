package Lesson_6;

import java.util.Arrays;

public class Task2
{
    public int[] cut(int[] arr)
    {
        int cutPoint = -1;
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 4)
            {
                cutPoint = i + 1;
            }
        }
        if(cutPoint == -1)
        {
            throw new RuntimeException("Array doesn't includes 4");
        }
        return Arrays.copyOfRange(arr, cutPoint, arr.length);
    }
}
