import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Book> libraryBooks = new ArrayList<>();
    private static int bookIndex = 1;

    public static void main(String[] args) {
        //checkWords(); // проверяет есть ли такое колтчество одинаковых слов
        //checkTwoSums(); // 2-zadacha
        //checkTwoPointers(); // 4-zadacha
        library();


    }

    private static void library() {
        int x = 1;
        while (x > 0) {
            System.out.println("Main menu:");
            System.out.println("1. Add a book" +
                    "\n2. Get the list of all existing books" +
                    "\n3. Get information about a book" +
                    "\n4. Delete a book" +
                    "\n5. Stop");
            int option1 = scanner.nextInt();
            switch (option1) {
                case 1 -> addBook();
                case 2 -> getTheList();
                case 3 -> getInfo();
                case 4 -> deleteBook();
                case 5 -> x = 0;
            }
        }
    }

    private static void deleteBook() {
        System.out.println("Enter the id of the book");
        Book remove = libraryBooks.remove(scanner.nextInt());
        if (remove != null) {
            System.out.println("Successfully deleted");
        } else System.out.println("There is no book with such an id");
    }

    private static void getInfo() {
        System.out.println("Enter the id of the book");
        int id = scanner.nextInt();
        Book book = libraryBooks.get(id);
        if (book != null) {
            System.out.println(book);
        }
    }

    private static void getTheList() {
        for (Book libraryBook : libraryBooks) {
            System.out.println(libraryBook.name);
        }
    }

    private static void addBook() {
        Book newBook = new Book();
        newBook.id = bookIndex++;
        System.out.println("Enter the name of the book:");
        newBook.name = scanner.nextLine();
        System.out.println("Enter the author");
        newBook.author = scanner.nextLine();
        System.out.println("Enter the genre:");
        newBook.genre = scanner.nextLine();
        libraryBooks.add(newBook);
        System.out.println("Book successfully added");
    }

    public static void checkTwoPointers() {
        System.out.println("3-nd task: Enter some numbers. How many numbers do you wanna enter?");
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Good, now enter the " + (i + 1) + "-number: ");
            input[i] = scanner.nextInt();
        }
        int[] result = twoPointers(input);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoPointers(int[] numbers) {
        int count = 0;
        for (int i = 0; i <numbers.length; i++) {
            for (int j = 0; j <numbers.length; j++) {
                if (i==j) continue;
                if (numbers[i] == numbers[j]) {
                    numbers[j] = -1;
                    count ++;
                }
            }
        }
        int[] result = new int[numbers.length - count];
        int x = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != -1) {
                result[x] = numbers[i];
            }
        }
        return result;
    }

    public static void checkTwoSums() {
        System.out.println("2-nd task: Enter some numbers. How many numbers do you wanna enter?");
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Good, now enter the " + (i + 1) + "-number: ");
            input[i] = scanner.nextInt();
        }
        System.out.println("Now enter the point number:");
        int point = scanner.nextInt();
        if (twoSums(input, point) != null) {
            System.out.println(Arrays.toString(twoSums(input, point)));
        } else System.out.println("there are no matching numbers");
    }

    public static int[] twoSums(int[] numbers, int point) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int sum = numbers[i];
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                if (point == sum + numbers[j]) {
                    result[0] = numbers[i];
                    result[1] = numbers[j];
                    return result;
                }
            }
        }
        return null;
    }

    public static void checkWords() {
        System.out.println("1-st task: Enter text and a number");
        String text = scanner.nextLine();
        int n = scanner.nextInt();
        String check = wordCount(text, n);
        if (check != null) {
            System.out.println(check);
        } else {
            System.out.println("There are not n number of similar words");
        }
    }

    public static String wordCount(String str, int n) {
        String[] words = str.replaceAll("[^a-zA-Z0-9 ]", "")
                .split("\\s+");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
            if (count == n) {
                return words[i];
            }
        }
        return null;
    }
}