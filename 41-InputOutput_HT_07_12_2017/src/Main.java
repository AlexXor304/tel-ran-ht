import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s;

        while (true) {
            s = scanner.nextLine();
            if (s.equals("-1")) break;
            if (!s.equals("")) {
                new FileThread(s).start();
            }
        }

    }
}