package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cli implements ActionListener {
    private static JLabel label;
    private static JLabel label2;
    private Socket sock;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    public Cli() throws UnknownHostException, IOException {
        sock = new Socket("127.0.0.1", 5000);
        in = new DataInputStream(sock.getInputStream());
        out = new DataOutputStream(sock.getOutputStream());
    }

    public void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            label2.setText(String.valueOf(in));
        } catch (Exception ignored) {
        }
    }

    public void createGUI() {
        JFrame frame = new JFrame("Greenhouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        frame.setLayout(new GridLayout(3,1));
        frame.setSize(600,600);
        frame.setVisible(true);
    }

    public void startMyGame() throws IOException {
        createGUI();
    }

    private void close() throws IOException {
        this.sock.close();
        this.in.close();
        this.out.close();
    }

    public static void main(String args[]) {

    }

    @Override
    public void actionPerformed(ActionEvent e){
        String name = e.getActionCommand();

        switch (name) {
            case "overview" -> {
                label.setText("Overview request sent");
                sendMessage("Overview request sent");
            }
            case "waterplants" -> {
                label.setText("Plants have been watered");
                sendMessage("Overview request sent");
            }
            case "addplant" -> {
                label.setText("Plant has been added");
                sendMessage("Plants watered");
            }
            case "log" -> {
                label.setText("Here is the log:");
                sendMessage("Over");
            }
        }
    }
}
