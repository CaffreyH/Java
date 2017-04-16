package Z22_Collection_framework;

import java.util.Vector;

/**
 * Created by Caffrey on 2017/4/6.
 */
public class TestVector {
    public static void main(String[] args)
    {
        Vector vector = new Vector();
        System.out.println(vector.capacity());
        vector.addElement(9);
        System.out.println(vector.lastElement());
        vector.setSize(20);
        System.out.println(vector.capacity());
    }
}
