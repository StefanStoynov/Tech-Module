package task_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<City> cities = new ArrayList<>();

        String line;
        while (true) {
            if ("Slide rule".equals(line = reader.readLine())) {
                break;
            }

            String[] input = line.split(":|->");
            String cityName = input[0];
            int passengers = Integer.parseInt(input[2]);

            if ("ambush".equals(input[1])) {
                if (findCity(cities, cityName) != null) {
                    City city = findCity(cities, cityName);
                    city.setTime(0);
                    int passengersOldCount = city.getPassengers();
                    city.setPassengers(passengersOldCount - passengers);
                   continue;
                } else {
                    continue;
                }
            }
            if (findCity(cities, cityName) != null) {

                City city = findCity(cities, cityName);

                if (city.getTime() > Integer.parseInt(input[1])||city.getTime()==0) {
                    city.setTime(Integer.parseInt(input[1]));
                }

                int passengersOldCount = city.getPassengers();
                city.setPassengers(passengersOldCount + passengers);
            } else {
                City city = new City(cityName);
                city.setTime(Integer.parseInt(input[1]));
                city.setPassengers(passengers);

                cities.add(city);
            }


        }
        cities.stream().sorted(Comparator.comparing(City::getTime).thenComparing(City::getName)).forEach(city -> {
            if (city.getTime()!=0||city.getPassengers()!=0){
                System.out.printf("%s -> Time: %d -> Passengers: %d%n",
                        city.getName(),
                        city.getTime(),
                        city.getPassengers()
                );
            }
        });

    }

    private static City findCity(List<City> cities, String name) {

        Optional<City> city = cities.stream().filter(c -> c.getName().equals(name)).findFirst();

        return city.orElse(null);
    }

    public static class City {
        private String name;
        private int time;
        private int passengers;

        public City(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public int getTime() {
            return this.time;
        }

        public int getPassengers() {
            return this.passengers;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public void setPassengers(int passengers) {
            this.passengers = passengers;
        }
    }
}
