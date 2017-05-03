package Z30_NetWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Caffrey on 2017/5/2.
 */
public class CountServer {
    private RandomAccessFile raf;
    private int count;
    public static void main(String[] args)
    {
        new CountServer();
    }
    public CountServer()
    {
        try {
            ServerSocket serverSocket = new ServerSocket(8001);
            System.out.println("Server started");
            raf = new RandomAccessFile("count.dat","rw");
            if(raf.length() == 0)
            {
                count =0;
            }
            else {
                //count = raf.readInt();
            }
            while(true)
            {
                Socket socket = serverSocket.accept();
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                count++;
                outputStream.writeInt(count);
                raf.seek(0);
                raf.write(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
