package ru.senla.bialevich.util;

import com.danco.training.TextFileWorker;
import org.apache.log4j.Logger;
import ru.senla.bialevich.entity.UsedService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadServiceFromFile implements ReadEntityFromCsv<UsedService> {
    private String line = "";
    private String csvSplitBy = ",";
    private List<UsedService> services = new ArrayList<>();
    private String[] strings;
    private TextFileWorker fileWorker;
    private Logger log = org.apache.log4j.Logger.getLogger(ReadServiceFromFile.class);

    private Integer num;
    private Float num4;

    @Override
    public List<UsedService> read(String file) {

        fileWorker = new TextFileWorker(file);

        strings = fileWorker.readFromFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                strings = line.split(csvSplitBy);
                num = Integer.parseInt(strings[2].trim());
                num4 = Float.parseFloat(strings[6].trim());


                services.add(new UsedService(num, strings[4].trim(), num4));

            }
        } catch (IOException e) {
            log.error("Failed to create list services", e);
        }

        return services;
    }
}
