import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalType {
    static Map<Integer, String> romanNumbers = new HashMap<>();

    public static void main(String[] args) {
        romanNumbers.put(1, "I");
        romanNumbers.put(2, "II");
        romanNumbers.put(3, "III");

        String roman = getRomanNumberOf(1);
        System.out.println(roman + " len: " + roman.length());

        roman = getRomanNumberOf(11);
        if (roman != null) { //What if you forget this?
            System.out.println(roman + " len: " + roman.length());
        }
        Optional<String> optionalRoman = getRomanNumber(11);
        if (optionalRoman.isPresent()) {
            System.out.println(optionalRoman.get());
        }
    }

    private static Optional<String> getRomanNumber(int num) {
        Optional<String> value = Optional.empty(); //empty box
        if (romanNumbers.containsKey(num)) {
            value = Optional.of(romanNumbers.get(num)); //fill the box with the value
        }
        return value;
    }

    private static String getRomanNumberOf(int num) {
        if (romanNumbers.containsKey(num)) {
            return romanNumbers.get(num);
        }
        return null; //BAD PRACTICE
    }
}
