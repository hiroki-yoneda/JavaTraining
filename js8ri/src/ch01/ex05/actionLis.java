package js8ri.ch01.ex05;

import java.awt.Button;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;

public class actionLis {
	public static void main(String[] args) {
        JFrame frame = new JFrame("LamdaTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.setVisible(true);

        Button button = new Button();
        button.addActionListener(
            (ActionEvent e)  ->
            {System.out.println("Button is clicked");}
        );
        frame.add(button);
	}
}
