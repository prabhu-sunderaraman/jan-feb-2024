public class ArraysExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);

        int[] evenNumbers = new int[10];
        for (int i = 0; i < evenNumbers.length; i++) {
            System.out.println(evenNumbers[i]);
        }

        //NOT USED AT ALL IN MODERN DAY PROGRAMMING; USE List, Set instead
        String[] names = new String[10];
        String cities[] = new String[10];

        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }

        //NOT USED AT ALL IN MODERN DAY PROGRAMMING; USE foreach instead
        for (String city : cities) { //Used for read-only purposes
            System.out.println(city);
            //city = ""; //Will not affect the underlying collection
        }

        //NOT USED AT ALL IN MODERN DAY PROGRAMMING; USE Map instead
        String[][] dictionary = new String[5][5];
        dictionary[0][0] = "";
        dictionary[0][1] = "";
        dictionary[0][2] = "";
        dictionary[0][3] = "";
        dictionary[0][4] = "";

        dictionary[1][0] = "";
        dictionary[1][1] = "";
        dictionary[1][2] = "";
        dictionary[1][3] = "";
        dictionary[1][4] = "";

        dictionary[2][0] = "";
        dictionary[2][1] = "";
        dictionary[2][2] = "";
        dictionary[2][3] = "";
        dictionary[2][4] = "";

        String[] oddDictionary[] = new String[5][5];
        String odderDictionary[][] = new String[5][5];

        String[][] dictionary2 = {{"A", "Alphabet"}, {"A", "Address"}};



    }
}
