package task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCommands = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split("\\s+");
        List<String> houses = new LinkedList<>();

        houses.addAll(Arrays.asList(input));

        int santaPosition = 0;


        for (int i = 0; i < numberOfCommands; i++) {
            String[] commands = reader.readLine().split("\\s+");
            int housesLength = houses.size();

            switch (commands[0]) {
                case "Forward":
                    int numberOfSteps = Integer.parseInt(commands[1]);
                    housesLength -= 1;
                    santaPosition += numberOfSteps;
                    if (santaPosition >= 0 && santaPosition <= housesLength) {
                        houses.remove(santaPosition);
                    } else {
                        santaPosition -= numberOfSteps;
                        housesLength += 1;
                    }
                    break;
                case "Back":
                    int numberOfStepsBack = Integer.parseInt(commands[1]);
                    housesLength -= 1;
                    santaPosition -= numberOfStepsBack;
                    if (santaPosition >= 0 && santaPosition <= housesLength) {
                        houses.remove(santaPosition);
                    } else {
                        santaPosition += numberOfStepsBack;
                        housesLength += 1;
                    }
                    break;
                case "Gift":
                    int housePosition = Integer.parseInt(commands[1]);
                    String house = commands[2];
                    if (housePosition >= 0 && housePosition <= housesLength) {
                        houses.add(housePosition, house);
                        santaPosition = housePosition;
                    }
                    break;
                case "Swap":
                    int indexOfFirst = houses.indexOf(commands[1]);
                    int indexOfSecond = houses.indexOf(commands[2]);

                    if (indexOfFirst>=0 && indexOfFirst<= housesLength && indexOfSecond>=0 && indexOfSecond<=housesLength){
                        String firstHouse = houses.get(indexOfFirst);
                        String secondHouse = houses.get(indexOfSecond);
                        houses.remove(indexOfFirst);
                        houses.add(indexOfFirst,secondHouse);
                        houses.remove(indexOfSecond);
                        houses.add(indexOfSecond,firstHouse);
                    }
                    break;

            }
        }
        System.out.printf("Position: %d%n",santaPosition);
        System.out.println(String.join(", ",houses));
    }
}
