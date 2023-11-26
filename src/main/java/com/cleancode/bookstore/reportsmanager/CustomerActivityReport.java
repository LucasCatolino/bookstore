package com.cleancode.bookstore.reportsmanager;

public class CustomerActivityReport implements ReportsGenerator {

    @Override
    public String generateReport(String someData){
        return "Some mocked customer activity report based on: " + someData;
    }
}