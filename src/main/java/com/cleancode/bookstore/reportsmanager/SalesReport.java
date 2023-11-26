package com.cleancode.bookstore.reportsmanager;

public class SalesReport implements ReportsGenerator {
    @Override
    public String generateReport(String someData){
        return "Some mocked sales report based on: " + someData;
    }
}
