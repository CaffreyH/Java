package Z29_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Caffrey on 2017/4/27.
 */
public class ThreadCooperation {
    public static Account account = new Account();
    public static void  main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new DepositTask());
        executorService.execute(new WithdrawTask());
        executorService.shutdown();
        System.out.println("Thread 1 \t\tThread 2\t\tBanlance");
    }

    public static class DepositTask implements Runnable{

        @Override
        public void run() {
            while(true)
            {
                account.deposit((int)Math.random() * 10 +1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class WithdrawTask implements Runnable{

        @Override
        public void run() {
            while(true)
            {
                account.withdrow((int)(Math.random() * 10)+1);
            }
        }
    }
    private static class Account {
        private static Lock lock = new ReentrantLock();
        private static Condition newDeposit = lock.newCondition();   //新建一个条件
        private int balance = 0;
        public int getBalance()
        {
            return balance;
        }
        public void withdrow(int amount)
        {
            lock.lock();
            try
            {
                while (balance < amount) {
                    System.out.println("\t\t\tWait for a deposit");
                    newDeposit.await();                                 //  余额不够，该条件更待
                }
                balance = balance - amount;
                System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
            }
             catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
            {
                lock.unlock();
            }
        }

        public void deposit(int amount)
        {
            lock.lock();
            try
            {
                balance = balance+amount;
                System.out.print("Deposit "+ amount +"\t\t\t\t\t"+getBalance());
                newDeposit.signalAll();                                              //  存钱后通知所有的线程
            }
            finally
            {
                lock.unlock();
            }
        }
    }
}
