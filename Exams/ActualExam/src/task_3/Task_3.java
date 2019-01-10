package task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int decoder = Integer.parseInt(reader.readLine());
        List<String> names = new LinkedList<>();

        String line;
        while (true) {
            if ("end".equals(line = reader.readLine())) {
                break;
            }
            List<Character>decodedMessage = new LinkedList<>();

            for (int i = 0; i < line.length(); i++) {
                int oldValue = (int)line.charAt(i);
                int newValue = oldValue - decoder;
                char newString = (char)(newValue);
                decodedMessage.add(newString);
            }

            StringBuilder decoded = new StringBuilder();

            for (Character character : decodedMessage) {
                decoded.append(character);
            }

            String regex = "@([A-Za-z]+)[^@\\-!:>]+!([G|N])!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decoded);

            if (matcher.find()){
                if (matcher.group(2).equals("G")){
                    names.add(matcher.group(1));
                }
            }

        }
        names.stream().forEach(name -> System.out.println(name));

    }
}
