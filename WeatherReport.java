import java.util.Random;

class WeatherReport {
    private String[] cities = {"City A", "City B", "City C", "City D", "City E"};
    private int[][] temperatures = new int[5][31];

    public WeatherReport() {
        
        Random random = new Random();
        for (int city = 0; city < 5; city++) {
            for (int day = 0; day < 31; day++) {
                temperatures[city][day] = random.nextInt(60); 
            }
        }
    }

    public void displayTable() {
        System.out.println("Daily Maximum Temperatures for January");
        System.out.println("=====================================");
        System.out.print("\t" +"Day" +"\t");
        for (String city : cities) {
            System.out.print("\t"+city+"\t");
        }
        System.out.println();

        for (int day = 0; day < 31; day++) {
            System.out.print("\t"+(day + 1)+"\t");
            for (int city = 0; city < 5; city++) {
                System.out.printf("\t"+temperatures[city][day]+"\t");
            }
            System.out.println();
        }
    }

    public void findHighestAndLowestTemperatures() {
        int highestTemp = Integer.MIN_VALUE;
        int lowestTemp = Integer.MAX_VALUE;
        int highestTempCityIndex = -1;
        int lowestTempCityIndex = -1;
        int highestTempDay = -1;
        int lowestTempDay = -1;

        for (int city = 0; city < 5; city++) {
            for (int day = 0; day < 31; day++) {
                int temp = temperatures[city][day];
                if (temp > highestTemp) {
                    highestTemp = temp;
                    highestTempCityIndex = city;
                    highestTempDay = day + 1;
                }
                if (temp < lowestTemp) {
                    lowestTemp = temp;
                    lowestTempCityIndex = city;
                    lowestTempDay = day + 1;
                }
            }
        }

        System.out.println("\nHighest Temperature: " + highestTemp + "°C");
        System.out.println("City with Highest Temperature: " + cities[highestTempCityIndex]);
        System.out.println("Day with Highest Temperature: January " + highestTempDay);
        
        System.out.println("\nLowest Temperature: " + lowestTemp + "°C");
        System.out.println("City with Lowest Temperature: " + cities[lowestTempCityIndex]);
        System.out.println("Day with Lowest Temperature: January " + lowestTempDay);
    }

    public static void main(String[] args) {
        WeatherReport weatherReport = new WeatherReport();
        weatherReport.displayTable();
        weatherReport.findHighestAndLowestTemperatures();
    }
}
