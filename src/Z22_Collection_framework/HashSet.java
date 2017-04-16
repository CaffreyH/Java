package Z22_Collection_framework;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Caffrey on 2017/4/5.
 */
public class HashSet {
    public static void main(String[] args)
    {
        Set<String> set = new java.util.HashSet<String>();
        set.add("London");
        set.add("Beijing");
        set.add("Paris");
        set.add("New York");
        set.remove("Paris");
        set.add("San Francisco");
        set.add("New York");        //  Hash 的元素不重复！！！！！！！！
        System.out.println(set);
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext())       // Hash 的输出没有顺序！！！！！！
        {
            System.out.println(iterator.next().toUpperCase()+" ");
        }
        for(String element:set)       //<----------------------遍历一个  set -——————————>
        {
            System.out.println(element);
        }
    }

}
