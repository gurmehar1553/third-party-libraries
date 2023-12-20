package com.gson;

import com.google.gson.Gson;
import com.opencsv.CSVUser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.List;

public class GsonWriter {
    private static final String SAMPLE_CSV_FILE = "G:/GE-work/third-party-lib/src/main/java/com/opencsv/users.csv";
    private static final String SAMPLE_JSON_FILE = "G:/GE-work/third-party-lib/src/main/java/com/gson/users.json";

    /**
     * Reading csv file and writing into json file
     * Reading json file
     * using gson library
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(new FileReader(SAMPLE_CSV_FILE));
        csvToBeanBuilder.withType(CSVUser.class);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
        List<CSVUser> csvUsers = csvToBean.parse();
        Gson gson = new Gson();
        FileWriter writer = new FileWriter(SAMPLE_JSON_FILE);
        gson.toJson(csvUsers,writer);
        writer.close();
        FileReader fileReader = new FileReader(SAMPLE_JSON_FILE);
        CSVUser[] csvUserList = gson.fromJson(fileReader, CSVUser[].class);
        for (CSVUser csvUser : csvUserList){
            System.out.println(csvUser);
        }
    }
}
