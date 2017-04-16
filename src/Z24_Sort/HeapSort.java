package Z24_Sort;

/**
 * Created by Caffrey on 2017/4/13.
 */
public class HeapSort {
    public static <E extends Comparable> void heapSort(E[] list)
    {
        Heap<E> heap = new Heap<E>();                          //创建对象，用来使用堆栈
        for(int i=0;i<list.length;i++)
        {
            heap.add(list[i]);
        }
        for(int i = list.length-1;i>=0;i--)
        {
            list[i] = heap.remove();
        }
    }
    public static void main(String[] args)
    {
        Integer[] list = {2,3,2,5,6,1,-2,3,14,12};
        heapSort(list);
        for(int i:list)
        {
            System.out.print(i+" ");
        }
    }
}
