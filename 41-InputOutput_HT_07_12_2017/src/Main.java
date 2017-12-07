import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            Scanner scanner = new Scanner(System.in);
            String s;

            @Override
            public void run() {
                int i = 0;
                while(true){
                    s = scanner.nextLine();
                    i++;

                    if(s.equals("-1")) break;
                    try {
                        writeFile(s + "\n", Integer.toString(i) );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    thread.run();


    }

    private static void createFile() throws FileNotFoundException {
        File file = new File("/users/asx/Documents/files/file.txt");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = System.out;
    }

    private static void writeFile(String s, String name) throws IOException{

        FileWriter fileWriter = new FileWriter("/users/asx/Documents/files/file" + name +".txt", true);
        fileWriter.write(s);
        fileWriter.flush();

    }
}
