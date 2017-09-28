package ru.senla.bialevich.runner;

import ru.senla.bialevich.worker.RegistryWorker;

public class Run {
    public static void main(String[] args) throws Exception {
        RegistryWorker registryWorker = new RegistryWorker();

        registryWorker.start();
    }

}
