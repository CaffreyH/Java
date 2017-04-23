package Z25_List_And_Stack;
import java.util.Queue;
import java.util.Stack;
/**
 * Created by Caffrey on 2017/4/22.
 */
public class StackQueue {
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();
        stack.push("Tom");
        stack.push("Geoge");
        stack.push("Michael");
        System.out.println(stack);
        System.out.println(stack.pop());
    }
}
