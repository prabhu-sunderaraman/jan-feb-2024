//Book is a Java Bean
public class Book {
    private String title;
    private double price;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public void buy(String store) {
        System.out.println("Buying " + title + " from " + store);
    }

    public void buy(String store, int quantity) {
        System.out.println("Buying %s of %s from %s".formatted(quantity, title, store));
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
