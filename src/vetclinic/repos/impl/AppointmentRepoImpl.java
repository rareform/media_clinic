package vetclinic.repos.impl;

import vetclinic.model.Appointment;
import vetclinic.repos.AppointmentRepo;

import java.util.HashSet;
import java.util.Set;

public class AppointmentRepoImpl implements AppointmentRepo {

        private static final Set<Appointment> APPOINTMENTS = new HashSet<>();

        private static final AppointmentRepoImpl SINGLETON = new AppointmentRepoImpl();

        private AppointmentRepoImpl() {}

        public static AppointmentRepo getSingleton() { return SINGLETON; }


        @Override
        public Set<Appointment> findAll() { return APPOINTMENTS; }

        @Override
        public void save(Appointment appointment) { APPOINTMENTS.add(appointment); }

        @Override
        public void remove(Appointment appointment) { APPOINTMENTS.remove(appointment); }

}
