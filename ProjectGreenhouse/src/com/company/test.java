package javatutorial.net;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class MyProgram {
    public static void main(String args[]) {
        final JFrame myJFrame = new JFrame("Tax Program");
        final JPanel panel = new JPanel();
        final Container cp = myJFrame.getContentPane();
        JButton button1 = new JButton("First window");
        JButton button2 = new JButton("Second window");
        JButton button3 = new JButton("button 3");
        JButton button4 = new JButton("button 4");
        JButton button5 = new JButton("button 5");
        panel.setLayout(new GridLayout(5,1));
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //myJFrame.setVisible(false);
                cp.removeAll();
                myJFrame.setSize(700,400);
                JPanel Panel1 = new JPanel();
                cp.add(Panel1);
                cp.validate();
            }
        };
        ActionListener al_2 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cp.removeAll();
                myJFrame.setSize(700,600);
                JPanel Panel2 = new JPanel();
                cp.add(Panel2);
                cp.validate();
            }
        };
        button1.addActionListener(al);
        button2.addActionListener(al_2);
        cp.add(panel);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        myJFrame.setSize(600,600);
        //Puts the window in the middle of the screen.
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setVisible(true);
    }
}
