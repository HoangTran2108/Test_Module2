package views;

import Controller.StudentManager;
import Model.Student;
import java.util.Scanner;

public class Main {
    private static final StudentManager studentManager = new StudentManager();
    private static final Scanner input = new Scanner(System.in);

    public static int checkInput;

    public static void main(String[] args) {
        do {
            System.out.println("""
                    -----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN--------
                    chọn chức năng theo số (để tiếp tục)
                    1. Xem danh sách sinh viên
                    2. Thêm mới
                    3. Cập nhật
                    4. Xóa
                    5. Sắp xếp
                    6. Đọc từ file
                    7. Ghi vào file
                    8. Thoát
                    chọn chức năng :
                    """);
            checkInput = checkInputInt();
            switch (checkInput) {
                case 1 -> studentManager.displayStudent();
                case 2 -> studentManager.addNewStudent(addStudent());
                case 3 -> editProfile();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Sắp xếp sinh viên theo điểm từ tấp đến cao:");
                    studentManager.sortStudentByPoint();
                    studentManager.displayStudent();
                }
                case 6 -> studentManager.readFile();
                case 7 -> studentManager.writeFile();
                case 8 -> System.out.println("Hẹn gặp lại!");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        } while (checkInput != 8);
    }

    public static Student addStudent() {
        System.out.println("Nhập mã sinh viên:");
        String id = checkStudentId();
        System.out.println("Nhập họ tên:");
        String name = input.nextLine();
        System.out.println("Nhập tuổi:");
        int age = checkInputInt();
        System.out.println("Giới tính:");
        String gender = input.nextLine();
        System.out.println("Nhập địa chỉ:");
        String address = input.nextLine();
        System.out.println("Nhập Điểm trung bình:");
        double averagePoint = checkInputDouble();
        return new Student( id, name, age, gender, address, averagePoint);
    }
    public static void editProfile() {
        String id = checkStudentId1();
        System.out.println("Nhập họ tên mới:");
        String name = input.nextLine();
        System.out.println("Nhập tuổi mới:");
        int age = checkInputInt();
        System.out.println("Giới tính:");
        String gender = input.nextLine();
        System.out.println("Nhập địa chỉ mới:");
        String address = input.nextLine();
        System.out.println("Nhập Điểm trung bình mới:");
        double averagePoint = checkInputDouble();
        Student student = new Student(id, name, age, gender, address, averagePoint);
        studentManager.editStudentById(id, student);
    }
    public static void deleteStudent() {
        System.out.println("Nhập mã sinh viên muốn xóa:");
        String id = input.nextLine();
        System.out.println(studentManager.removeStudentById(id));
    }

    public static int checkInputInt() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số theo yêu cầu");
            return checkInputInt();
        }
    }

    public static double checkInputDouble() {
        try {
            return Double.parseDouble(input.nextLine());
        } catch (Exception e) {
            System.out.println("Vui lòng nhập số theo yêu cầu");
            return checkInputDouble();
        }
    }
    public static String checkStudentId() {
        String id = input.nextLine();
        for (Student o : studentManager.getStudentList()) {
            while (true) {
                if (o.getId().equals(id)) {
                    System.out.println("mã sinh viên bị trùng, vui lòng nhập lại");
                    id = input.nextLine();
                } else {
                    break;
                }
            }
        }
        return id;
    }
    public static String checkStudentId1() {
        System.out.println("Nhập mã sinh viên muốn sửa: ");
        String id = input.nextLine();
        for (int i = 0; i < studentManager.getStudentList().size(); i++) {
            if (id.equals(studentManager.getStudentList().get(i).getId())) {
                return id;
            }
        }
        System.err.println("Không có mã sinh viên cân tìm");
        return checkStudentId1();
    }
}