public class Lab06Util {
    public int getSquareWithLogger(int num) {
        System.out.println("Logging ....");
        System.out.println("Calling square of " + num);
        return num * num;
    }


    public int sum(int... numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
