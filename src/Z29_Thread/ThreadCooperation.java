package Z29_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Caffrey on 2017/4/27.
 */
public class ThreadCooperation {
    public static Account account = new Account();
    public static void  main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
     //   executorService.execute(new DespositTask());
     //   executorService.execute(new WithdrawTask());
        executorService.shutdown();
    }

    private static class Account {
    }
}
