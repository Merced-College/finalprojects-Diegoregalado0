import java.io.*;
import java.util.ArrayList;

public class ClubWarehouseLoader {

    public static ArrayList<GolfClub> loadFromFile(String filename) {
        ArrayList<GolfClub> clubs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0].trim();
                    String type = parts[1].trim();
                    String brand = parts[2].trim();
                    double loft = Double.parseDouble(parts[3].trim());
                    double length = Double.parseDouble(parts[4].trim());

                    GolfClub club = new GolfClub(name, type, brand, loft, length);
                    clubs.add(club);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numbers: " + e.getMessage());
        }

        return clubs;
    }
}