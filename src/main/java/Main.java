import entities.School;
import entities.Student;
import entities.Teacher;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student(1,"Nura", "Broskie", 18, 3.52, "SE-2541");
        Student s2 = new Student(2,"Amir", "Black", 19, 3.12, "SE-2541");
        Student s3 = new Student(3,"Maga", "Ulan", 16, 3.21, "SE-2541");

        Student s4 = new Student(4,"Sanzhar", "Omirzak", 16, 2.91, "CS-2501");
        Student s5 = new Student(5,"Grisha", "Sorokin", 17, 2.89, "CS-2501");
        Student s6 = new Student(6,"Feduk", "Onelove", 18, 3.6, "CS-2501");
        Student s7 = new Student(7,"John", "Garik", 21, 2.89, "CS-2505");

        Student[] students1 = new Student[]{s1,s2,s3};
        Student[] students2 = new Student[]{s4,s5,s6,s7};

        Teacher teacherCalculus = new Teacher("John", "Mike", "Calculus", "Teacher", "Master");
        Teacher teacherProg = new Teacher("Bob", "Smith", "Programming","Head Teacher", "Master");


        Teacher[] teachers = new Teacher[]{teacherCalculus,teacherProg};

        School school1 = new School("Best School", "Esik, Abay 52", students1, teachers);
        School school2 = new School("1 High School", "Almaty, Satpaeva 21", students2, teachers);


        System.out.println("About schools 1:");
        school1.printInfo();
        System.out.println("Students of schools 1:");
        school1.printAllStudents();
        System.out.println("Teachers of schools 1:");
        school1.printAllTeachers();

        System.out.println("====================");

        System.out.println("About schools 2:");
        school2.printInfo();
        System.out.println("Students of schools 2:");
        school2.printAllStudents();
        System.out.println("Teachers of schools 2:");
        school2.printAllTeachers();

        System.out.println("====================");

        System.out.println("School1 students == School2 students: " + (school1.getStudents() == school2.getStudents()));
        System.out.println("School1 teachers == School2 teachers: " + (school1.getTeachers() == school2.getTeachers()));
        System.out.println("TeacherCalculus degree == TeacherProg degree: " + (teacherCalculus.getDegree().equals(teacherProg.getDegree())));
        System.out.println("TeacherCalculus position == TeacherProg position: " + (teacherCalculus.getPosition().equals(teacherProg.getPosition())));
        System.out.println("Student1 group == Student3 group: " + (s1.getGroup() == s2.getGroup()));
        System.out.println("Student2 group == Student5 group: " + (s2.getGroup() == s5.getGroup()));

        System.out.println("====================");

        for(Student s : students1) {
            if(s.isExcellent()){
                s.printStudentInfo();
                System.out.println(" is studying excellent");
            } else {
                s.printStudentInfo();
                System.out.println(" is studying good");
            }
        }
        for(Student s : students2) {
            if(s.isExcellent()){
                s.printStudentInfo();
                System.out.println(" is studying excellent");
            } else {
                s.printStudentInfo();
                System.out.println(" is studying good");
            }
        }







    }

}
