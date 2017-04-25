package Z26_Binary_Search_tree;

import javafx.scene.control.TreeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

/**
 * Created by Caffrey on 2017/4/23.
 */
public class TreeControl extends JPanel {
    private TreeSet<Integer> tree;
    private JTextField jtfKey = new JTextField();
    private TreeView view= new TreeView();
    private JButton jbtInsert = new JButton();
    private JButton jbtdelete = new JButton();

    public TreeControl(TreeSet<Integer> tree)
    {
        this.tree = tree;
        setUi();
    }

    private void setUi() {
        this.setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(new Label("Enter a key:"));
        panel.add(jtfKey);
        panel.add(jbtdelete);
        panel.add(jbtInsert);
        add(panel,BorderLayout.SOUTH);

        jbtInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(jtfKey.getText());
                if(tree.contains(key))
                {
                    JOptionPane.showMessageDialog(null,key+"is already in the tree");
                }
                else
                {
                    tree.add(key);
             //       view.repaint;
                }
            }
        });

        jbtdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(jtfKey.getText());
                if(!tree.contains(key))
                {
                    JOptionPane.showMessageDialog(null,key+"is not in the tree");
                }
                else
                {
                    tree.remove(key);
                    view.repaint();
                }
            }
        });
    }

    class TreeView extends JPanel{
        private int radius = 20;
        private int vGap = 50;
        protected void paintCompoent(Graphics g)
        {
            super.paintComponent(g);
            if(tree.first()!=null)
            {
            //    displayTree(g, tree.last(),getWidth()/2,30,getWidth()/4);
            }
        }

        private void displayTree(Graphics g, TreeNode root, int x, int y, int hGrap) {
            g.drawOval(x-radius,y-radius,2*radius,2*radius);
            g.drawString(root.element + "",x-6,y+4);
            if(root.left!=null)
            {
                connectLeftChild(g,x-hGrap,y+vGap,x,y);
                displayTree(g,root.left,x-hGrap,y+vGap,hGrap/2);
            }
            if(root.Right!=null)
            {
                connectRightChild(g,x+hGrap,y+vGap,x,y);
                displayTree(g,root.left,x-hGrap,y+vGap,hGrap/2);
            }
        }

        private void connectRightChild(Graphics g, int x1, int y1, int x2, int y2) {

        }

        private void connectLeftChild(Graphics g, int x1, int y1, int x2,int y2) {
            double d = Math.sqrt(vGap*vGap+(x2-x1)*(x2-x1));
            int x11;
        }
    }


}
