package ru.senla.bialevich.menuAction.roomAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.api.IAction;
import ru.senla.bialevich.controller.ControllerHotelImpl;
import ru.senla.bialevich.util.InputReader;

import java.util.Scanner;

public class AddServiceToRoom implements IAction {
    private static final Logger log = Logger.getLogger(AddServiceToRoom.class);

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        try {
            Integer idRoom = InputReader.getInputInt(scanner, "Enter ID the room.");
            Integer idService = InputReader.getInputInt(scanner, "Enter ID the used service.");
            ControllerHotelImpl.getInstance().setServiceToRoom(ControllerHotelImpl.getInstance().getRoomById(idRoom),
                    ControllerHotelImpl.getInstance().getServiceById(idService));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
