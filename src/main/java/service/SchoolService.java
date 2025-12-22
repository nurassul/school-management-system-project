package service;

import entities.School;
import entities.SchoolType;
import entities.Student;
import entities.Teacher;

import java.util.Comparator;
import java.util.List;

public class SchoolService {


    // data pool management methods
    public void enrollStudent(School school, Student student) {
        if (school.getStudents().contains(student)) {
            System.out.println("Student already enrolled!");
            return;
        }

        if (school.getSchoolType().equals(SchoolType.GYMNASIUM) || school.getSchoolType().equals(SchoolType.LICEUM)) {
            if (student.getGpa() >= 2.5) {
                school.addStudent(student);
            } else {
                System.out.println("Rejected: the student has a low GPA: " + student.getFirstName() + " " + student.getLastName());
            }
        } else {
            school.addStudent(student);
            System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + " successfully added!");
        }
    }

    public void hireTeacher(School school, Teacher teacher) {
        if (school.getTeachers().contains(teacher)) {
            System.out.println("Teacher already hired!");
            return;
        }

        school.addTeacher(teacher);
        System.out.println("Teacher: " + teacher.getFirstName() + " " + teacher.getLastName() + " successfully hired!");
    }


    // filter methods
    public void showStudentWithFilterGPA(School school, double minGPA) {
        school.getStudents()
                .stream()
                .filter(s -> s.getGpa() >= minGPA)
                .forEach(System.out::println);
    }

    public void showTeacherWithFilterDegree(School school, String degree) {
        school.getTeachers()
                .stream()
                .filter(t -> t.getDegree().equals(degree))
                .forEach(System.out::println);
    }


    // sorting methods
    public void sortStudentsByAge(School school) {
        school.getStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getAge))
                .forEach(System.out::println);

    }

    public void sortSchoolsByRating(List<School> schoolList) {
        schoolList.stream()
                .sorted(Comparator.comparing(School::getRating))
                .forEach(System.out::println);

    }


    // searching methods
    public Student findStudentByIdInSchool(School school, int id) {
        Student student = school.getStudents()
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        return student;
    }

    public Teacher findTeacherBySubject(School school, String subject) {
        return school.getTeachers()
                .stream()
                .filter(t -> t.getSubject().equals(subject))
                .findFirst()
                .orElse(null);
    }

    // show full info
    public void printFullInfoSchool(School school) {
        school.printInfo();
        System.out.println("All Students information:");
        school.printAllStudents();
        System.out.println("================");
        System.out.println("All Teachers information:");
        school.printAllTeachers();
        System.out.println("================");
        System.out.println("Average GPA of School: " + calculateAverageGPA(school));
    }

    public double calculateAverageGPA(School school) {
        double avg = 0;

        for (Student s : school.getStudents()) {
            avg += s.getGpa();
        }

        return avg / school.getStudents().size();
    }


}
