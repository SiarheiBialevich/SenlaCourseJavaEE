package ru.senla.bialevich.Clinic;

public class Patient extends AbstractMan {
    private String disease;

    Patient(String name, String surname, String disease) {
        super(name, surname);
        this.disease = disease;
    }

    String getDisease() {
        return disease;
    }

    void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", disease='").append(disease).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
