package com.company.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class GreenhouseGUI implements ActionListener {
    private static JLabel label;
    private final JTextArea outputField;
    private final IGreenhouseClient Client;

    private final String[] choice = {"BabyCucumber", "BellPepper", "Grape", "Lemon", "Tomato"};
    private final JComboBox<String> plantType = new JComboBox<>(choice);

    GreenhouseGUI(IGreenhouseClient client) throws IOException {
        JFrame frame = new JFrame("Greenhouse");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        JPanel feedbackPanel = new JPanel();
        JPanel outputPanel = new JPanel();

        frame.add(buttonPanel);
        frame.add(feedbackPanel);
        frame.add(outputPanel);

        JButton addPlantButton = new JButton("Add plant");
        addPlantButton.setActionCommand("addPlant");
        addPlantButton.addActionListener(this);

        JButton waterPlantsButton = new JButton("Water plants");
        waterPlantsButton.setActionCommand("waterPlants");
        waterPlantsButton.addActionListener(this);

        JButton getOverviewButton = new JButton("Plant overview");
        getOverviewButton.setActionCommand("overview");
        getOverviewButton.addActionListener(this);

        JButton getLogButton = new JButton("Log");
        getLogButton.setActionCommand("log");
        getLogButton.addActionListener(this);

        JButton nextDay = new JButton("Next day");
        nextDay.setActionCommand("nextDay");
        nextDay.addActionListener(this);

        buttonPanel.add(plantType);
        buttonPanel.add(addPlantButton);
        buttonPanel.add(waterPlantsButton);
        buttonPanel.add(getOverviewButton);
        buttonPanel.add(getLogButton);
        buttonPanel.add(nextDay);

        label = new JLabel();
        label.setBounds(10, 20, 200, 20);

        feedbackPanel.add(label);

        outputField = new JTextArea(30, 60);
        JScrollPane outputPane = new JScrollPane(outputField);
        outputField.setEditable(false);
        outputPanel.add(outputPane);
        Client = client;
        Client.open();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        String type = (String) plantType.getSelectedItem();


        try {
            switch (command) {
                case "addPlant" -> {
                    label.setText("new " + type + " requested");
                    outputField.setText(Client.addPlant(type));
                }
                case "waterPlants" -> {
                    label.setText("Water plants requested");
                    outputField.setText(Client.waterPlants());
                }
                case "overview" -> {
                    label.setText("Overview requested");
                    outputField.setText(Client.getOverview());
                }
                case "log" -> {
                    label.setText("Log:");
                    outputField.setText(Client.getLog());
                }
                case "nextDay" ->{
                    label.setText("New day");
                    outputField.setText(Client.nextDay());
                }
                default -> label.setText("Command not recognised");
            }
        } catch (Exception ex) {
            label.setText(ex.getMessage());
        }
    }
}