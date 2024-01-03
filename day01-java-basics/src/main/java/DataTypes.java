public class DataTypes {
    public static void main(String[] args) {
        //Primitive data types are stored on the stack
        byte b = 23;
        int i = 10;
        long number = 23434324L;
        float pi = 3.14f;
        double fee = 23.45d;
        char ch = 'A';
        boolean status = true;

        //Reference data types are stored on the heap
        //These classes are also known as Wrapper classes
        //They are present in the standard library
        Byte bObj = 23;
        Integer iObj = 10;
        Long numberObj = 32423324L;
        Float piObject = 3.14f;
        Double feeObj = 23.45d;
        Character chObj = 'A';
        Boolean statusObj = false;


        //More on this tomorrow
        String name = "Sam"; //Looks like a primitive data type but it's not; It's a reference data type

    }

    void sayHello() {

    }
}
