package ru.senla.bialevich.util;

import com.danco.training.TextFileWorker;
import org.apache.log4j.Logger;
import ru.senla.bialevich.entity.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadRoomFromFile implements ReadEntityFromCsv<Room> {
    private String line = "";
    private String csvSplitBy = ",";
    private List<Room> rooms = new ArrayList<>();
    private String[] strings;
    private TextFileWorker fileWorker;

    private Logger log = org.apache.log4j.Logger.getLogger(ReadRoomFromFile.class);

    private Integer num;
    private Integer num1;
    private Integer num2;
    private Integer num3;
    private Float num4;

    @Override
    public List<Room> read(String file) {

        fileWorker = new TextFileWorker(file);

        strings = fileWorker.readFromFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                strings = line.split(csvSplitBy);
                num = Integer.parseInt(strings[2].trim());
                num1 = Integer.parseInt(strings[4].trim());
                num2 = Integer.parseInt(strings[6].trim());
                num3 = Integer.parseInt(strings[8].trim());
                num4 = Float.parseFloat(strings[12].trim());

                rooms.add(new Room(num, num1, num2, num3, num4));

            }
        } catch (IOException e) {
            log.error("Failed to create list room", e);
        }

        return rooms;
    }
}
