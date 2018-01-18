package ru.senla.bialevich.menuAction.orderAction;

import org.apache.log4j.Logger;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.request.src.ru.senla.bialevich.DataPackage;
import ru.senla.bialevich.request.src.ru.senla.bialevich.IRequestHandler;
import ru.senla.bialevich.ui.IAction;
import ru.senla.bialevich.util.InputReader;
import java.util.Date;
import java.util.Scanner;

public class AddRegistration implements IAction {
    private static final Logger log = Logger.getLogger(AddRegistration.class);

    @Override
    public void execute(IRequestHandler requestHandler) {
        Scanner scanner = new Scanner(System.in);

        try {
            Integer guestId = InputReader.getInputInt(scanner, "Enter the guest ID.");
            Integer roomId = InputReader.getInputInt(scanner, "Enter the room ID.");

            Date dateOfArrival = InputReader.getInputDate(scanner, "Enter the date of arrival (format dd/MM/yyyy).");
            Date dateOfDeparture = InputReader.getInputDate(scanner, "Enter the date of departure (format dd/MM/yyyy).");

            Registration registration = new Registration(guestId, roomId, dateOfArrival, dateOfDeparture);

            DataPackage dataPackage = new DataPackage("addOrder", registration);
            requestHandler.sendRequest(dataPackage);

            System.out.println("Registration created.");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
