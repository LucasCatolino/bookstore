package com.cleancode.bookstore.reportsmanager;

public class SalesReport implements ReportsGenerator {
    @Override
    public void generateReport(String someData){
        System.out.println("Some mocked sales report based on: " + someData);
    }
}
