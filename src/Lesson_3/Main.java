package Lesson_3;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {

        // #1 Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль

        System.out.println("\nEX. # 1\n");

        BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/Lesson_3/text.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int x;
        while ((x = in.read()) != -1)
        {
            out.write(x);
        }

        byte[] arr = out.toByteArray();
        for(byte b: arr)
        {
            System.out.print((char) b);
        }
        in.close();
        out.close();

        // #2 Последовательно сшить 5 файлов в один (файлы примерно 100 байт)

        System.out.println("\nEX. # 2\n");

        ArrayList <InputStream> ail = new ArrayList<>();
        ail.add(new FileInputStream("src/Lesson_3/text1.txt"));
        ail.add(new FileInputStream("src/Lesson_3/text2.txt"));
        ail.add(new FileInputStream("src/Lesson_3/text3.txt"));
        ail.add(new FileInputStream("src/Lesson_3/text4.txt"));
        ail.add(new FileInputStream("src/Lesson_3/text5.txt"));

        SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(ail));
        while ((x = sis.read()) != -1)
        {
            System.out.print((char)x);
        }
        sis.close();

        //#3 Написать консольное приложение, которое умеет постранично
        // читать текстовые файлы (размером > 10 mb). Вводим страницу
        // (за страницу можно принять 1800 символов), программа выводит
        // ее в консоль. Контролируем время выполнения: программа не
        // должна загружаться дольше 10 секунд, а чтение – занимать
        // свыше 5 секунд.

        System.out.println("\nEX. # 3\n");

        int pageNumber = 1;
        boolean lastPage = false;
        Scanner scanner;
        int answer;
        if(printPage(pageNumber) == -1)
        {
            lastPage = true;
        }
        info();
        while (true){
            scanner = new Scanner(System.in);
            try
            {
                answer = scanner.nextInt();
                switch (answer)
                {
                    case (2):
                        if(!lastPage)
                        {
                            pageNumber ++;
                            if(printPage(pageNumber) == -1)
                            {
                                System.out.println("!!");
                                lastPage = true;
                            }
                        }
                        else
                        {
                            System.out.println("It's last page");
                        }
                        break;
                    case (1):
                        if(pageNumber != 1)
                        {
                            lastPage = false;
                            pageNumber --;
                            printPage(pageNumber);
                        }
                        else
                        {
                            System.out.println("It's first page");
                        }
                        break;
                    case (0):
                        System.exit(0);
                    default:
                        info();
                        break;
                }
            }
            catch (InputMismatchException e)
            {
                try {
                    String answ = scanner.nextLine();
                    String ansArr[] = answ.split(" ", 2);
                    if (ansArr[0].equals("#")) {
                        pageNumber = Integer.parseInt(ansArr[1]);
                        printPage(pageNumber);
                    }
                    else
                    {
                        info();
                    }
                }
                catch (Exception exp)
                {
                    info();
                }
            }

        }
    }
    private static int printPage(int pageNumber) throws IOException
    {

        RandomAccessFile raf = new RandomAccessFile("src/Lesson_3/Oliver-Twist.txt","r");
        try
        {
            raf.seek((pageNumber - 1) * 1800);
            System.out.println("\nPAGE # " + pageNumber + "\n");
        }
        catch (Exception e)
        {
            info();
        }

        for (int i = 0; i < 1800; i++)
            {
                if(raf.read() == -1)
                {
                    return -1;
                }
                raf.seek((pageNumber - 1) * 1800 + i);
                System.out.print((char)raf.read());
            }
            System.out.println();
        return 0;
    }
    private static void info()
    {
        System.out.println("\n2 - Next page\n1 - Previous page\n# [Number page] - Go to curtain page\n0 - Exit\n");
    }



}
