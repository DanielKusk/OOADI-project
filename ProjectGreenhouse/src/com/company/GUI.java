package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GreenhouseGUI extends JFrame implements ActionListener {
    private static JLabel label;

    public static void main(String[] args) {
        new GreenhouseGUI();
    }


    GreenhouseGUI(){

        super("Greenhouse");
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        JPanel buttonPanel = new JPanel(new GridBagLayout());
        JPanel outputPanel = new JPanel();
        JPanel GHPanel = new JPanel();
        JPanel logPanel = new JPanel();
        JPanel plantPanel = new JPanel();

        JButton button = new JButton("Greenhouse overview");
        button.setActionCommand("overview");
        button.addActionListener(this);
        JButton button1 = new JButton("Water plants");
        button1.setActionCommand("waterplants");
        button1.addActionListener(this);
        JButton button2 = new JButton("Add plant");
        button2.setActionCommand("addplant");
        button2.addActionListener(this);
        JButton button3 = new JButton("Log");
        button3.setActionCommand("log");
        button3.addActionListener(this);

        label = new JLabel();
        label.setBounds(10, 110, 200, 100);

        add(buttonPanel);
        add(outputPanel);


        buttonPanel.add(button);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);


        outputPanel.add(label);

        setLayout(new GridLayout(3,1));
        setSize(600,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();

        switch (name) {
            case "overview" -> label.setText("Overview request sent");
            case "waterplants" -> label.setText("Plants have been watered");
            case "addplant" -> label.setText("Plant has been added");
            case "log" -> label.setText("Here is the log:");
        }
    }
}