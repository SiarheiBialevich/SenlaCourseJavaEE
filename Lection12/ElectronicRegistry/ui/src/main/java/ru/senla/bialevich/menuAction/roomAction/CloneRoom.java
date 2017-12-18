package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.enums.RoomSection;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CloneRoom extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(CloneRoom.class);


    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        List<Object> objects = new ArrayList<>();
        Integer roomId = InputReader.getInputInt(scanner, "Enter the id of the room you want to clone");
        objects.add(roomId);
        DataPackage dataPackage = new DataPackage("getRoom", roomId);
        Room roomExist = (Room) requestHandler.sendRequest(dataPackage);

        if (roomExist == null) {
            System.out.println("Room not found.");
        } else {
            objects.clear();
            objects.add(roomId);
            dataPackage = new DataPackage("cloneRoom", roomId);
            Room room = (Room) requestHandler.sendRequest(dataPackage);
            String answer = InputReader.getInputString(scanner, "Do you want to change the number? - Y/N");

            if (answer.equals("y")) {

                room.setCapacity(InputReader.getInputInt(scanner, "Enter the capacity"));
                room.setPrice(InputReader.getInputDouble(scanner, "Enter the price"));
                String strSection = InputReader.getInputString(scanner, "Input room section");
                room.setSection(RoomSection.isExist(strSection));
                room.setRating(InputReader.getInputInt(scanner, "Input rating"));
                objects.clear();
                objects.add(room);

                dataPackage = new DataPackage("updateRoom", room);
                requestHandler.sendRequest(dataPackage);
                System.out.println("Room is successful changed.");
            } else {
                System.out.println("Room is clone.");
            }
        }
    }
}
