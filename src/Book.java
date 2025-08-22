public class Book {
    int id;
    String name;
    String genre;
    String author;

    @Override
    public String toString() {
        return "Book:" +
                "\n id=" + id +
                "\n name='" + name + '\'' +
                "\n genre='" + genre + '\'' +
                "\n author='" + author + '\'';
    }
}
