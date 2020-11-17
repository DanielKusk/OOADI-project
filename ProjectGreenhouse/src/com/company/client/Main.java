package com.company.client;

public class Main {

    public static void main(String[] args) {
        try {
            new ClientGUI(new GreenhouseClient("localhost", 5000));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}