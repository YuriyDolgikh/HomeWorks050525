package backEndCourse.vacationTasks.homeTask.collections.difficult.task09;

/*
    9 Создать отображение HashMap, где ключом является объект класса Country, а значением - список строк
      (названия городов в этой стране). Затем добавить несколько городов для каждой страны
      и вывести все страны на консоль в алфавитном порядке.
*/

import java.util.*;

public class CountriesApp {
    public static void main(String[] args) {
        Map<Country, List<String>> countries = new HashMap<>();

        Country germany = new Country("Germany");
        Country usa = new Country("USA");
        Country france = new Country("France");

        addCityToCountry(countries, new Country("Germany"), "Berlin");
        addCityToCountry(countries, germany, "Munich");
        addCityToCountry(countries, germany, "Stuttgart");
        addCityToCountry(countries, usa, "Washington DC");
        addCityToCountry(countries, france, "Paris");
        addCityToCountry(countries, france, "Marseille");
        addCityToCountry(countries, usa, "New York");
        addCityToCountry(countries, new Country("USA"), "Los Angeles");
        addCityToCountry(countries, usa, "Chicago");

        printCountries(countries);
    }

    private static void addCityToCountry(Map<Country, List<String>> countries, Country country, String city) {
        if (countries.containsKey(country)) {
            List<String> cityList = countries.get(country);
            if (!cityList.contains(city)) {
                countries.get(country).add(city);
            }
        } else {
            List<String> newList = new ArrayList<>();
            newList.add(city);
            countries.put(country, newList);
        }
    }

    private static void printCountries(Map<Country, List<String>> countries) {
        Map<Country, List<String>> sortedMap = new TreeMap<>(countries);
        for (Map.Entry<Country, List<String>> entry : sortedMap.entrySet()) {
            Collections.sort(entry.getValue());
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
