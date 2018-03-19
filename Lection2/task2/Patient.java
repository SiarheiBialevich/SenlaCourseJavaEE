public class Patient extends AbstractPeople {
    private Employment employment;
    private MedicalHistory medicalHistory;
    private Address address;

    Patient(Address address, Employment employment, MedicalHistory medicalHistory) {
        this.employment = employment;
        this.medicalHistory = medicalHistory;
        this.address = address;

        System.out.println(Patient.class.getName());
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

