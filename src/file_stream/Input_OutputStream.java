package file_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Input_OutputStream {
    public static void main(String[] args) {
        try {
        FileOutputStream fileOutputStream = new FileOutputStream("src/file_stream/inputStream");
            for (int i = 1; i <= 10; i++) {
                fileOutputStream.write(i);
            }
            fileOutputStream.close();
            FileInputStream fileInputStream = new FileInputStream("src/file_stream/inputStream");
            int value;
            while ((value = fileInputStream.read()) != -1){
                System.out.print(value + " ");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
