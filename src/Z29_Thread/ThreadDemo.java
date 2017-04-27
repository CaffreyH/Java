package Z29_Thread;

/**
 * Created by Caffrey on 2017/4/26.
 */
public class ThreadDemo {
    public static void main(String[] args)
    {
        Runnable printA = new PrintChar('a',10000);
        Runnable printB = new PrintChar('b',10000);
        Runnable print100 = new PrintNum(10000);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        thread1.start();
        thread2.start();
        thread3.start();

    }

}

class PrintChar implements Runnable
{
    private char chatToPrint;
    private int times;
    public PrintChar(char c,int t)
    {
        chatToPrint = c;
        times = t;
    }
    @Override
    public void run() {
        for(int i=0;i<times;i++)
        {
            System.out.print(chatToPrint);
        }
    }
}
class PrintNum implements Runnable
{
    private int lastNum;
    public PrintNum(int n)
    {
        lastNum = n;
    }

    @Override
    public void run() {
        for(int i=1;i<=lastNum;i++)
        {
            System.out.print(" "+i);
            if(i==50)
            {
                Runnable print2 = new PrintChar('*',200);
                Thread thread4 = new Thread(print2);
                thread4.start();
                try {
                    thread4.join();                                    // 线程的join方法，在执行完后执行  thread4
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}