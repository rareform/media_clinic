package vetclinic.model;


import java.util.Objects;

public class Doctor {

    private int id = 0;

    private String name;

    private String specialty;


    public Doctor(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSpecialty() { return specialty; }

    public void setSpecialty(String specialty) { this.specialty = specialty; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(name, doctor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
