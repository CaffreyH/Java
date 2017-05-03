package Z29_Thread;


import java.nio.Buffer;
import java.nio.MappedByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Caffrey on 2017/4/28.
 */
public class CustomerProducer {
    private static Buffer buffer;
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new CustomerTask());
        executor.shutdown();
    }

    private static class ProducerTask implements Runnable {
        @Override
        public void run() {
            int i = 1;
            while(true)
            {
                System.out.println("Rroducer writes "+ i);
                try {
                    buffer.write(i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class CustomerTask implements Runnable
    {

        @Override
        public void run() {
            while(true)
            {
                System.out.println("\t\t\tConsumer reads"+buffer.read());
                try {
                    Thread.sleep( (int)(Math.random() * 10000));
                } catch (InterruptedException e) {

                }
            }
        }
    }
    public static class Buffer{
        private static final int CAPACITY = 1;
        private java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();
        private static Lock lock = new ReentrantLock();
        private static Condition notEmpty = lock.newCondition();
        private static Condition notFull = lock.newCondition();

        public void write(int value) throws InterruptedException {
            lock.lock();
            try
            {
                while(queue.size() == CAPACITY);
                {
                    System.out.println("Wait for not Full condition");
                    notFull.await();
                }
                queue.offer(value);
                notEmpty.signalAll();
            }
           catch (Exception e)
           {
                e.printStackTrace();
           }
           finally
            {
                lock.unlock();
            }
        }
        public int read()
        {
            int value = 0;
            lock.unlock();
            try
            {
                while(queue.isEmpty())
                {
                    System.out.print("\t\t\tWait for not Empty condition");
                    notEmpty.await();
                }
                value = queue.remove();
                notFull.signalAll();
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                lock.unlock();
                return value;
            }
        }

    }
}
