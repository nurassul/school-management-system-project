package com.school.controller;


import com.school.dto.School;
import com.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;


    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(
            @PathVariable("id") Long id
    ) {
        log.info("Called getSchoolById: id={}", id);

        return ResponseEntity.ok(schoolService.getById(id));
    }


    @GetMapping
    public ResponseEntity<List<School>> getAllSchools(){
        log.info("Called getAllSchools:");

        return ResponseEntity.ok(schoolService.getAll());
    }

    @PostMapping("/registration")
    public ResponseEntity<School> createSchool(
        @RequestBody School school
    ) {
        log.info("Called createSchool:");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(schoolService.createSchool(school));
    }


    @PostMapping("/update/{schoolId}")
    public ResponseEntity<School> updateSchool(
            @PathVariable("schoolId") Long schoolId,
            @RequestBody School schoolToUpdate
    ) {
        log.info("Called updateSchool: id={}", schoolId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(schoolService.update(schoolId, schoolToUpdate));
    }

    @DeleteMapping("/hard-delete/{id}")
    public ResponseEntity<Void> deleteSchool(
            @PathVariable("id") Long id
    ) {
        log.info("Called hard deleteSchool");

        schoolService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
