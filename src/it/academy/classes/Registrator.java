package it.academy.classes;

import it.academy.interfaces.AddNewPatients;
import it.academy.interfaces.PatientImput;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Registrator implements AddNewPatients {
    private List<Patient> newPatientList = new ArrayList<>();

    @Override
    public void getInfo() {
        PatientImput patientImput = new ConsolePatientImput();
        newPatientList.add(patientImput.input());
    }

    @Override
    public List<Patient> addNewInfo(List<Patient> patientList) {
        Set<Patient> allPatients = new TreeSet<>(new MyComparator());
        allPatients.addAll(newPatientList);
        allPatients.addAll(patientList);
        patientList.clear();
        patientList.addAll(allPatients);
        return patientList;
    }
}
