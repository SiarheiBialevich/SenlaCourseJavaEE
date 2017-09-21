package ru.senla.bialevich.Clinic;

public class Clinic {
    private Integer countDoctor = 0;
    private Integer countPatient = 0;
    private Patient[] patients = new Patient[50];
    private Doctor[] doctors = new Doctor[50];

    Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    Integer getCountDoctor() {
        return countDoctor;
    }

    Integer getCountPatient() {
        return countPatient;
    }

    void addDoctor(Doctor doctor) {
        doctors[countDoctor] = doctor;
        countDoctor++;
    }

    void addPatient(Patient patient) {
        patients[countPatient] = patient;
        countPatient++;
    }

    Patient[] getAllPatientsByDoctor(Doctor doctor) {

        return doctor.getPatientsList();
    }
}
