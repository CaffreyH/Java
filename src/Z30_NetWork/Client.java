package Z30_NetWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Caffrey on 2017/5/2.
 */
public class Client extends JFrame {
    private JTextArea jta = new JTextArea();
    private JTextField jtf = new JTextField();
    private DataOutputStream toServer;
    private DataInputStream fromServer;
    public static void main(String[] args)
    {
        new Client();
    }
    public Client()
    {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(new JLabel("Enter radius"),BorderLayout.WEST);
        p.add(jtf,BorderLayout.CENTER);
        jtf.setHorizontalAlignment(JTextField.RIGHT);
        setLayout(new BorderLayout());
        add(p,BorderLayout.NORTH);
        add(new JScrollPane(jta),BorderLayout.CENTER);
        jtf.addActionListener(new TextFieldListener());
        setTitle("Client");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(
                    socket.getInputStream());
            toServer = new DataOutputStream(
                    socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
            jta.append(e.toString()+"\n");
        }
    }
    private class TextFieldListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            double radius = Double.parseDouble(jtf.getText().trim());
            try {
                toServer.writeDouble(radius);
                toServer.flush();
                double area  =  fromServer.readDouble();
                jta.append("Radius is "+ radius+'\n');
                jta.append("Area received from the server"+area+'\n');
                jtf.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
