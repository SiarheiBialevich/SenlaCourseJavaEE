package ru.senla.bialevich.Clinic;

public class Doctor extends AbstractMan {
    private String specialization;
    private Patient[] patientsList = new Patient[25];
    private Integer count = 0;

    Doctor(String name, String surname, String specialization) {
        super(name, surname);
        this.specialization = specialization;
    }

    String getSpecialization() {
        return specialization;
    }

    void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    void delPatient(Patient patient) {
        for (int i = 0; i < patientsList.length; i++) {
            if (patientsList[i] == patient) {
                patientsList[i] = null;
            }
        }
    }

    Patient[] getPatientsList() {
        return patientsList;
    }

    void setPatientsList(Patient patient) {
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
