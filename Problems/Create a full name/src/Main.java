// Don't delete scanner import
import java.util.Scanner;

class Name {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.next();
        String lastName1 = scanner.next();
        createFullname(name1,lastName1);

    }

    //implement your method here
    public static String createFullname(String name1, String lastName1) {
        return name1 + " " + lastName1;
    }
}