package it.academy.classes;

import java.util.List;
import java.util.Scanner;

public class Registration implements it.academy.interfaces.Operation {

    @Override
    public void perform() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество новых пациентов");
        int quantity = in.nextInt();
        Registrator registrator = new Registrator();
        for (int i = 0; i < quantity; i++) {
            registrator.getInfo();
        }
        PatientBase patientBase = new PatientBase("base.dat");
        List<Patient> patientList = patientBase.getAll();
        registrator.addNewInfo(patientList);
        patientBase.addAll(patientList);
        System.out.println("Операция завершена , произведите выбор необходимой операции повторно");
    }
}
