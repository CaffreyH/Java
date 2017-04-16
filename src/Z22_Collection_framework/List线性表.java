package Z22_Collection_framework;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Caffrey on 2017/4/6.
 */
public class List线性表 {
    public static void main(String[] args)
    {
        List<Integer> list1 = Arrays.asList(2,4,7,10,11,45,50,59,60,66);
        System.out.println("(1)Index:" + Collections.binarySearch(list1,7));     //      找到返回所在的位置
        System.out.println("(2)Index;" + Collections.binarySearch(list1,9));     //      没有找到返回应该在的位置
        List<String> list2 = Arrays.asList("red","green","blue");
        System.out.println("(3)Index:" + Collections.binarySearch(list2,"green"));
        System.out.println("(4)Index:" + Collections.binarySearch(list2,"cyan"));
        System.out.println(list2);
        Collections.reverse(list2);
        System.out.println(list2);
        Collections.shuffle(list2);                                                     //      对list进行洗牌
        Collections.shuffle(list2, new Random(20));
        String 兔兔 = "蠢蛋";
        System.out.println(兔兔);
    }
}
