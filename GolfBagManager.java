
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class GolfBagManager {
    private final ArrayList<GolfClub> clubs = new ArrayList<>();

public void addClub(Scanner scanner) {
        System.out.print("Club name: ");
        String name = scanner.nextLine();
        System.out.print("Type (e.g., Driver, Iron): ");
        String type = scanner.nextLine();
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Loft (degrees): ");
        double loft = scanner.nextDouble();
        System.out.print("Length (inches): ");
        double length = scanner.nextDouble();
        scanner.nextLine();

        GolfClub club = new GolfClub(name, type, brand, loft, length);
        clubs.add(club);
        System.out.println("Added: " + club);
    }

 public void viewClubs() {
        if (clubs.isEmpty()) {
            System.out.println("No clubs in bag.");
            return;
        }
        for (GolfClub club : clubs) {
            System.out.println(club);
        }
    }


public void sortByLoft() {
    clubs.sort(Comparator.comparingDouble(GolfClub::loft));
    System.out.println("Clubs sorted by loft.");

    try (FileWriter writer = new FileWriter("sorted_warehouse.txt")) {
        for (GolfClub club : clubs) {
            writer.write(String.format("%s,%s,%s,%.1f,%.2f%n",
                club.name(), club.type(), club.brand(), club.loft(), club.length()));
        }
        System.out.println("Sorted clubs written to sorted_warehouse.txt");
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
}

public ArrayList<GolfClub> getClubs() {
        return clubs;
    }

    public void addClub(GolfClub club) {
    clubs.add(club);
}

public boolean deleteClubByName(String name) {
    for (int i = 0; i < clubs.size(); i++) {
        if (clubs.get(i).name().equalsIgnoreCase(name)) {
            clubs.remove(i);
            return true; 
        }
    }
    return false; 
}
}