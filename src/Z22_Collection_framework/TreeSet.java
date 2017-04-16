package Z22_Collection_framework;

import java.util.Set;

/**
 * Created by Caffrey on 2017/4/5.
 */
public class TreeSet {
    public static void main(String[] args)
    {
        Set<String> set = new java.util.HashSet<String>();
        set.add("London");
        set.add("Beijing");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        java.util.TreeSet<String> treeset = new java.util.TreeSet<String>(set);
        System.out.println(treeset);
    }

}
