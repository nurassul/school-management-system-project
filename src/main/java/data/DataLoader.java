package data;

import entities.School;
import entities.Student;
import entities.Teacher;
import service.SchoolService;

public class DataLoader {

    public static void loadData(School school, SchoolService service) {
        Student s1 = createStudent(1, "Nurassyl", "Broskie", 18, 3.52, "SE-25421");
        Student s2 = createStudent(2, "Amirzhan", "Black", 16, 2.9, "SE-25421");
        Student s3 = createStudent(3, "Magzhan", "Ulanuly", 17, 2.87, "SE-25421");
        Student s4 = createStudent(4, "John", "Garik", 17, 3.23, "SE-25421");

        Student s5 = createStudent(5, "Feduk", "Onelove", 18, 3.21, "CS-2505");
        Student s6 = createStudent(6, "Og", "Buda", 18, 3, "CS-2503");
        Student s7 = createStudent(7, "Sanzhar", "Omirzak", 19, 3.42, "CS-2505");
        Student s8 = createStudent(8, "Grisha", "Sorokin", 16, 2.49, "CS-2505");

        service.enrollStudent(school, s1);
        service.enrollStudent(school, s2);
        service.enrollStudent(school, s3);
        service.enrollStudent(school, s4);
        service.enrollStudent(school, s5);
        service.enrollStudent(school, s6);
        service.enrollStudent(school, s7);
        service.enrollStudent(school, s8);

        Teacher teacherCalculus = createTeacher(1,"Maksat", "Smith", 32, "Calculus", "Teacher", "Master");
        Teacher teacherHistory = createTeacher(1,"John", "Mike", 52, "History", "Head Teacher", "Master");
        Teacher teacherProgramming = createTeacher(1,"Aizere", "Hell", 22, "Calculus", "Teacher", "PHD");
        Teacher teacherPE = createTeacher(1,"Pasha", "Smith", 21, "Calculus", "Teacher", "PHD");
        Teacher teacherOOP = createTeacher(1,"Nurassyl", "Override", 45, "Calculus", "Head Teacher", "Master");

        service.hireTeacher(school, teacherCalculus);
        service.hireTeacher(school, teacherHistory);
        service.hireTeacher(school, teacherProgramming);
        service.hireTeacher(school, teacherPE);
        service.hireTeacher(school, teacherOOP);
    }

    private static Student createStudent(
            int id, String firstName, String lastName, int age, double gpa, String group
    ) {
        return new Student.StudentBuilder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .gpa(gpa)
                .group(group)
                .build();
    }

    private static Teacher createTeacher(
            int id, String firstName, String lastName, int age, String subject, String position, String degree
    ) {
        return new Teacher.TeacherBuilder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .subject(subject)
                .position(position)
                .degree(degree)
                .build();
    }

}
