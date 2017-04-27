package Z29_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Caffrey on 2017/4/26.
 */
public class ExecutorThreadPool {                               //为多个任务创建线程使用线程池！！！！！！！
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(new PrintChar('a',100));
        executorService.execute(new PrintChar('b',100));
        executorService.execute(new PrintNum(100));
        executorService.shutdown();                          // 记住要关掉线程池
    }
}
