package ru.senla.bialevich.menuAction;

import ru.senla.bialevich.menuItems.Builder;
import ru.senla.bialevich.api.IAction;

public class GuestMenu implements IAction {
    private Builder builder = new Builder();

    @Override
    public void execute() {
        builder.GuestMenu();
    }
}
