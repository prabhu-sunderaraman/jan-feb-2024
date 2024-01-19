import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);
        List<String> names = List.of("John", "Jane", "Joe");
        List<?> wildcards = List.of(1, "John", 3.14);
        MyCollection<Integer> myNumbers = new MyCollection<>();
        myNumbers.add(1);
        //myNumbers.add("12"); //ERROR
        MyCollection<String> myNames = new MyCollection<>();
        myNames.add("John");

        Box<Pen> penBox = new Box<>();
        penBox.add(new Pen());
        //penBox.add(new FountainPen());

        Box<Pencil> pencilBox = new Box<>();
        //Box<String> stringBox = new Box<>();
        //Box<Integer> integerBox = new Box<>();

        //In Java Generics is a compile-time feature whereas in C# it is a runtime feature
        MyList<String> stringList = new MyList<>();
        MyList<Integer> integerList = new MyList<>();
        MyList<Double> doubleList = new MyList<>();

        //Possible in C# but not in Java
//        System.out.println(MyList<String>.objectCount);
//        System.out.println(MyList<Integer>.objectCount);
//        System.out.println(MyList<Double>.objectCount);

        System.out.println(stringList.getClass().getName()); //In C# the output will be MyList<String>
        System.out.println(integerList.getClass().getName()); //In C# the output will be MyList<Int32>
        System.out.println(doubleList.getClass().getName()); //In C# the output will be MyList<Double>
    }
}

class MyList<T> {
    static int objectCount;

    public MyList() {
        objectCount++;
    }
}

interface WritingTool {
}

class Pen implements WritingTool {
}

class Pencil implements WritingTool {
}

class Box<T extends WritingTool> {
    private List<T> elements = new ArrayList<>();

    public void add(T element) {
        elements.add(element);
    }

}

class MyCollection<T> {
    private List<T> elements = new ArrayList<>();

    public void add(T element) {
        elements.add(element);
    }
}
