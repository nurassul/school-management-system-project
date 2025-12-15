package entities;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class School {

    private String name;
    private String address;
    private String typeOfSchool;
    private double rating;
    private double averageGpa;
    private List<Student> students;
    private Teacher[] teachers;


    public School() {

    }

    public double calculateAverageGpa() {
        double sum = 0;
        for (Student s : students) {
            sum += s.getGpa();
        }

        return sum / students.size();
    }

    public Teacher findTeacherBySubject(String subject) {
        for (Teacher t : teachers) {
            if (t.getSubject().equals(subject)){
                return t;
            }
        }

        return null;
    }

    public void printInfo() {
        System.out.println("School: " + name + " address: " + address + " type of school: " + typeOfSchool + " rating: " + rating);
        System.out.println("Students: " + students.size());
        System.out.println("Average GPA: " + averageGpa);
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

    public School(String name, String address, String typeOfSchool, double rating, List<Student> students, Teacher[] teachers) {
        this.name = name;
        this.address = address;
        this.typeOfSchool = typeOfSchool;
        this.rating = rating;
        this.students = students;
        this.teachers = teachers;
        this.averageGpa = calculateAverageGpa();
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public String getTypeOfSchool() {
        return typeOfSchool;
    }

    public void setTypeOfSchool(String typeOfSchool) {
        this.typeOfSchool = typeOfSchool;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getAverageGpa() {
        return averageGpa;
    }


    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", typeOfSchool='" + typeOfSchool + '\'' +
                ", rating=" + rating +
                ", averageGpa=" + averageGpa +
                ", students=" + students +
                ", teachers=" + Arrays.toString(teachers) +
                '}';
    }
}
