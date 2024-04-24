import java.util.ArrayList;
import java.util.List;

public class Cat {
    private static List<Cat> catList = new ArrayList<>();

    public static void add(Cat newCat) {
        catList.add(newCat);
    }
}

