package com.school.controller;


import com.school.dto.Student;
import com.school.dto.Teacher;
import com.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(
            @PathVariable("id") Long id
    ) {
        log.info("Called getTeacherById: id={}", id);

        return ResponseEntity.ok(teacherService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        log.info("Called getAllTeachers:");

        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @PostMapping("/registration")
    public ResponseEntity<Teacher> createTeacher(
            @RequestBody Teacher teacher
    ){
        log.info("Called createTeacher:");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(teacherService.createTeacher(teacher));
    }


    @PostMapping("/update/{id}")
    public ResponseEntity<Teacher> updateTeacher(
            @PathVariable("id") Long id,
            @RequestBody Teacher teacherToUpdate
    ){
        log.info("Called updateTeacher: id={}", id);

        return ResponseEntity.ok(teacherService.update(id,teacherToUpdate));
    }


    @DeleteMapping("/hard-delete/{id}")
    public ResponseEntity<Void> deleteTeacher(
            @PathVariable("id") Long id
    ) {
        log.info("Called hard deleteTeacher:");

        teacherService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

    @PostMapping("/enroll/{teacherId}/{schoolId}")
    public ResponseEntity<Void> hireStudent(
            @PathVariable("teacherId") Long teacherId,
            @PathVariable("schoolId") Long schoolId
    ) {
        log.info("Called hireTeacher: teacherId={}, schoolId={}", teacherId, schoolId);

        teacherService.hireTeacher(schoolId, teacherId);

        return ResponseEntity
                .status(HttpStatus.OK).build();
    }
}
