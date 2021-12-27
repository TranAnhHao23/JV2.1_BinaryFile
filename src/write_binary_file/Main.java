package write_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, "Hao", "111");
        Student student2 = new Student(2, "Nam", "222");
        Student student3 = new Student(3, "An", "333");
        students.add(student1);
        students.add(student2);
        students.add(student3);

        writeToFile(students, "src/write_binary_file/writeFile");
        List<Student> studentList = readToFile("src/write_binary_file/writeFile");
        studentList.forEach(System.out::println);

    }

    public static void writeToFile(List<Student> students, String pathName) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathName));
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
        } catch (IOException | ClassCastException e) {
            System.err.println(e.getMessage());
        }

    }

    public static List<Student> readToFile(String pathName) {
        List<Student> studentList = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathName));
            studentList = (List<Student>) objectInputStream.readObject();

        } catch (IOException | ClassCastException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
