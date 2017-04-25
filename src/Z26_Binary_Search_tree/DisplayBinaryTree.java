package Z26_Binary_Search_tree;

import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;
import java.util.TreeSet;

/**
 * Created by Caffrey on 2017/4/23.
 */
public class DisplayBinaryTree extends JApplet {
    public DisplayBinaryTree()
    {
        add(new TreeControl(new TreeSet<Integer>()));
    }

}
