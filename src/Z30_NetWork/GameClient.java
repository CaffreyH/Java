package Z30_NetWork;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Caffrey on 2017/5/3.
 */
public class GameClient extends JApplet implements Runnable,GameConstants{
    private boolean myTurn = false;

    private char myToken = ' ';

    private char otherToken = ' ';

    private Cell[][] cell = new Cell[3][3];

    private JLabel jlblTitle = new JLabel();

    private JLabel jlbStatus = new JLabel();

    private int rowSelected;
    private int columnSelected;

    private DataInputStream fromServer;
    private DataOutputStream toServer;

    private boolean continueToPlay = true;
    private boolean waiting = true;

    private boolean isStandAlone = false;
    private String host = "localhost";
    ;public void init()
    {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3,3,0,0));
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
               p.add(cell[i][j] = new Cell(i,j));
            }
        }
        p.setBorder(new LineBorder(Color.black,1));
        jlblTitle.setHorizontalAlignment(JLabel.CENTER);
        jlblTitle.setFont(new Font("SansSerif",Font.BOLD,16));
        jlblTitle.setBorder(new LineBorder(Color.black,1));
        jlbStatus.setBorder(new LineBorder(Color.black,1));

        add(jlblTitle,BorderLayout.NORTH);
        add(p,BorderLayout.CENTER);
        add(jlbStatus,BorderLayout.SOUTH);

        connectToSever();
    }

    private void connectToSever() {
        try {
            Socket socket;
        if(isStandAlone)
        {
            socket = new Socket(host,8002);
        }
        else
        {
            socket = new Socket(getCodeBase().getHost(),8002);
        }
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            int player = fromServer.readInt();
            if(player == PLAYER1)
            {
                myToken = 'X';
                otherToken = 'O';
                jlblTitle.setText("您的棋子为 X  等待玩家加入");

                fromServer.readInt();
                jlbStatus.setText("玩家加入，游戏开始,请下棋");
                myTurn = true;
            }
            else if(player == PLAYER2)
            {
                myToken = 'O';
                otherToken = 'X';
                jlblTitle.setText("您的棋子为 O");
                jlblTitle.setText("等待玩家下棋");
            }
            while(continueToPlay)
            {
                if(player ==PLAYER1)
                {
                    waitForPlayerAction();
                    sendMove();
                    receiveInfoFromServer();
                }
                else if(player == PLAYER2)
                {
                    receiveInfoFromServer();
                    waitForPlayerAction();
                    sendMove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitForPlayerAction() throws InterruptedException {
        while(waiting)
        {
            Thread.sleep(1000);
        }
        waiting = true;
    }

    private void sendMove() throws IOException {
        toServer.writeInt(rowSelected);
        toServer.writeInt(columnSelected);
    }
    private void receiveInfoFromServer() throws IOException {
        int status = fromServer.readInt();
        if(status == PLAYER1_WON)
        {
            continueToPlay = false;
            if(myToken == 'X')
            {
                jlbStatus.setText("I Won! X");
            }
            else if(myToken == 'O')
            {
                jlbStatus.setText("you lost");
                receiveMove();
            }
        }
        else if(status == PLAYER2_WON)
        {
            continueToPlay = false;
            if(myToken == 'O')
            {
                jlbStatus.setText("You lost");
            }
            else if(myToken == 'X')
            {
                jlbStatus.setText("I Won!");
                receiveMove();
            }
        }
        else if(status == DRAW)
        {
            continueToPlay = false;
            jlbStatus.setText("no winner!");
            if(myToken == 'O')
            {
                receiveMove();
            }
        }
        else
        {
            receiveMove();
            jlbStatus.setText("My turn");
            myTurn = true;
        }
    }

    private void receiveMove() throws IOException {
        int row = fromServer.readInt();
        int column = fromServer.readInt();
        cell[row][column].setToken(otherToken);
    }
    private class Cell extends JPanel
    {
        private int row;
        private int column;

        private char token =' ';
        public Cell(int row,int column)
        {
            this.row=row;
            this.column = column;
            setBorder(new LineBorder(Color.black,1));
            addMouseListener(new ClickListener());
        }
        public char getToken()
        {
            return token;
        }
        public void setToken(char c)
        {
            token = c;
            repaint();
        }
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            if(token == 'X')
            {
                g.drawLine(10,10,getWidth()-10,getHeight()-10);
                g.drawLine(getWidth()-10,10,10,getHeight()-10);
            }
            else if(token =='O')
            {
                g.drawOval(10,10,getWidth()-20,getHeight()-20);
            }
        }
        public class ClickListener extends MouseAdapter
        {
            public void mouseClicked(MouseEvent e)
            {
                if( (token ==' ') && myTurn)
                {
                    setToken(myToken);
                    myTurn = false;
                    rowSelected = row;
                    columnSelected = column;
                    jlbStatus.setText("等待对手下棋");
                    waiting = false;
                }
            }
        }
    }
}
