## Java学习历程--线程同步

线程同步的几种方式：
1使用同步语句
2利用加锁同步
3.线程间的协作

### 1使用同步语句
```
//使用同步语句的方法
 Synchronized（expr）
    {
        statements;
    }
```
## 特点：
   synchronized 方法控制对类成员变量的访问：每个类实例对应一把锁，每个 synchronized 方法都必须获得调用该方法的类实例的锁方能执行，否则所属线程阻塞，方法一旦执行，就独占该锁，直到从该方法返回时才将锁释放，此后被阻塞的线程方能获得该锁，重新进入可执行状态。这种机制确保了同一时刻对于每一个类实例，其所有声明为 synchronized 的成员函数中至多只有一个处于可执行状态（因为至多只有一个能够获得该类实例对应的锁），从而有效避免了类成员变量的访问冲突（只要所有可能访问类成员变量的方法均被声明为 synchronized）

## synchronized 方法的缺陷：
   若将一个大的方法声明为synchronized 将会大大影响效率，典型地，若将线程类的方法 run() 声明为synchronized ，由于在线程的整个生命期内它一直在运行，因此将导致它对本类任何 synchronized 方法的调用都永远不会成功。当然我们可以通过将访问类成员变量的代码放到专门的方法中，将其声明为 synchronized ，并在主方法中调用来解决这一问题，但是 Java 为我们提供了更好的解决办法，那就是 synchronized 块。
     
### 2利用加锁同步
```
 Lock lock = new ReentrantLock();
                 lock.lock();
                 try{
                      //可能会出现线程安全的操作
                     }
                 finally{
                    //一定在finally中释放锁
                   //也不能把获取锁在try中进行，因为有可能在获取锁的时候抛出异常
                  lock.ublock();
```

## 2.1 Lock接口与synchronized关键字的区别
   Lock接口可以尝试非阻塞地获取锁 当前线程尝试获取锁。如果这一时刻锁没有被其他线程获取到，则成功获取并持有锁。
   *Lock接口能被中断地获取锁 与synchronized不同，获取到锁的线程能够响应中断，当获取到的锁的线程被中断时，中断异常将会被抛出，同时锁会被释放。
   Lock接口在指定的截止时间之前获取锁，如果截止时间到了依旧无法获取锁，则返回。

## 2.2 Lock接口的API

   void lock() 获取锁,调用该方法当前线程将会获取锁，当锁获取后，该方法将返回。
   void lockInterruptibly() throws InterruptedException 可中断获取锁，与lock()方法不同之处在于该方法会响应中断，即在锁的获取过程中可以中断当前线程
    boolean tryLock() 尝试非阻塞的获取锁，调用该方法立即返回，true表示获取到锁
    boolean tryLock(long time,TimeUnit unit) throws InterruptedException 超时获取锁，以下情况会返回：时间内获取到了锁，时间内被中断，时间到了没有获取到锁。
    void unlock() 释放锁

### 3.线程间的协作
   线程间的通信条件：Lock对象的newCondition()方法创建对象，await（）方法使当前线程处于等待状态，知道condition条件发生，sigal()
   用于唤醒一个处于等待中的线程，相应的，singalAll（）唤醒所有等待中的线程
