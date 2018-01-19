package com.company;
import engine.*;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        // write your code here

        ParseXML parseXML = new ParseXML();
        ReadData readData = new ReadData();
        IReadData iRead = parseXML;


        try {
            if (!iRead.read("settings.xml")) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error read XML");
            e.printStackTrace();
            return;
        }

        iRead = readData;

        try {
            if (!iRead.read("source-data.tsv")) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error read data");
            e.printStackTrace();
            return;
        }

        GenReports genReports = new GenReports(parseXML, readData, "report.txt");

        try {
            if (!genReports.generationReports()) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error generate reports");
            return;
        }
        System.out.println("Success report generate");
    }
}
