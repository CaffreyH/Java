package Z29_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Caffrey on 2017/4/26.
 */
public class ExecutorThreadPool {                               //Ϊ������񴴽��߳�ʹ���̳߳أ�������������
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(new PrintChar('a',100));
        executorService.execute(new PrintChar('b',100));
        executorService.execute(new PrintNum(100));
        executorService.shutdown();                          // ��סҪ�ص��̳߳�
    }
}
