public class StringComparison {
    public static void main(String[] args) {
        String myCountry = "India";
        String yourCountry = new String("Mexico");

        String name1 = "Joe"; //an implicit object is created
        String name2 = new String("Joe"); //an explicit object is created
        //String name2 = "Joe";
        String name3 = "Joe";//refers to the same implicit object
        name3 = "John";
        name3 = "Joe"; //Points to the implicit object for Joe; ie., same as name1
        String name4 = new String("Joe");
        if (name1 == name2) { //== compares the references and not the values
            System.out.println("name1 == name2");
        } else {
            System.out.println("name1 != name2");
        }
        if (name1.equals(name2)) {//.equals compares the values
            System.out.println("name1 is equal to name2");
        }
        name1 = null; //equivalent of deletion though the memory used is still intact
    }
}
