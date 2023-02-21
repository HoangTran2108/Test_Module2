package Model;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double averagePoint;

    public Student() {
    }

    public Student(String id, String name, int age, String gender, String address, double averagePoint) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averagePoint = averagePoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(double averagePoint) {
        this.averagePoint = averagePoint;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", averagePoint=" + averagePoint +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return (int)(this.getAveragePoint()-o.getAveragePoint());
    }
}
