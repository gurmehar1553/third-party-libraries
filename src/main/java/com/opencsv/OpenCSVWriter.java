package com.opencsv;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {
    private static final String SAMPLE_CSV_FILE = "G:/GE-work/third-party-lib/src/main/java/com/opencsv/usersNew.csv";

    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
        StatefulBeanToCsvBuilder<CSVUser> beanToCsvBuilder = new StatefulBeanToCsvBuilder<>(writer);
        StatefulBeanToCsv<CSVUser> beanToCsv = beanToCsvBuilder.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();
        List<CSVUser> users = new ArrayList<>();
        users.add(new CSVUser("Sundar Pichai","sundar@gmail.com","+1-11111111111","USA"));
        users.add(new CSVUser("Satya Nadela","satya@gmail.com","+1-11111111111","Canada"));
        beanToCsv.write(users);
        writer.close();
    }
}
