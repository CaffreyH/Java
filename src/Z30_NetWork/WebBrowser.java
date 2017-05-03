package Z30_NetWork;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Caffrey on 2017/5/2.
 */
public class WebBrowser extends JApplet {
    private JEditorPane jep = new JEditorPane();
    private JLabel jlbURl = new JLabel("URL");
    private JTextField jtfURl= new JTextField();
    private JScrollPane jspViewer = new JScrollPane();
    public void init()
    {
        JPanel jpURL = new JPanel();
        jpURL.setLayout(new BorderLayout());
        jpURL.add(jlbURl,BorderLayout.WEST);
        jpURL.add(jtfURl,BorderLayout.CENTER);
        add(new JScrollPane(jep),BorderLayout.CENTER);
        add(jpURL,BorderLayout.NORTH);
        jep.setEditable(false);
        jep.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                try {
                    jep.setPage(e.getURL());
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.out.println(e1);
                }
            }
        });
        jtfURl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URL url = new URL(jtfURl.getText().trim());
                    jep.setPage(url);
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
