import java.util.ArrayList;

public class Utils {
    public static GolfClub recursiveFind(ArrayList<GolfClub> list, String name, int index) {
        if (index >= list.size()) {
            return null; // base case: not found
        }

        GolfClub current = list.get(index);
        if (current.name().equalsIgnoreCase(name)) {
            return current; // base case: found
        }

        return recursiveFind(list, name, index + 1); // recursive case
    }
}