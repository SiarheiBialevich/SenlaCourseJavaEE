package ru.senla.bialevich.menuAction.roomAction;


import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.menuAction.AbstractAction;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class ChangeRoomStatus extends AbstractAction implements IAction {
    private static final Logger LOG = Logger.getLogger(ChangeRoomStatus.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);

        Integer roomId = InputReader.getInputInt(scanner, "Input room ID: ");
        try {
            DataPackage dataPackage = new DataPackage("getRoom", roomId);
            Room room = (Room) requestHandler.sendRequest(dataPackage);

            if (room == null) {
                System.out.println("Room not found.");
            } else {
                dataPackage = new DataPackage("changeRoomStatus", room);
                boolean truth = (boolean) requestHandler.sendRequest(dataPackage);
                if (!truth) {
                    System.out.println("Can't change room status!");
                } else {
                    System.out.println("Room status is changed.");
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}

