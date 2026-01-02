package com.school;

import com.school.dto.*;
import com.school.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(SchoolService schoolService,
//                                  StudentService studentService,
//                                  TeacherService teacherService) {
//        return args -> {
//            School liceumDto = School.builder()
//                    .name("It Liceum")
//                    .address("Al-Farabi, 77")
//                    .schoolType(SchoolType.LICEUM)
//                    .rating(5.0)
//                    .build();
//            School savedLiceum = schoolService.createSchool(liceumDto);
//            Long liceumId = savedLiceum.getId();
//
//
//            School secondarySchool = School.builder()
//                    .name("Secondary School №4")
//                    .address("Abay, 12")
//                    .schoolType(SchoolType.SECONDARY_SCHOOL)
//                    .rating(3.5)
//                    .build();
//            School savedSecondary = schoolService.createSchool(secondarySchool);
//            Long simpleSchoolId = savedSecondary.getId();
//
//
//            Student s1 = studentService.createStudent(Student.builder()
//                    .firstName("Nura").lastName("Bro").age(19).gpa(3.8).group("SE-23").build());
//
//            Student s2 = studentService.createStudent(Student.builder()
//                    .firstName("Ivan").lastName("Lo").age(18).gpa(2.1).group("SE-21").build());
//
//
//
//
//            System.out.println("Trying enroll Ivan");
//            studentService.enrollStudent(liceumId, s2.getId());
//
//
//            studentService.enrollStudent(liceumId, s1.getId());
//
//
//            studentService.enrollStudent(simpleSchoolId, s2.getId());
//
//
//            Teacher teacher1 = teacherService.createTeacher(Teacher.builder()
//                    .firstName("Amir").lastName("Black").subject("Calculus 2").degree("Master").build());
//
//            Teacher teacher2 = teacherService.createTeacher(Teacher.builder()
//                    .firstName("Sanzhar").lastName("White").subject("Java Core").degree("PhD").build());
//
//            teacherService.hireTeacher(liceumId, teacher1.getId());
//            teacherService.hireTeacher(liceumId, teacher2.getId());
//
//
//            schoolService.printFullInfoSchool(liceumId);
//
//
//        };
//    }
}