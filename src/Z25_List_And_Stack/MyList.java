package Z25_List_And_Stack;

/**
 * Created by Caffrey on 2017/4/20.
 */
public interface MyList<E> {
    public void add(E e);
    public void add(int index,E e);
    public void clear();
    public boolean contains(E e);
    public E get (int index);
    public int indexOf(E e);
    public boolean isEmpty();
    public int lastIndexOf(E e);
    public boolean remove(E e);
    public E remove(int index);
    public int size();
}
