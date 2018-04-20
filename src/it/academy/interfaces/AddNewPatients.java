package it.academy.interfaces;

import it.academy.classes.Patient;

import java.util.List;

public interface AddNewPatients {
    void getInfo();

    List<Patient> addNewInfo(List<Patient> patientList);
}
