package data_stream;

import java.io.*;

public class Input_OutputStream2 {
    public static void main(String[] args) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src/data_stream/InputStream"));
            dataOutputStream.writeInt(10);
            dataOutputStream.writeInt(11);
            dataOutputStream.writeInt(12);
            dataOutputStream.close();
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/data_stream/InputStream"));
            int value;
                while ((value = dataInputStream.readInt()) != -1) {
                    System.out.println(value);
                }
        } catch (IOException e) {
            System.err.println("All data were read!!!");
        }
    }
}
