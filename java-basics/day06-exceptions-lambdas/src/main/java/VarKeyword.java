import com.herbalife.labs.City;

import java.util.*;

public class VarKeyword {
    public static void main(String[] args) {
        var countries = new HashMap<>();
        var data = new ArrayList<>();

        var i = 10;
        //i = "hello";
        //Compiler see the RHS value and infers the datatype for the variable
        //You cannot change the datatype

        Collection<Integer> numbersColl = new ArrayList<>();
        numbersColl.add(1);
        numbersColl.add(2);
        numbersColl.add(3);
        numbersColl.remove(1);
        System.out.println(numbersColl); //2,3
        System.out.println(numbersColl.getClass().getName());

        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.remove(1);//1,3
        System.out.println(numbersList);
        System.out.println(numbersList.getClass().getName());

        //var keyword erases the polymorphic call; because compiler infers the datatype from the value
        //you are not sure which datatype it is assigned to? Is it List or Collection?
        var numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.remove(10); //ERROR
        System.out.println(numbers);
        System.out.println(numbers.getClass().getName());

    }
}






