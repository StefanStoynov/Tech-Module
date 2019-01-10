package task_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Child> children = new LinkedList<>();
        Map<String, Integer> toys = new LinkedHashMap<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }
            String[] data = line.split("->");
            if ("Remove".equals(data[0])) {
                if (data.length == 2) {
                    String name = data[1];
                    while (findChild(children, name) != null) {
                        Child child = findChild(children, name);
                        children.remove(child);
                    }
                }
            } else {
                if (data.length == 3) {

                    String name = data[0];
                    String present = data[1];
                    int ammount = Integer.parseInt(data[2]);
                    if (findChild(children, name) != null) {
                        Child child = findChild(children, name);
                        int oldAmmount = child.getAmmount();
                        int newAmmount = oldAmmount + ammount;
                        child.setAmmount(newAmmount);
                    } else {
                        Child child = new Child(name);
                        child.setTypeOfPresent(present);
                        child.setAmmount(ammount);
                        children.add(child);
                    }

                    if (!toys.containsKey(present)) {
                        toys.put(present, ammount);
                    } else {
                        toys.put(present, toys.get(present) + ammount);
                    }
                }
            }


        }


        StringBuilder result = new StringBuilder();
        result.append("Children:").append(System.lineSeparator());
        children.stream()
                .sorted((c1,c2)-> {
                            int result1 = c2.getAmmount() - c1.getAmmount();
                            if (result1 != 0) {
                                return result1;
                            }
                            return c1.getName().compareTo(c2.getName());
                        }
                )
                .forEach(child -> {
                    result.append(child.getName()).append(" -> ").append(child.getAmmount()).append(System.lineSeparator());
                });

        result.append("Presents:").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : toys.entrySet()) {
            result.append(entry.getKey()).append(" -> ").append(entry.getValue()).append(System.lineSeparator());
        }

        System.out.println(result);

    }

    public static Child findChild(List<Child> children, String name) {

        Optional<Child> child = children.stream().filter(c -> c.getName().equals(name)).findFirst();

        return child.orElse(null);
    }

    public static class Child {
        private String name;
        private String typeOfPresent;
        private int ammount;

        public Child(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String getTypeOfPresent() {
            return this.typeOfPresent;
        }

        public int getAmmount() {
            return this.ammount;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTypeOfPresent(String typeOfPresent) {
            this.typeOfPresent = typeOfPresent;
        }

        public void setAmmount(int ammount) {
            this.ammount = ammount;
        }
    }
}
