package it.academy.classes;

import it.academy.interfaces.MakeChoice;
import it.academy.interfaces.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu implements MakeChoice {
    private Map<Integer, Operation> operations = new HashMap<>() {
        {
            put(1, new Registration());
            put(2, new GetInfoFromOfflineBase());
            put(3, new GetAllInfo());
            put(0, new EndOfWork());
        }
    };
    @Override
    public int getChoice() {
        System.out.println("1.Добавление новых пациетнов.");
        System.out.println("2.Вывод информации о студентах в офлайн базе.");
        System.out.println("3.Вывод информации о всех студентах.");
        System.out.println("0.Завершить работу.");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        while (choice > 3 || choice < 0) {
            System.out.println("Вы ввели неверное значение , повторите попытку");
            choice = in.nextInt();
        }
        return choice;
    }
    public Operation choiceOperations(int choice) {
        return operations.get(choice);
    }
}