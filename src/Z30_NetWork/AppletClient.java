package Z30_NetWork;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Caffrey on 2017/5/2.
 */
public class AppletClient extends JApplet {
    private JLabel jlbCount = new JLabel();
    private boolean isStandAlone = false;

    private String host = "localhost";
    public void init()
    {
        add(jlbCount);
        try {
        Socket socket;
        if(isStandAlone)
        {
            socket = new Socket(host,8001);
        }
        else
        {
            socket = new Socket(getCodeBase().getHost(),8001);
        }
            DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
        int count = inputFromServer.readInt();
        jlbCount.setText("You are vistor number "+ count);
        inputFromServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        JFrame jFrame = new JFrame("Applet Client");
        AppletClient appletClient = new AppletClient();
        appletClient.isStandAlone = true;
        if(args.length ==1 )
        {
            appletClient.host = args[0];
        }
        else
        {
            appletClient.host = "localhost";
        }
        jFrame.getContentPane().add(appletClient, BorderLayout.CENTER);
        appletClient.init();
        appletClient.setVisible(true);
        jFrame.setSize(300,200);
        jFrame.setVisible(true);
        jFrame.pack();
    }
}
