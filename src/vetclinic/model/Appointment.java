package vetclinic.model;



public class Appointment {

    private Patient patient;

    private Doctor doctor;

    private String date;

    private String status;



    public Appointment(Patient patient, Doctor doctor, String date, String status) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
