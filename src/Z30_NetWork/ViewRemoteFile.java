package Z30_NetWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Caffrey on 2017/5/2.
 */
public class ViewRemoteFile extends JApplet{
    private JButton jbtView = new JButton("View");
    private JTextField jtfURL = new JTextField(12);
    private JTextArea jtaFile = new JTextArea();
    private JLabel jlbStatus = new JLabel();

    public void init()
    {
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(new JLabel("Filename"),BorderLayout.WEST);
        p1.add(jtfURL,BorderLayout.CENTER);
        p1.add(jbtView,BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(new JScrollPane(jtaFile),BorderLayout.CENTER);
        add(jlbStatus,BorderLayout.SOUTH);
        jbtView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFile();
            }
        });
    }

    private void showFile() {
        java.util.Scanner input = null;
        URL url = null;
        try {
            url = new URL(jtfURL.getText().trim());
            input = new java.util.Scanner(url.openStream());
            while(input.hasNext())
            {
                jtaFile.append(input.nextLine()+'\n');
            }
            jlbStatus.setText("file loaded successfully");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(input!=null)
            {
                input.close();
            }
        }

    }
}
