package Z22_Collection_framework;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 * Created by Caffrey on 2017/4/6.
 */
public class WordsCount {
    public static void main(String[] args)
    {
        String text = "Dood morning. Have a good class."+ "Have a good visit.Have a fun";
        TreeMap<String,Integer> map = new TreeMap<String,Integer>();
        String[] words = text.split("[ \n\t\r.,;:!?(){]");   //  神奇的表达方式！！！！！！！！！！！！
        for(int i=0;i< words.length;i++)
        {
            String key = words[i].toLowerCase();
            if(key.length() > 0)
            {
                if(map.get(key)==null)
                {
                    map.put(key,1);
                }
                else
                {
                    int value = map.get(key).intValue();
                    value++;
                    map.put(key,value);
                }
            }
        }
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();        //   最推荐的迭代方式！！！！！！！！
        for(Map.Entry<String,Integer> entry:entrySet)
        {
            System.out.println(entry.getValue()+ "\t" +entry.getKey());
        }
        System.out.println(map);
        for (String k:map.keySet())                                     //   普通迭代方式！！！！！！！！
        {
            System.out.println(map.get(k)+"\t"+k);
        }
    }
}
