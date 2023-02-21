package storage;

import Model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public File file = new File("student.dat");

    public ReadWriteFile(List<Student> studentList) {
    }

    public List<Student> writeToFile(List<Student> studentList) {
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream fos = new ObjectOutputStream(os);
            fos.writeObject(studentList);
            fos.close();
            os.close();
        } catch (Exception e) {
            System.err.println("Lỗi ghi file");
        }
        return studentList;
    }
    public List<Student> readFromFile() {
        List<Student> students = new ArrayList<>();
        FileInputStream stream;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(stream);
            students = (List<Student>) ois.readObject();
            ois.close();
            stream.close();
        } catch (Exception e) {
            System.err.println("Lỗi đọc file");
        }
        return students;
    }
}