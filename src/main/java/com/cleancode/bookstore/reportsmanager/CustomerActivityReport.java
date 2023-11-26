package com.cleancode.bookstore.reportsmanager;

public class CustomerActivityReport implements ReportsGenerator {

    @Override
    public void generateReport(String someData){
        System.out.println("Some mocked customer activity report based on: " + someData);
    }
}