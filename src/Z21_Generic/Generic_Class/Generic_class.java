package Z21_Generic.Generic_Class;

/**
 * Created by Caffrey on 2017/4/5.
 */
public class Generic_class<E> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
    public int getSize()
    {
        return list.size();
    }
    public E peak()
    {
        return list.get(getSize()-1);
    }
    public void push(E o)
    {
        list.add(o);
    }
    public E pop()
    {
        E o = list.get(getSize()-1);
        list.remove(getSize()-1);
        return o;
    }
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
}
