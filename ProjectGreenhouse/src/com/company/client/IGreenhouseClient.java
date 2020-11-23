package com.company.client;

import java.io.IOException;

public interface IGreenhouseClient {
    void open() throws IOException;

    void close();

    String writeCommand(String msg) throws IOException;

    String addPlant(String type, String stage) throws IOException;

    String waterPlants() throws IOException;

    String getOverview() throws IOException;

    String getLog() throws IOException;

    String nextDay() throws IOException;
}
