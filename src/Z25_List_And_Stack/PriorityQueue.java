package Z25_List_And_Stack;

import Z24_Sort.Heap;

/**
 * Created by Caffrey on 2017/4/22.
 */
public class PriorityQueue<E extends Comparable> {
    private Heap<E> heap = new Heap<E>();
    public void enqueue(E newObject)
    {
        heap.add(newObject);
    }
    public E dequeue()
    {
        return heap.remove();
    }
    public int getSize()
    {
        return heap.getSie();
    }
}
