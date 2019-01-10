package task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfBathes = Integer.parseInt(reader.readLine());
        int totalBoxes = 0;

        for (int i = 0; i < numberOfBathes; i++) {

            int flourGrams = Integer.parseInt(reader.readLine());
            int sugarGrams = Integer.parseInt(reader.readLine());
            int cocoaGrams = Integer.parseInt(reader.readLine());

            int flourCup = flourGrams / 140;
            int sugarSpoons = sugarGrams / 20;
            int cocoaSpoons = cocoaGrams / 10;

            if (flourCup <= 0 || sugarSpoons <= 0 || cocoaSpoons <= 0) {
                System.out.println("Ingredients are not enough for a box of cookies.");
                continue;
            }

            int min = Math.min(flourCup, sugarSpoons);
            min = Math.min(min, cocoaSpoons);

            int couciesPerBake = 170 * min / 25;

            int box = couciesPerBake / 5;

            System.out.printf("Boxes of cookies: %d%n", box);
            totalBoxes += box;


        }
        System.out.printf("Total boxes: %d%n", totalBoxes);
    }
}
