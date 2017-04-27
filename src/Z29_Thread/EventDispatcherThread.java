package Z29_Thread;

import javax.swing.*;

/**
 * Created by Caffrey on 2017/4/26.
 */
public class EventDispatcherThread extends JApplet {
    public EventDispatcherThread()
    {
        add(new JLabel("Hi,it runs from an event dispatch thread "));
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()                                 //GUI中使用invoke进行时间分发
        {
            @Override
            public void run() {
                JFrame frame = new JFrame("EvenDispatchThread");
                frame.add(new EventDispatcherThread());
                frame.setSize(400,300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
