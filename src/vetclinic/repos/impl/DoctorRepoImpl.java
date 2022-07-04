package vetclinic.repos.impl;

import vetclinic.model.Doctor;
import vetclinic.repos.DoctorRepo;

import java.util.HashSet;
import java.util.Set;

public class DoctorRepoImpl implements DoctorRepo {

    private static final Set<Doctor> DOCTORS = new HashSet<>();

    private static final DoctorRepoImpl SINGLETON = new DoctorRepoImpl();

    private DoctorRepoImpl() {}

    public static DoctorRepo getSingleton() { return SINGLETON; }


    @Override
    public Set<Doctor> findAll() { return DOCTORS; }

    @Override
    public void save(Doctor doctor) { DOCTORS.add(doctor); }

    @Override
    public void remove(Doctor doctor) { DOCTORS.remove(doctor); }
}
