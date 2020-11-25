package com.company.client;

public class Main {
    
    public static void main(String[] args) {
        try {
            //Creates an instance of the GUI and Client.
            new GreenhouseGUI(new GreenhouseClient("localhost", 5000));
        } catch (Exception e) {
            //Prints out error messages.
            System.out.println(e.getMessage());
        }
    }
}
