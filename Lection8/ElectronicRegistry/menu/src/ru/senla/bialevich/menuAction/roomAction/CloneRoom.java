package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.entity.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.util.InputReader;
import ru.senla.bialevich.util.Printer;

import java.util.Scanner;

public class CloneRoom extends AbstractAction implements IAction {
    private static final Logger log = Logger.getLogger(CloneRoom.class);
    private Printer printer = new Printer();


    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);
        Integer roomId = InputReader.getInputInt(scanner, "Enter the id of the room you want to clone");
        DataPackage dataPackage = new DataPackage("getRoom", roomId);
        Room roomExist = (Room) requestHandler.sendRequest(dataPackage);

        if (roomExist == null) {
            printer.print("Room not found.");
        } else {
            dataPackage = new DataPackage("cloneRoom", roomId);
            Room room = (Room) requestHandler.sendRequest(dataPackage);
            String answer = InputReader.getInputString(scanner, "Do you want to change the number? - Y/N");

            if (answer.equals("y")) {

                room.setRoomNumber(InputReader.getInputInt(scanner, "Enter the room number"));
                room.setCountStars(InputReader.getInputInt(scanner, "Enter the count stars"));
                room.setCapacity(InputReader.getInputInt(scanner, "Enter the capacity"));
                room.setPrice(InputReader.getInputFloat(scanner, "Enter the price"));

                dataPackage = new DataPackage("updateRoom", room);
                requestHandler.sendRequest(dataPackage);
                printer.print("Room is successful changed.");
            } else {
                printer.print("Room is clone.");
            }
        }
    }
}
