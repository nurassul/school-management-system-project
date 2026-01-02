package com.school.controller;


import com.school.dto.Student;
import com.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;



    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable("id") Long id
    ) {
        log.info("Called getStudentById: id={}", id);

        return ResponseEntity.ok(studentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        log.info("Called getAllStudents:");

        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/registration")
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student
    ){
        log.info("Called createStudent:");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.createStudent(student));
    }


    @PostMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable("id") Long id,
            @RequestBody Student studentToUpdate
    ){
        log.info("Called updateStudent: id={}", id);

        return ResponseEntity.ok(studentService.update(id,studentToUpdate));
    }


    @DeleteMapping("/hard-delete/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable("id") Long id
    ) {
        log.info("Called hard deleteStudent:");

        studentService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

    @PostMapping("/enroll/{studentId}/{schoolId}")
    public ResponseEntity<Void> enrollStudent(
            @PathVariable("studentId") Long studentId,
            @PathVariable("schoolId") Long schoolId
    ) {
        log.info("Called enrollStudent: studentId={}, schoolId={}", studentId, schoolId);

        studentService.enrollStudent(schoolId, studentId);

        return ResponseEntity
                .status(HttpStatus.OK).build();
    }


}
