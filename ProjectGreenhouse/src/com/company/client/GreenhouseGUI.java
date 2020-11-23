package com.company.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class GreenhouseGUI implements ActionListener {
    private static JLabel label;
    private static JLabel label2;
    private final IGreenhouseClient Client;

    private final String[] choice = {"BabyCucumber", "BellPepper", "Grape", "Lemon", "Tomato"};
    private final JComboBox<String> plantType = new JComboBox<>(choice);

    private final String[] stage = {"0", "1", "2", "3", "4", "5"};
    private final JComboBox<String> plantStage = new JComboBox<>(stage);

    GreenhouseGUI(IGreenhouseClient client) throws IOException {
        JFrame frame = new JFrame("Greenhouse");

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        JPanel feedbackPanel = new JPanel();
        JPanel outputPanel = new JPanel();

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

        label = new JLabel();
        label.setBounds(10, 110, 200, 20);
        label2 = new JLabel();
        label.setBounds(10, 110, 200, 200);

        frame.add(buttonPanel);
        frame.add(feedbackPanel);
        frame.add(outputPanel);

        buttonPanel.add(plantType);
        buttonPanel.add(plantStage);
        buttonPanel.add(addPlantButton);
        buttonPanel.add(waterPlantsButton);
        buttonPanel.add(getOverviewButton);
        buttonPanel.add(getLogButton);
        buttonPanel.add(nextDay);

        feedbackPanel.add(label);
        outputPanel.add(label2);

        frame.setLayout(new GridLayout(3, 1));
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Client = client;
        Client.open();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        String type = (String) plantType.getSelectedItem();
        String stage = (String) plantStage.getSelectedItem();


        try {
            switch (command) {
                case "addPlant" -> {
                    label.setText("new " + type + " requested");
                    label2.setText(Client.addPlant(type, stage));
                }
                case "waterPlants" -> {
                    label.setText("Water plants requested");
                    label2.setText(Client.waterPlants());
                }
                case "overview" -> {
                    label.setText("Overview requested");
                    label2.setText(Client.getOverview());
                }
                case "log" -> {
                    label.setText("Log:");
                    label2.setText(Client.getLog());
                }
                case "nextDay" ->{
                    label.setText("New day");
                    label2.setText(Client.nextDay());
                }
                default -> label.setText("Command not recognised");
            }
        } catch (Exception ex) {
            label.setText(ex.getMessage());
        }
    }
}