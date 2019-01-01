package BakingFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        int bestQuantity = 0;
        List<Integer> bestBatch = new ArrayList<>();
        while (!line.equals("Bake It!")) {
         
            int currentQuantity = Arrays.stream(line.split("#")).mapToInt(Integer::parseInt).sum();
            if (bestQuantity < currentQuantity) {
                bestQuantity = currentQuantity;
                bestBatch = Arrays.stream(line.split("#"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } else if (bestQuantity == currentQuantity) {
                double bestQuantityAverage = bestQuantity * 1.0 / bestBatch.size();
                double currentAverage = currentQuantity * 1.0 / line.split("#").length;
                if (currentAverage > bestQuantityAverage) {
                    bestBatch = Arrays.stream(line.split("#"))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                } else if (currentAverage == bestQuantityAverage) {
                    int bestQuantityElements = bestBatch.size();
                    int currentElements = line.split("#").length;
                    if (currentElements < bestQuantityElements) {
                        bestBatch = Arrays.stream(line.split("#"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
                    }
                }
            }

            line = reader.readLine();
        }

        System.out.printf("Best Batch quality: %d%n", bestQuantity);
        StringBuilder result = new StringBuilder();
        bestBatch.forEach(integer -> {
            result.append(integer).append(" ");
        });
        System.out.println(result);
    }
}
