package Lesson_6;

public class Task3
{
    public boolean check(int [] arr)
    {
        for (int num: arr)
        {
            if(num == 4)
            {
                for (int secNum: arr)
                {
                    if(secNum == 1)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
