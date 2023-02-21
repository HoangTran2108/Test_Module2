package Controller;

import Model.Student;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {
    private List<Student> studentList= new ArrayList<>();
    private ReadWriteFile readWriteFile = new ReadWriteFile(studentList);

    public StudentManager() {
    }

    public StudentManager(List<Student> studentList, ReadWriteFile readWriteFile) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
    public void addNewStudent(Student student) {
        studentList.add(student);
        writeFile();
    }
    public void editStudentById(String inputID, Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (inputID.equals(studentList.get(i).getId())) {
                studentList.set(i, student);
                break;
            }
        }
        writeFile();
    }
    public String removeStudentById(String inputID) {
        for (Student student : studentList) {
            if (inputID.equals(student.getId())) {
                studentList.remove(student);
                return "Xóa thành công";
            }
        }
        writeFile();
        return "Không tìm được sinh viên với mã sinh viên trên";
    }
    public void displayStudent() {
        readFile();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
    public void sortStudentByPoint() {
        Collections.sort(studentList);
        writeFile();
    }
    public void readFile(){
        studentList = readWriteFile.readFromFile();
    }
    public void writeFile(){
        studentList = readWriteFile.writeToFile(studentList);
    }
}
