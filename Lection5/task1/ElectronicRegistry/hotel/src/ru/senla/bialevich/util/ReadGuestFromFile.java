package ru.senla.bialevich.util;

import com.danco.training.TextFileWorker;
import org.apache.log4j.Logger;
import ru.senla.bialevich.entity.Guest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadGuestFromFile implements ReadEntityFromCsv<Guest> {
    private TextFileWorker fileWorker;
    private String line = "";
    private String csvSplitBy = ",";
    private Guest guest;
    private List<Guest> guests = new ArrayList<>();
    private String[] strings;

    private Logger log = Logger.getLogger(ReadGuestFromFile.class);


    @Override
    public List<Guest> read(String file) {

        Integer num;

        fileWorker = new TextFileWorker(file);

        strings = fileWorker.readFromFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                strings = line.split(csvSplitBy);

                num = Integer.parseInt(strings[2]);

                guests.add(guest = new Guest(num, strings[4], strings[6]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return guests;
    }
}
