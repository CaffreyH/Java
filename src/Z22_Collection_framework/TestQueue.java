package Z22_Collection_framework;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Caffrey on 2017/4/6.
 */
public class TestQueue {
    public static void main(String[] args)
    {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("Oklahoma");
        queue.offer("Indiana");
        while(queue.size()>0)                       //    优先队列实现Comparble接口  内部的数据使用自然排序
        {
            System.out.println(queue.remove() + " ");
        }
        PriorityQueue<String> queue1 = new PriorityQueue<String>();
        queue1.offer("Oklahoma");
        queue1.offer("Indiana");
        queue1.offer("Texas");
        System.out.println("Priority queue using Comparble:");
        while(queue1.size()>0)
        {
            System.out.println(queue1.remove() + " ");
        }
        PriorityQueue<String> queue2 = new PriorityQueue<String>(4, Collections.reverseOrder());
        queue2.offer("Oklahoma");
        queue2.offer("Indiana");
        queue2.offer("Texas");
        System.out.println("Priority queue using Comparble And reserve:");
        while(queue2.size()>0)
        {
            System.out.println(queue2.remove() + " ");
        }
    }
}
