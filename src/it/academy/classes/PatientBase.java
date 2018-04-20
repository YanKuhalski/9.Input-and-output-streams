package it.academy.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientBase {
    private String name;
    private List<Patient> list = new ArrayList<>();

    public PatientBase(String name) {
        this.name = name;
    }

    public void addAll(List<Patient> patients) {
        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(name))) {
            for (Patient patient : patients) {
                stream.writeUTF(patient.getName());
                stream.writeUTF(patient.getSecondName());
                stream.writeLong(patient.getBirthday().getTime());
                stream.writeBoolean(patient.isHealthy());
                stream.writeUTF(";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Patient> getAll() {
        try (DataInputStream stream = new DataInputStream(new FileInputStream(name))) {
            while (stream.available() > 0) {
                list.add(new Patient(stream.readUTF(), stream.readUTF(), new Date(stream.readLong()), stream.readBoolean()));
                stream.readUTF();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
