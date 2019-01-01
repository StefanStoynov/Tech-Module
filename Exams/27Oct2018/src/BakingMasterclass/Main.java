package BakingMasterclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double budget = Double.parseDouble(reader.readLine());
        int students = Integer.parseInt(reader.readLine());
        double flourPrice = Double.parseDouble(reader.readLine());
        double eggPrice = Double.parseDouble(reader.readLine());
        double apronPrice = Double.parseDouble(reader.readLine());

        int freeFlour = students / 5;

        double moneyNeeded = (Math.ceil(students* 1.2) * apronPrice)
                + ((students - freeFlour)* flourPrice)
                + (students * (eggPrice * 10));

        if (budget >= moneyNeeded) {
            System.out.println(String.format("Items purchased for %.2f$.", moneyNeeded));
        } else {
            System.out.println(String.format("%.2f$ more needed.", moneyNeeded - budget));
        }
    }
}
