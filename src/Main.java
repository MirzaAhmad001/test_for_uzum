import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        checkWords(); // проверяет есть ли такое колтчество одинаковых слов


    }









    public static void checkWords() {
        Scanner scanner = new Scanner(System.in);
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
                    count ++;
                }
            }
            if (count == n) {
                return words[i];
            }
        }
        return null;
    }
}