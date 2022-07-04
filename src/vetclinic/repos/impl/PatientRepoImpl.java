package vetclinic.repos.impl;

import vetclinic.model.Patient;
import vetclinic.repos.PatientRepo;

import java.util.HashSet;
import java.util.Set;

public class PatientRepoImpl implements PatientRepo {

    private static final Set<Patient> PATIENTS = new HashSet<>();

    private static final PatientRepoImpl SINGLETON = new PatientRepoImpl();

    private PatientRepoImpl() {}

    public static PatientRepo getSingleton() { return SINGLETON; }


    @Override
    public Set<Patient> findAll() { return PATIENTS; }

    @Override
    public void save(Patient patient) { PATIENTS.add(patient); }

    @Override
    public void remove(Patient patient) { PATIENTS.remove(patient); }
}
