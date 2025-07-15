package backEndCourse.vacationTasks.homeTask.collections.difficult.task09;

import java.util.Objects;

public class Country implements Comparable<Country>{
    private String countryName;

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Country country)) return false;
        return Objects.equals(countryName, country.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(countryName);
    }

    @Override
    public String toString() {
        return "Country: " + countryName;
    }

    @Override
    public int compareTo(Country o) {
        return countryName.compareTo(o.countryName);
    }
}
