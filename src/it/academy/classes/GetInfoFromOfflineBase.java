package it.academy.classes;

import java.util.List;

public class GetInfoFromOfflineBase implements it.academy.interfaces.Operation {
    @Override
    public void perform() {
        PatientBase patientBase = new PatientBase("base.dat");
        List<Patient> patients = patientBase.getAll();
        for (Patient patient : patients) {
            System.out.println(patient);
        }
        System.out.println("Операция завершена , произведите выбор необходимой операции повторно");
    }
}
