package Z30_NetWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Caffrey on 2017/5/2.
 */
public class Server extends JFrame {
    private JTextArea jta = new JTextArea();
    public static void main(String[] args)
    {
        new Server();
    }
    public Server(){
        setLayout(new BorderLayout());
        add(new JScrollPane(jta),BorderLayout.CENTER);
        setTitle("Server");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        try {
            int clientno = 1;
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Server start at "+ new Date()+'\n');
            while(true)
            {
                Socket socket = serverSocket.accept();
                jta.append("Starting a new thread for client: "+ clientno+" at "+ new Date()+'\n');
                InetAddress inetAddress = socket.getInetAddress();
                HandleAClient task = new HandleAClient(socket);
                new Thread(task).start();
                clientno++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("端口被占用");
        }
    }

    private class MyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyChar()=='\n')
            {
                jta.append("you are server!"+'\n');
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    class HandleAClient implements Runnable
    {
        private Socket socket;
        public HandleAClient(Socket socket){
            this.socket=socket;
        }
        @Override
        public void run() {
            try {

                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());
                while (true) {
                    double radius = inputFromClient.readDouble();
                    double area = radius * radius * Math.PI;
                    outputToClient.writeDouble(area);
                    jta.append("Radius received from client: " + radius + '\n');
                    jta.append("Area found: " + area + '\n');
                   // jta.append("Client's ip address is: " + inetAddress + '\n');
                    jta.addKeyListener(new MyListener());
                }
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
        }
    }
}
