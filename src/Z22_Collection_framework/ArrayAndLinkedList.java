package Z22_Collection_framework;

import java.util.*;

/**
 * Created by Caffrey on 2017/4/6.
 */
public class ArrayAndLinkedList
{
    public static void main(String[] args)
    {
        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);                      //        线性表可以存储相同的元素
         arrayList.add(3);
        arrayList.add(0,10); //        在指定位置添加元素
        System.out.println(arrayList);

        LinkedList<Object> linkedList = new LinkedList<Object>(arrayList);
        linkedList.add(1,"red");
        linkedList.addFirst("green");

        ListIterator<Object> listIterator = linkedList.listIterator();
        while(listIterator.hasNext())
        {
            System.out.print (listIterator.next()+" ");
        }
    }

}
