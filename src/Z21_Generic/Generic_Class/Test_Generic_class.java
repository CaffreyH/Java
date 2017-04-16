package Z21_Generic.Generic_Class;

/**
 * Created by Caffrey on 2017/4/5.
 */
public class Test_Generic_class {
    public static void main(String[] args)
    {
        Generic_class<Integer> test = new Generic_class<Integer>();//    <<-----------------注意创建泛型类的方法------------------->>
        test.push(1);
        test.push(2);
        System.out.print( test.pop());
        System.out.print(test.getSize());
        System.out.print(test.isEmpty());
    }

}
