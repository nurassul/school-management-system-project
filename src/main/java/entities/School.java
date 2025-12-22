package entities;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class School {

    // main fields
    private String name;
    private String address;
    private SchoolType schoolType;

    // additional fields
    private double rating;

    // members fields
    @Builder.Default
    private List<Student> students = new ArrayList<>();

    @Builder.Default
    private List<Teacher> teachers = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
    }



    public void printInfo() {
        System.out.println("================");
        System.out.println("School: " + name + " address: " + address + " type of school: " + schoolType + " rating: " + rating);
        System.out.println("Students: " + students.size());
        System.out.println("Teachers: " + teachers.size());
        System.out.println("================");
    }

   public void printAllStudents() {
        if(students != null) {
            for (Student s : students) {
                System.out.println(s.toString());
            }
        }
   }

    public void printAllTeachers() {
        if(students != null) {
            for (Teacher t : teachers) {
                System.out.println(t.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "School: " + name + " | address: " + address + " | type of school: " + schoolType + " | rating: " + rating;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Double.compare(rating, school.rating) == 0 && Objects.equals(name, school.name) && Objects.equals(address, school.address) && schoolType == school.schoolType && Objects.equals(students, school.students) && Objects.equals(teachers, school.teachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, schoolType, rating, students, teachers);
    }


}
