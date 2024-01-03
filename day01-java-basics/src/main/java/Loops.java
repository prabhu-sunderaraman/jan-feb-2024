public class Loops {
    public static void main(String[] args) {
        //ALL OF THESE EXTERNAL ITERATORS ARE OLD STYLE
        //for, for in, while, do-while

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int count = 0;
        while (count < 5) {
            System.out.println(count);
            count++;
        }

        do {
            System.out.println(count);
            count++;
        } while (count < 10);
    }
}
