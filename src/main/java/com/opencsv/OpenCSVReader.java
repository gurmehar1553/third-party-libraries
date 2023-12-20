package com.opencsv;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class OpenCSVReader {
    private static final String SAMPLE_CSV_FILE = "G:/GE-work/third-party-lib/src/main/java/com/opencsv/users.csv";

    public static void main(String[] args) throws IOException, CsvException {
        // Read csv file into string array
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE));
        CSVReader csvReader = new CSVReader(reader);
        String[] nextRecord;
        while((nextRecord=csvReader.readNext())!=null){
            System.out.println("Name : "+nextRecord[0]);
            System.out.println("Email : "+nextRecord[1]);
            System.out.println("Phone : "+nextRecord[2]);
            System.out.println("Country : "+nextRecord[3]);
            System.out.println("====================");
        }

        // Read all records at once into a List<String[]>
        List<String[]> records = csvReader.readAll();
        for (String[] record : records){
            System.out.println("Name : "+record[0]);
            System.out.println("Email : "+record[1]);
            System.out.println("Phone : "+record[2]);
            System.out.println("Country : "+record[3]);
        }
    }
}
