package ru.senla.bialevich.Clinic;

public class Doctor extends AbstractMan {
    private String specialization;
    private Patient[] patientsList = new Patient[25];
    private Integer count = 0;

    public Doctor(String name, String surname, String specialization) {
        super(name, surname);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void delPatient(Patient patient) {
        for (int i = 0; i < patientsList.length; i++) {
            if (patientsList[i] == patient) {
                patientsList[i] = null;
            }
        }
    }

    public Patient[] getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(Patient patient) {
        patientsList[count] = patient;
        count++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Doctor{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append("specialization='").append(specialization).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
