package ru.senla.bialevich.invoker;


import org.apache.log4j.Logger;
import ru.senla.bialevich.dependency.DependencyInjection;
import ru.senla.bialevich.api.controller.ControllerHotel;

import java.lang.reflect.InvocationTargetException;

public class MethodInvoker {
    private static final Logger LOG = Logger.getLogger(MethodInvoker.class);

    public static Object invokeMethod(String methodName, Object params) {
        ControllerHotel hotel = (ControllerHotel) DependencyInjection.getInjection().getInstance(ControllerHotel.class);
        Object answer = null;

        try {
            if (params != null) {
                answer = hotel.getClass().getMethod(methodName, Object.class).invoke(hotel, params);
            } else {
                answer = hotel.getClass().getMethod(methodName, new Class[]{}).invoke(hotel);
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOG.error(e.getCause().getMessage(), e);
        }

        return answer;
    }
}
