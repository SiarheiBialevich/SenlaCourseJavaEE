public class MedicalHistory {
    private String vaccination;
    private String disease;
    private String allergy;

    public MedicalHistory() {
        System.out.println(MedicalHistory.class.getName());
    }

    public String getVaccination() {
        return vaccination;
    }

    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
}