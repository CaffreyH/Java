package Z21_Generic.Generic_method;

/**
 * Created by Caffrey on 2017/4/5.
 */
public class Generic_method {
    public static void main(String[] args)
    {
        Integer[] integers = {1,2,3,4};
        int[] ints = {5,6,7,8};
        String[] strings = {"London","Paris","Beijing","New York","Austin"};
        print(integers);         //直接调用抽象方法
        Generic_method.<String>print(strings);  //  使用类名+方法名调用方法时，需要指定类型
        Generic_method.<String>print(strings);

    }
    public static <E> void print(E[] list)
    {
        for(int i=0;i<list.length;i++)
        {
            System.out.print(list[i]+" ");
            System.out.println();
        }

    }
}
