package Z25_List_And_Stack;

/**
 * Created by Caffrey on 2017/4/22.
 */
public class MyLinkedList<E> {
    private Node<E> head,tail;
    int size = 0;
    public MyLinkedList(){

    }
    public MyLinkedList(E[] objects)
    {
       // super(objects);
    }

    public E getFirst()
    {
        if(size == 0)
            return null;
        else
            return head.element;
    }
    public E getLast()
    {
        if(size == 0)
            return null;
        else
            return tail.element;
    }
    public void addFirst(E e)
    {
        Node<E> newNode = new Node<E>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if(tail == null)
        {
            tail = head;
        }
    }
    public void addLast(E e)
    {
        Node<E> newNode = new Node<E>(e);
        if(tail == null)
        {
            head = tail =newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void add(int index,E e)
    {
        if(index == 0)
        {
            addFirst(e);
        }
        else if(index >= size)
        {
            addLast(e);
        }
        else
        {
            Node<E> current = head;
            for(int i=1;i<index;i++)
            {
                current = current.next;                //找到插入新元素的位置
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size ++;
        }
    }
    public E removeFirst()
    {
        if(size == 0)
        {
            return null;
        }
        else if(size == 1)
        {
            head = head.next;
            tail = null;
            size --;
            return head.element;
        }
        else
        {
            head = head.next;
            size--;
            return head.element;
        }
    }
    private E removeLast() {
        if(size ==0)
        {
            return null;
        }
        else if(size==1)
        {
            Node<E> temp = head;
            head = tail  =null;
            size = 0;
            return temp.element;
        }
        else{
            Node<E> current = head;
            for(int i=0;i<size-3;i++)
            {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }

    }
    public E remove(int index)
    {
        if(index < 0 || index >=size)
            return null;
        else if(index == 0)
        {
            return removeFirst();
        }
        else if(index ==size-1)
        {
            return removeLast();
        }
        else
        {
            Node<E> previous = head;
            for(int i =1;i<index;i++)
            {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }
    public int getSize()
    {
        return size;
    }
    public void show()
    {
        Node current = head;
        while(current!=null)
        {
            System.out.println(current.element);
            current = current.next;
        }
    }
}
