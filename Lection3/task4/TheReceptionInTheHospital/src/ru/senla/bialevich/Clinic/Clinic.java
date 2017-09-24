package ru.senla.bialevich.Clinic;

public class Clinic {
    private Integer countDoctor = 0;
    private Integer countPatient = 0;
    private Patient[] patients = new Patient[50];
    private Doctor[] doctors = new Doctor[50];

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    public Integer getCountDoctor() {
        return countDoctor;
    }

    public Integer getCountPatient() {
        return countPatient;
    }

    public void addDoctor(Doctor doctor) {
        doctors[countDoctor] = doctor;
        countDoctor++;
    }

    public void addPatient(Patient patient) {
        patients[countPatient] = patient;
        countPatient++;
    }

    public Patient[] getAllPatientsByDoctor(Doctor doctor) {

        return doctor.getPatientsList();
    }
}
