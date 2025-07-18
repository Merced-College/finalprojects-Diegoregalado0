//imports 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GolfBagManager manager = new GolfBagManager();
        UsageTracker tracker = new UsageTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Golf Club Organizer ===");
            System.out.println("1. Add Golf Club");
            System.out.println("2. View All Clubs");
            System.out.println("3. Sort Clubs by Loft");
            System.out.println("4. Use Club");
            System.out.println("5. View Most Used Clubs");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

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
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}