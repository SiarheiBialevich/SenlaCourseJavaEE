package ru.senla.bialevich.Clinic;

import ru.senla.bialevich.utils.CleanArrays;

import java.util.Arrays;

public class ClinicRunner {

    public void start() {

        Clinic clinic = new Clinic();

        CleanArrays clean = new CleanArrays();

        Doctor doctor = new Doctor("John", "Conner", "Dentist");
        Doctor doctor1 = new Doctor("Sarah", "Connor", "Therapist");

        Patient patient = new Patient("John", "Fool", "caries");
        Patient patient1 = new Patient("Vasia", "Pupkin", "denture");
        Patient patient2 = new Patient("Ivan", "Ivanov", "temperature");

        clinic.addDoctor(doctor);
        clinic.addDoctor(doctor1);

        clinic.addPatient(patient);
        clinic.addPatient(patient1);
        clinic.addPatient(patient2);

        doctor.setPatientsList(patient);
        doctor.setPatientsList(patient1);
        doctor1.setPatientsList(patient2);

        System.out.println(doctor.toString() + "\n" + Arrays.toString(clean.cleanArray(clinic.getAllPatientsByDoctor(doctor))));
        System.out.println();
        System.out.println(doctor1.toString() + "\n" + Arrays.toString(clean.cleanArray(clinic.getAllPatientsByDoctor(doctor))));

        doctor.delPatient(patient1);

        System.out.println();
        System.out.println(doctor.toString() + "\n" + Arrays.toString(clean.cleanArray(clinic.getAllPatientsByDoctor(doctor))));
        System.out.println();
        System.out.println("Total patient by doctor: " + doctor.toString() +  "\n" + clean.cleanArray(clinic.getAllPatientsByDoctor(doctor)).length);

        System.out.println();
        System.out.println(Arrays.toString(clean.cleanArray(clinic.getPatients())));
        System.out.println();
        System.out.println(Arrays.toString(clean.cleanArray(clinic.getDoctors())));

        System.out.println();
        System.out.println("Total patients: " + clinic.getCountPatient());
        System.out.println();
        System.out.println("Total doctors: " + clinic.getCountDoctor());
    }

}

