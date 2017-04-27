package Z29_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Caffrey on 2017/4/27.
 */
public class AcountWithoutSync {
    private static Account account = new Account();
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<100;i++)
        {
            executorService.execute(new AddPennyTask());            //创建100个存钱的线程
        }
        executorService.shutdown();
        while(!executorService.isTerminated())
        {
        }
        System.out.println("What is balance ? "+account.getBalance());
    }

    private static class AddPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    private static class Account {
        private int balance = 0;
        public int getBalance()
        {
            return balance;
        }
        public void deposit(int amount)
        {
            int newBalance = balance + amount;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = newBalance;
           // balance = balance + amount;
        }
    }
}
