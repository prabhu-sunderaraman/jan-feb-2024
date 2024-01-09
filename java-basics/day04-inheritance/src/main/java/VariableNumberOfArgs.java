public class VariableNumberOfArgs {
    public static void main(String[] args) {
        add(10, 20, 30);
        add(100, 300, 400, 5000, 6700);
    }

    //... refers to ellipsis operator
    //... is called rest operator in JavaScript
    static void add(int... args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        System.out.println(sum);
    }
}
