
import java.util.ArrayList;

public class Utils {
    // Recursive search by club name
    public static GolfClub recursiveFind(ArrayList<GolfClub> list, String name, int index) {
        if (index >= list.size()) return null;
        if (list.get(index).name().equalsIgnoreCase(name)) return list.get(index);
        return recursiveFind(list, name, index + 1);
    }
}