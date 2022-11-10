package com.unvise.oop;

import com.unvise.oop.apps.ContainerWithMostWaterApp;
import com.unvise.oop.apps.MaxProfitApp;
import com.unvise.oop.apps.PermutationApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner numberScanner = new Scanner(System.in)) {
            System.out.print("Выберите программу (1, 2, 3): ");
            int option = numberScanner.nextInt();
            if (option == 1) {
                PermutationApp.main(args);
                return;
            }
            if (option == 2) {
                MaxProfitApp.main(args);
                return;
            }
            if (option == 3) {
                ContainerWithMostWaterApp.main(args);
                return;
            }
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Неправильный номер программы");
        }
    }
}
