public class Lab06DifferentStyle {
    public static void main(String[] args) {
        int sumResult = operate(Lab06DifferentStyle::sum); //:: is called a Method Reference Operator; Similar to scope operator in C++
        System.out.println(sumResult);

        int squareResult = compute(num -> num * num);
        System.out.println(squareResult);

        Lab06Util lab06UtilObj = new Lab06Util();
        int squareResult2 = compute(lab06UtilObj::getSquareWithLogger);
        System.out.println(squareResult2);

        int squareResultWithLogger = compute(Lab06DifferentStyle::getSquareWithLogger);
        System.out.println(squareResultWithLogger);

        int squareResultWithLogger2 = compute(lab06UtilObj::getSquareWithLogger);
        System.out.println(squareResultWithLogger2);

    }

    private static int getSquareWithLogger(int num) {
        System.out.println("Logging ....");
        System.out.println("Calling square of " + num);
        return num * num;
    }


    static int sum(int... numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    static int operate(Adder adder) {
        return adder.sum(5, 10, 15);
    }

    static int compute(Square square) {
        return square.fetch(5);
    }
}

@FunctionalInterface
interface Adder {
    int sum(int... numbers);
}

@FunctionalInterface
interface Square {
    int fetch(int num);
}
