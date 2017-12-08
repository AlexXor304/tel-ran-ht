import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class FileThread extends Thread {

    String text;

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
