package com.company.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//GreenhouseGUI creates the graphical user interface.
class GreenhouseGUI implements ActionListener {
    //GUI graphics attributes.

    //Creates an attribute name for the Client interface
    private final IGreenhouseClient Client;

    //Creates attribute names for JLabel and JTextArea
    //(Needed for the actionPerformed method to work).
    private static JLabel label;
    private final JTextArea outputField;

    //Creates attribute name and a stringArray for a drop down menu/JComboBox
    //(Needed for the actionPerformed method to work).
    private final String[] choice = {"BabyCucumber", "BellPepper", "Grape", "Lemon", "Tomato"};
    private final JComboBox<String> plantType = new JComboBox<>(choice);

    //GUI constructor.
    GreenhouseGUI(IGreenhouseClient client) throws IOException {
        //Creates the frame
        JFrame frame = new JFrame("Greenhouse");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creates frame panels.
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        JPanel feedbackPanel = new JPanel();
        JPanel outputPanel = new JPanel();

        //Adds panels to frame.
        frame.add(buttonPanel);
        frame.add(feedbackPanel);
        frame.add(outputPanel);

        //Creates frame buttons, button action- commands and listeners.
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

        //Adds drop down menu and buttons to the button panel.
        buttonPanel.add(plantType);
        buttonPanel.add(addPlantButton);
        buttonPanel.add(waterPlantsButton);
        buttonPanel.add(getOverviewButton);
        buttonPanel.add(getLogButton);
        buttonPanel.add(nextDay);

        //Creates an instance of JLabel and overrides the attribute, used to give the user feedback from button clicks.
        label = new JLabel();
        label.setBounds(10, 20, 200, 20);

        //Adds the lable to the feedback panel.
        feedbackPanel.add(label);

        //Creates an instance of JTextArea and overrides the attribute.
        outputField = new JTextArea(30, 60);
        //Creates an instance of JScroolPane using the JTextArea instance as argument. Makes the JTextArea scrollable.
        JScrollPane outputPane = new JScrollPane(outputField);
        //Makes sure the user cant write in the JTextArea.
        outputField.setEditable(false);

        //Adds the JScrollPane to the outputPanel.
        outputPanel.add(outputPane);

        //Creates an instance og the client interface.
        Client = client;
        Client.open();
    }

    //Listens for GUI actions.
    @Override
    public void actionPerformed(ActionEvent event) {
        //Creates strings from the GUI action.
        String command = event.getActionCommand();
        String type = (String) plantType.getSelectedItem();

        try {
            //Checks what command to send to the server based on the GUI action.
            switch (command) {
                case "addPlant" -> {
                    //Sends button clicked feedback.
                    label.setText("New " + type + " requested");
                    //Uses the client to send an add plant request to the server
                    //and prints the response in the JTextArea.
                    outputField.setText(Client.addPlant(type));
                }
                case "waterPlants" -> {
                    //Sends button clicked feedback.
                    label.setText("Water plants requested");
                    //Uses the client to send a water plant request to the server
                    //and prints the response in the JTextArea.
                    outputField.setText(Client.waterPlants());
                }
                case "overview" -> {
                    //Sends button clicked feedback.
                    label.setText("Overview requested");
                    //Uses the client to send an overview request to the server
                    //and prints the response in the JTextArea.
                    outputField.setText(Client.getOverview());
                }
                case "log" -> {
                    //Sends button clicked feedback.
                    label.setText("Log:");
                    //Uses the client to send a log request to the server
                    //and prints the response in the JTextArea.
                    outputField.setText(Client.getLog());
                }
                case "nextDay" ->{
                    //Sends button clicked feedback.
                    label.setText("New day");
                    //Uses the client to send a new day request to the server
                    //and prints the response in the JTextArea.
                    outputField.setText(Client.nextDay());
                }
                default -> label.setText("Command not recognised");
            }
        } catch (Exception ex) {
            //Print an error message to the GUI JLabel.
            label.setText(ex.getMessage());
        }
    }
}