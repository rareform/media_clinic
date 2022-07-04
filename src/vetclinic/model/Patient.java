package vetclinic.model;

import java.time.Instant;
import java.util.Objects;

public class Patient {

    private int id;

    private String name;

    private String animalType;

    private Instant regDate;


    public Patient(int id, String name, String animalType) {
        this.id = id;
        this.name = name;
        this.animalType = animalType;

        regDate = Instant.now();
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAnimalType() { return animalType; }

    public void setAnimalType(String animalType) { this.animalType = animalType; }

    public Instant getRegDate() { return regDate; }

    public void setRegDate(Instant regDate) { this.regDate = regDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(name, patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
