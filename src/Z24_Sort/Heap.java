package Z24_Sort;

import java.util.ArrayList;

/**
 * Created by Caffrey on 2017/4/13.
 */
public class Heap <E extends Comparable>                    //堆排序的时间复杂度为O（logn);
{
    public ArrayList<E> list = new ArrayList<E>();

    public Heap(){
    }
    public Heap(E[] objects)
    {
        for(int i=0;i<objects.length;i++)
        {
            add(objects[i]);
        }
    }

    public void add(E newObject)                               //负责将新的元素加入堆栈
    {
        list.add(newObject);
        int currentIndex = list.size() -1;                       // 直接把新的元素放到最后
        while(currentIndex >0)
        {
            int parentIndex = (currentIndex -1 ) /2;
            if(list.get(currentIndex).compareTo(                //拿新加入的元素不断地跟他的父结点比较，如果新的元素更打就交换
                    list.get(parentIndex)) >0)
            {
                E temp = list.get(currentIndex);
                list.set(currentIndex,list.get(parentIndex));
                list.set(parentIndex,temp);
            }
            else
            {
                break;
            }
            currentIndex = parentIndex;
        }
    }
    public E remove()                                            // 用来将数据从堆栈中取出
    {
        if(list.size() == 0)
        {
            return null;
        }
        E removedObject = list.get(0);
        list.set(0,list.get(list.size()-1));                   //将根节点的值设置为 最后一个元素的值,并返回原本的值
        list.remove(list.size()-1);                     //删除最后一个结点、
        int currentIndex = 0;
        while(currentIndex < list.size())
        {
            int leftChildIndex = 2 * currentIndex + 1;          //左右结点的编号
            int rightChildIndex = 2 * currentIndex + 2;
            if(leftChildIndex >= list.size())
            {
                break;                                          //遍历完了
            }
            int maxIndex = leftChildIndex;
            if(rightChildIndex < list.size())
            {
                if(list.get(maxIndex).compareTo(
                        list.get(rightChildIndex)) < 0)            //右结点更大，更新
                {
                    maxIndex = rightChildIndex;
                }
            }
            if(list.get(currentIndex).compareTo(
                    list.get(maxIndex)) < 0)
            {
                E temp = list.get(maxIndex);
                list.set(maxIndex,list.get(currentIndex));         //交换
                list.set(currentIndex,temp);
                currentIndex = maxIndex;
            }
            else
            {
                break;
            }
        }
        return removedObject;
    }
    public int getSie()
    {
        return list.size();
    }

}
