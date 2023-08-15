import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        System.out.println("Please enter a string: ");
        String string = new Scanner(System.in).nextLine();

        Document document = new Document(string);
        System.out.println("Number of word: " + document.countWord());
        System.out.println("Number of character A(a): " + document.countA());
        System.out.println("String before formalize: " + document.getText());
        System.out.println("String after formalize: " + document.formalizeString());
    }
}
