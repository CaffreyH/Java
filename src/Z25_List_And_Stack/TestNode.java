package Z25_List_And_Stack;
/**
 * Created by Caffrey on 2017/4/22.
 */
public class TestNode {
    public static void main(String[] args)
    {
        Node<String> head = null;                   //创建头尾结点
        Node<String> tail = null;

        head = new Node<>("Chicago");             //添加第一个结点
        tail = head;

        tail.next = new Node<>("Denver");          //添加第二个结点
        tail = tail.next;

        tail.next = new Node<>("Dallas");
        tail = tail.next;

        Node current = head;
        while(current!=null)
        {
            System.out.println(current.element);
            current = current.next;
        }
    }
}
