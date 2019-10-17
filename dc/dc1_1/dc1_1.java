package dc.dc1_1;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;

/* AWT https://www.javatpoint.com/java-awt */
/* https://docs.oracle.com/javase/jp/8/docs/api/java/awt/event/WindowListener.html */
public class dc1_1 extends Frame implements WindowListener, Runnable {

    //private static final long serialVersionUID = 1L;
    static int hour;       // 時
    static int minutes;       // 分
    static int second;       // 秒
    static Thread thread;

    public  dc1_1(String title) {
        super(title);
        addWindowListener(this);
    }

    @Override
    public  void windowOpened(WindowEvent e) {
        // TODO 自動生成されたメソッド・スタブ
    }

    @Override
    public  void windowClosing(WindowEvent e) {
        dispose();
    }

    @Override
    public  void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public  void windowIconified(WindowEvent e) {
        // TODO 自動生成されたメソッド・スタブ
    }

    @Override
    public  void windowDeiconified(WindowEvent e) {
        // TODO 自動生成されたメソッド・スタブ
    }

    @Override
    public  void windowActivated(WindowEvent e) {
        // TODO 自動生成されたメソッド・スタブ
    }

    @Override
    public  void windowDeactivated(WindowEvent e) {
        // TODO 自動生成されたメソッド・スタブ
    }

    @Override
    public  void run() {
        while(true) {
            hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            minutes = Calendar.getInstance().get(Calendar.MINUTE);
            second = Calendar.getInstance().get(Calendar.SECOND);
            repaint();

            try {
                Thread.sleep(1000); // スリープ1秒
            } catch(InterruptedException e) {
            }
        }
    }

    public void paint(Graphics g) {
    	Font font = new Font("ＭＳ Ｐゴシック", Font.PLAIN, 40);
    	g.setFont(font);
        g.drawString(hour+":"+minutes+":"+second, 20, 70);
    }

    public static void main(String[] args) {
    	dc1_1 window = new dc1_1("Digital Clock 1");
        thread = new Thread(window);
        window.setSize(200, 150);
        window.setResizable(false);
        window.setVisible(true);

        thread.start();     // スレッドスタート

    }
}
