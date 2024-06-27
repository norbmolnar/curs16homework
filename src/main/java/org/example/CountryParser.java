import java.util.*;

class Country {
    private String name;
    private String capital;
    private int population;
    private int area;
    private String continent;
    private List<String> neighbors;

    public Country(String name, String capital, int population, int area, String continent, List<String> neighbors) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbors = neighbors;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", continent='" + continent + '\'' +
                ", neighbors=" + neighbors +
                '}';
    }
}

public class CountryParser {
    public static void main(String[] args) {
        String data = "Afghanistan|Kabul|27657145|652230|Asia|IRN~PAK~TKM~UZB~TJK~CHN\n" +
                "Åland Islands|Mariehamn|28875|1580|Europe|\n" +
                "Albania|Tirana|2886026|28748|Europe|MNE~GRC~MKD~KOS\n" +
                "Algeria|Algiers|40400000|2381741|Africa|TUN~LBY~NER~ESH~MRT~MLI~MAR\n" +
                "American Samoa|Pago Pago|57100|199|Oceania|\n" +
                // Add other countries here ...
                "Yemen|Sana'a|27478000|527968|Asia|OMN~SAU\n";

        String[] lines = data.split("\n");
        Map<String, Country> countries = new HashMap<>();

        for (String line : lines) {
            String[] parts = line.split("\\|");
            String name = parts[0];
            String capital = parts[1];
            int population = Integer.parseInt(parts[2]);
            int area = Integer.parseInt(parts[3]);
            String continent = parts[4];
            List<String> neighbors = parts.length > 5 && !parts[5].isEmpty() ? Arrays.asList(parts[5].split("~")) : new ArrayList<>();

            Country country = new Country(name, capital, population, area, continent, neighbors);
            countries.put(name, country);
        }

        // Example usage: Print all countries
        for (Country country : countries.values()) {
            System.out.println(country);
        }
    }
}
