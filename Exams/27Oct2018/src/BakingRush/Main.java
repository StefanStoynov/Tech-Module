package BakingRush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\|");

        double energy = 100;
        double coins = 100;

        for (int i = 0; i < input.length; i++) {
            String[] line = input[i].split("\\-");
            String command = line[0];
            if (command.equals("rest")) {
                double newEnergy = energy + Double.parseDouble(line[1]);
                if (newEnergy >= 100) {
                    double energyGained = 100 - energy;
                    System.out.println(String.format("You gained %.0f energy.", energyGained));
                    System.out.println(String.format("Current energy: %.0f.",energy));
                    energy = 100;
                } else {
                    energy = newEnergy;
                    System.out.println(String.format("You gained %.0f energy.", Double.parseDouble(line[1])));
                    System.out.println(String.format("Current energy: %.0f.", energy));
                }
            } else if (command.equals("order")) {
                energy -= 30;
                if (energy < 0) {
                    energy += 80;
                    System.out.println("You had to rest!");
                } else {
                    coins += Double.parseDouble(line[1]);
                    System.out.printf("You earned %.0f coins.%n", Double.parseDouble(line[1]));
                }
            } else {
                double ingredientPrice = Double.parseDouble(line[1]);
                coins -= ingredientPrice;
                if (coins > 0) {
                    System.out.printf("You bought %s.%n", line[0]);
                } else {
                    System.out.printf("Closed! Cannot afford %s.%n", line[0]);
                    return;
                }

            }
        }
        if (coins >= 0) {
            System.out.printf("Day completed!%nCoins: %.0f%nEnergy: %.0f", coins, energy);
        }

    }
}
