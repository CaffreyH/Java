package Z22_Collection_framework;

import java.util.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Created by Caffrey on 2017/4/6.
 */
public class ListPerformanceTest {
    public static void main(String[] args)
    {                                                    //第一组测试 集合
        Collection<Integer> set1 = new HashSet<Integer>();       //
        System.out.println("Time for HashSet is " + getTestTime(set1,5000) + "milliScconds");
        Collection<Integer> set2 = new LinkedHashSet<Integer>();
        System.out.println("Time for LinkedHash Set is" + getTestTime(set2,50000) + "milliSeconds");
        Collection<Integer> set3 = new TreeSet<Integer>();
        System.out.println("Time for TreeSet is" + getTestTime(set3,5000) + "milliSeconds");

        Collection<Integer> list1 = new ArrayList<Integer>();
        System.out.println("Time for ArrayList is" + getTestTime(list1,5000) + "milliSeconds");
        Collection<Integer> list2 = new LinkedList<Integer>();
        System.out.println("Time for LinkedList is" + getTestTime(list2,5000) + "milliSeconds");

    }                                                        //             规则集比线性更加高效
    public static long getTestTime(Collection<Integer> c ,int size)
    {
        long startTime = System.currentTimeMillis();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<size;i++)
        {
            list.add(i);
        }
        Collections.shuffle(list);
        for(int elment:list)
        {
            c.add(elment);
        }
        for(int element:list)
        {
            c.remove(element);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

}
