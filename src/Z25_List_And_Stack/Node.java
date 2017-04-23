package Z25_List_And_Stack;

/**
 * Created by Caffrey on 2017/4/22.
 */
public class Node<E> {
    E element;
    Node<E> next;

    public Node(E e)
    {
        element = e;
        Node<E> tail = null;
    }
}
