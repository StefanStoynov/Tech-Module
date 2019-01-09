package task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int dishes = 0;
        int cleaning = 0;
        int laundry = 0;

        String line;

        while (true) {
            if ("wife is happy".equals(line = reader.readLine())) {
                break;
            }
            String regex = "(<[a-z0-9]*>)|(\\[[A-Z0-9]*\\])|(\\{.*})";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                if (matcher.group(1) != null) {
                    dishes += result(matcher.group(1));
                } else if (matcher.group(2) != null) {
                    cleaning += result(matcher.group(2));
                } else if (matcher.group(3) != null) {
                    laundry += result(matcher.group(3));
                }
            }


        }
        System.out.printf("Doing the dishes - %d min.\n" +
                "Cleaning the house - %d min.\n" +
                "Doing the laundry - %d min.\n" +
                "Total - %d min. \n", dishes, cleaning, laundry, dishes + cleaning + laundry);
    }

    private static int result(String matcher) {
        int result = 0;

        for (int i = 0; i < matcher.length(); i++) {
            if (Character.isDigit(matcher.charAt(i))) {
                result += matcher.charAt(i) - 48;
            }
        }

        return result;
    }
}
