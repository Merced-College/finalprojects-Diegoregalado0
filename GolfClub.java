    
//Defines GolfClub class

public record GolfClub(String name, String type, String brand, double loft, double length) {
    @Override
    public String toString() {

        // Displays details in readable format
        return String.format("%s - %s (%s), Loft: %.1f°, Length: %.1f in", 
            name, type, brand, loft, length);
    }
}
