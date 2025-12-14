package entities;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class School {

    private String name;
    private String address;
    private Student[] students;
    private Teacher[] teachers;

    public School() {

    }

    public void printInfo() {
        System.out.println("School: " + name + " address: " + address);
        System.out.println("Students: " + students.length);
        System.out.println("Teachers: " + teachers.length);
    }

   public void printAllStudents() {
        for (Student s : students) {
            System.out.println(s.toString());
        }
   }

    public void printAllTeachers() {
        for (Teacher t : teachers) {
            System.out.println(t.toString());
        }
    }

    public School(String name, String address, Student[] students, Teacher[] teachers) {
        this.name = name;
        this.address = address;
        this.students = students;
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }


    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", students=" + Arrays.toString(students) +
                ", teachers=" + Arrays.toString(teachers) +
                '}';
    }
}
