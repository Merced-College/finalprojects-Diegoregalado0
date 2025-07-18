
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
    }

public ArrayList<GolfClub> getClubs() {
        return clubs;
    }
}