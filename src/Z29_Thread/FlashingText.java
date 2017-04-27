package Z29_Thread;

import javax.swing.*;

/**
 * Created by Caffrey on 2017/4/26.
 */
public class FlashingText extends JApplet implements Runnable {
    private JLabel jlbl = new JLabel("Welcome",JLabel.CENTER);

    public FlashingText(){
        add(jlbl);
        new Thread(this).start();
    }
    @Override
    public void  run()
    {
        try
        {
            while (true) {
                if (jlbl.getText() == null) {
                    jlbl.setText("Welcome");
                } else {
                    jlbl.setText(null);
                }
                Thread.sleep(200);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
