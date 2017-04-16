package Z22_Collection_framework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Caffrey on 2017/4/6.
 */
public class TestMap
{
    public static void main(String[] args)
    {
        Map<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("Smith",30);
        hashMap.put("Anderson",31);
        hashMap.put("Lewis",29);
        hashMap.put("Cook",33);

        Map<String,Integer> treeMap = new TreeMap<String,Integer>(hashMap);
        System.out.println("Display entries in ascending oder of key");
        System.out.println(treeMap);

        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<String ,Integer>(16,0.75f,true);
        linkedHashMap.put("Smith",30);
        linkedHashMap.put("Anderson",29);
        linkedHashMap.put("Lewis",40);
        System.out.println("The age for Lewis is " + linkedHashMap.get("Lewis").intValue());
        System.out.println("Display entries in LinkedHashMap");
        System.out.print(linkedHashMap);

    }

}
