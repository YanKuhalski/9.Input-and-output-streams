package it.academy.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetAllInfo implements it.academy.interfaces.Operation {
    private Set<Patient> patientBase = new TreeSet<>(new MyComparator());
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void perform() {
        PatientBase offlinePatientBase = new PatientBase("base.dat");
        patientBase.addAll(offlinePatientBase.getAll());
        patientBase.addAll(getOnlineBase());
        for (Patient patient : patientBase) {
            System.out.println(patient);
        }
        patientBase.clear();
    }

    public List<Patient> getOnlineBase() {
        List<Patient> onlineBase = new ArrayList<>();
        URL URL = null;
        try {
            URL = new URL("https://raw.githubusercontent.com/YanKuhalski/Different/master/OnlinePatientBase.txt");
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) URL.openConnection();
                connection.connect();
                try (BufferedReader stream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = stream.readLine()) != null) {
                        String[] parametrs = line.split(";");
                        String name = parametrs[0];
                        String secondName = parametrs[1];
                        Date birthday = sdf.parse(parametrs[2]);
                        boolean healthy = Boolean.valueOf(parametrs[3]);
                        onlineBase.add(new Patient(name, secondName, birthday, healthy));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return onlineBase;
    }
}
