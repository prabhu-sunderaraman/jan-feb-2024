public class AnnotationsExample {
    public static void main(String[] args) {

    }
}

@Comment("This is a book")
class Book {

    @Comment("This is a field")
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Comment("This is a method")
    public void print() {
        System.out.println("Book");
    }
}
