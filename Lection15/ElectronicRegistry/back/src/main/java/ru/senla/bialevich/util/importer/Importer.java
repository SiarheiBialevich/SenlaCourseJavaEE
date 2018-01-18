package ru.senla.bialevich.util.importer;

import org.apache.log4j.Logger;
import ru.senla.bialevich.ClassSetting;
import ru.senla.bialevich.controller.ControllerHotel;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.model.Guest;
import ru.senla.bialevich.model.Registration;
import ru.senla.bialevich.model.Room;
import ru.senla.bialevich.model.Service;
import ru.senla.bialevich.util.converter.api.IConverter;
import ru.senla.bialevich.util.serialization.WriteObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Importer {
    private static final Logger LOG = Logger.getLogger(Importer.class);
    private static final String PATH = ClassSetting.getProps().getPathToFileEntity();

    private IConverter converter;
    private WriteObject wObject = new WriteObject();

    private ControllerHotel hotel;

    public Importer() {
        converter = (IConverter) DependencyInjection.getInjection().getInstance(IConverter.class);
        hotel = (ControllerHotel) DependencyInjection.getInjection().getInstance(ControllerHotel.class);
    }

    public void importGuests(List<Guest> guests) {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                Guest currentGuest = converter.convertStringToGuest(line);
                Guest guest = hotel.getGuest(currentGuest.getId());
                if (guest != null) {
                    hotel.updateGuest(currentGuest);
                } else {
                    hotel.addGuest(currentGuest);
                }
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public void importRooms(List<Room> rooms) {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                Room currentRoom = converter.convertStringToRoom(line);
                Room room = hotel.getRoom(currentRoom.getId());
                if (room != null) {
                    hotel.updateRoom(currentRoom);
                } else {
                    hotel.addRoom(currentRoom);
                }
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    public void importRegistrations(List<Registration> registrations) {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                Registration currentRegistration = converter.convertStringToRegistration(line);
                Registration registration = hotel.getRegistration(currentRegistration.getId());
                if (registration != null) {
                    hotel.updateRegistration(currentRegistration);
                } else {
                    hotel.addRegistration(currentRegistration);
                }
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    public void importServices(List<Service> services) {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                Service currentService = converter.convertStringToService(line);
                Service service = hotel.getService(currentService.getId());
                if (service != null) {
                    hotel.updateService(currentService);
                } else {
                    hotel.addService(currentService);
                }
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}
