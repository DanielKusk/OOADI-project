package com.company.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class ClientGUI implements ActionListener {
    private static JLabel label;
    private static JLabel label2;
    private IGreenhouseClient Client;

    ClientGUI(IGreenhouseClient client) throws IOException {
        JFrame frame = new JFrame("Greenhouse");

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        JPanel feedbackPanel = new JPanel();
        JPanel outputPanel = new JPanel();

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
        label.setBounds(10, 110, 200, 20);
        label2 = new JLabel();
        label.setBounds(10, 110, 200, 200);

        frame.add(buttonPanel);
        frame.add(feedbackPanel);
        frame.add(outputPanel);

        buttonPanel.add(button);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        feedbackPanel.add(label);
        outputPanel.add(label2);

        frame.setLayout(new GridLayout(3, 1));
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Client = client;
        Client.open();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String name = event.getActionCommand();

        try {
            switch (name) {
                case "overview" -> {
                    label.setText("Here is the Greenhouse overview");
                    label2.setText(Client.getOverview());
                }
                case "waterplants" -> {
                    label.setText("Plants have been watered");
                    label2.setText(Client.waterPlants());
                }
                case "addplant" -> {
                    label.setText("Plant has been added");
                    label2.setText(Client.addPlant());
                }
                case "log" -> {
                    label.setText("Here is the log:");
                    label2.setText(Client.getLog());
                }
            }
        } catch (Exception ex) {
            label.setText(ex.getMessage());
        }
    }
}