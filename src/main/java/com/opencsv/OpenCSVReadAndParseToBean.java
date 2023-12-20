package com.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCSVReadAndParseToBean {
    private static final String SAMPLE_CSV_FILE = "G:/GE-work/third-party-lib/src/main/java/com/opencsv/users.csv";

    public static void main(String[] args) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE));
        CsvToBean<Object> csvToBean = new CsvToBeanBuilder<>(reader)
                .withType(CSVUser.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        Iterator<Object> csvUserIterator = csvToBean.iterator();
        while (csvUserIterator.hasNext()){
            CSVUser csvUser = (CSVUser) csvUserIterator.next();
            System.out.println("Name : "+csvUser.getName());
            System.out.println("Email : "+csvUser.getEmail());
            System.out.println("Phone : "+csvUser.getPhoneNo());
            System.out.println("Country : "+csvUser.getCountry());
            System.out.println("====================");
        }
    }
}
