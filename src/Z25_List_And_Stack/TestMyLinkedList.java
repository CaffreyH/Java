package Z25_List_And_Stack;

/**
 * Created by Caffrey on 2017/4/22.
 */
public class TestMyLinkedList {
    public static void main(String[] args)
    {
        MyLinkedList mylist = new MyLinkedList<Integer>();
        mylist.addFirst(1);
        mylist.add(2,2);
        System.out.println(mylist.getSize());
        System.out.println(mylist.getFirst());
        mylist.show();
        mylist.removeFirst();
        mylist.show();
    }
}
