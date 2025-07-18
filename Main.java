import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GolfBagManager manager = new GolfBagManager();
        UsageTracker tracker = new UsageTracker();
        Scanner scanner = new Scanner(System.in);

        ArrayList<GolfClub> warehouseClubs = ClubWarehouseLoader.loadFromFile("clubwarehouse.txt");
        for (GolfClub club : warehouseClubs) {
            manager.addClub(club);
        }

        while (true) {
            System.out.println("\n=== Golf Club Organizer ===");
            System.out.println("1. Add Golf Club");
            System.out.println("2. View All Clubs");
            System.out.println("3. Sort Clubs by Loft");
            System.out.println("4. Use Club");
            System.out.println("5. View Most Used Clubs");
            System.out.println("6. Search for Club (Recursive)");
            System.out.println("7. Delete a Club");
            System.out.println("0. Exit");

            int choice = readInt(scanner, "Choice: ");

            switch (choice) {
                case 1 -> manager.addClub(scanner);
                case 2 -> manager.viewClubs();
                case 3 -> manager.sortByLoft();
                case 4 -> {
                    System.out.print("Enter club name: ");
                    String name = scanner.nextLine();
                    tracker.useClub(name);
                }
                case 5 -> tracker.printMostUsed();
                case 6 -> {
                    System.out.print("Enter club name to search: ");
                    String searchName = scanner.nextLine();
                    GolfClub found = Utils.recursiveFind(manager.getClubs(), searchName, 0);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Club not found.");
                    }
                }
                case 7 -> {
                    System.out.print("Enter name of club to delete: ");
                    String name = scanner.nextLine();
                    boolean deleted = manager.deleteClubByName(name);
                    if (deleted) {
                        System.out.println("Club deleted: " + name);
                    } else {
                        System.out.println("Club not found.");
                    }
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // clear newline
                return value;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // discard bad input
            }
        }
    }

    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine(); // clear newline
                return value;
            } else {
                System.out.println("Invalid input. Please enter a decimal number.");
                scanner.nextLine(); // discard bad input
            }
        }
    }
}