import java.io.IOException;
import java.sql.SQLException;

public class ExceptionHandline {
    public static void main(String[] args) throws Exception {
        //try, catch, finally, throw, throws(!!!)
        try {
            int i = 10 / 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("In finally");
        }

        //Exceptions are grouped into Checked and Unchecked exceptions
        //Checked exceptions(classes that extend Exception) are those that NEED to be handled in your code;
        //Unchecked exceptions(classes that extend RuntimeException) are those that NEED NOT be handled in your code;

        try {
            doSomething();
        } catch (Exception ex) {

        }
        doSomething();
        doSomethingElse();

//        MyResource myResource = new MyResource();
//        //use myResource
//        myResource.close();
        try (MyResource myResource = new MyResource()) {
            //use myResource
        } //At the end of this block, myResource.close() is called automatically; similar to IDisposable in C#
    }

    private static void doSomethingElse() {
        int num = 10;
        if (num > 10) {
            throw new RuntimeException("Num is gt 10");
        }
    }

    //NOT RECOMMENDED IN MODERN DAYS
    private static void doSomethingCrazy() throws IOException, SQLException {
        int num = 10;
        if (num > 10) {
            throw new IOException("Num is gt 10");
        }
        if (num < 10) {
            throw new SQLException();
        }
    }

    private static void doSomething() throws Exception {
        int num = 10;
        if (num > 10) {
            throw new Exception("Num cannot be greater than 10");
//            try {
//                throw new Exception("Num cannot be greater than 10");
//            } catch (Exception ex) {
//
//            }
            //throw new RuntimeException("Num cannot be greater than 10");
        }
    }
}

class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("Initialized resource");
    }

    public void close() {
        System.out.println("Cleaning up resource");
    }
}