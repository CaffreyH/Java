package Z25_List_And_Stack;

/**
 * Created by Caffrey on 2017/4/22.
 */
public class TestList {
    public static void main(String[] args)
    {
        MyList<String> list = new MyArrarList<String>();
        list.add("America");
        System.out.println("(1)  "+ list);

        list.add(0,"Canada");
        System.out.println("(2） "+list);

        list.add("Russia");
        System.out.println("(3） "+list);

        list.add(2,"Germany");
        System.out.println("(4） "+list);

        list.remove("Canada");
        System.out.println("(5） "+list);

        list.remove(2);
        System.out.println("(6） "+list);

        System.out.println("(7） "+list.contains("Russia"));
        System.out.println("(8） "+list.size());
        System.out.println("(9） "+list.get(1));
    }
}
