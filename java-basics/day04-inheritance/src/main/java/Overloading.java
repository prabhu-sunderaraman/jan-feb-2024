public class Overloading {
    public static void main(String[] args) {
        Book book1 = new Book("Hacks");
        Book book2 = new Book("Scala tricks", 12.34d);
        book1.buy("Amazon");
        book1.buy("Flipkart", 3);
    }
}
