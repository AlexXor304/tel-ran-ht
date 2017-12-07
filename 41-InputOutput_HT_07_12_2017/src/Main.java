import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            Scanner scanner = new Scanner(System.in);
            String s;

            @Override
            public void run() {
                while (true) {
                    s = scanner.nextLine();

                    if (s.equals("-1")) break;
                    if (!s.equals("")) {
                        integer.getAndIncrement();
                        try {
                            writeFile(s + "\n", Integer.toString(Integer.parseInt(integer.toString())));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });
        thread.run();


    }

    private static void writeFile(String s, String name) throws IOException {

        FileWriter fileWriter = new FileWriter("/users/asx/Documents/files/file" + name + ".txt", false);
        fileWriter.write(s);
        fileWriter.flush();

    }
}
