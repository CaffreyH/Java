package Z22_Collection_framework;

import java.util.Set;

/**
 * Created by Caffrey on 2017/4/5.
 */
public class LinkedHashSet {
    public static void main(String[] args)
    {
        Set<String> set = new java.util.LinkedHashSet<String>();
        set.add("Beijing");
        set.add("Lindon");
        set.add("New York");           //  链式散列集  不能存储重复的元素，存储有顺序！！！！！
        System.out.println(set);
        for(Object element:set)
        {
            System.out.print(element+" ");
        }
    }
}
