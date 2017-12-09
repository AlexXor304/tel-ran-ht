import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

        while (true) {
            try {
                s = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (s.equals("-1")) break;
            if (!s.equals("")) {
                new FileThread(s).start();
            }
        }

    }
}

class FileThread extends Thread {

    private String text;

    public FileThread(String text) {
        this.text = text;
    }

    private static final AtomicInteger integer = new AtomicInteger(0);

    @Override
    public void run() {

        integer.getAndIncrement();
        writeFile(text + "\n", Integer.toString(Integer.parseInt(integer.toString())));
        System.out.println(Thread.currentThread().getName());

    }

    private void writeFile(String text, String name) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("/users/asx/Documents/files/file" + name + ".txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}