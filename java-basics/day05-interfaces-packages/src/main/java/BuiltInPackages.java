import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class BuiltInPackages {
    public static void main(String[] args) {
        //java.io is old package for IO operations
        //java.nio
        try {
            List<String> lines = Files.readAllLines(Paths.get("~/Documents/hello.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //java.net; Connect to a remote API and make calls
        //java.time for date/time operations
        LocalDate date = LocalDate.now();

        //java.util contains the collection classes
        //Lists, Sets and Maps

        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Golang");
        languages.add("C#");
        for (int i = 0; i < languages.size(); i++) {
            System.out.println(languages.get(i));
        }

        Set<String> cities = new HashSet<>(); //Does not allow duplicates
        cities.add("Houston");
        cities.add("Mumbai");
        cities.add("Mexico city");
        cities.add("Houston");
        Iterator<String> iterator = cities.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Map<Integer, String> romanNumbers = new HashMap<>();
        romanNumbers.put(1, "I");
        romanNumbers.put(2, "II");
        romanNumbers.put(3, "III");
        Iterator<Integer> romanNumbersIterator = romanNumbers.keySet().iterator();
        while(romanNumbersIterator.hasNext()) {
            int key = romanNumbersIterator.next();
            String value = romanNumbers.get(key);
            System.out.println(key + ": " + value);
        }
    }
}
