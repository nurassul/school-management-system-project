package com.school.service;

import com.school.domain.SchoolEntity;
import com.school.domain.StudentEntity;
import com.school.dto.School;
import com.school.repository.SchoolRepository;
import com.school.utils.SchoolMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;



    @Transactional
    public School createSchool(School dto) {
        SchoolEntity schoolEntity = schoolMapper.toEntity(dto);
        return schoolMapper.toDto(schoolRepository.save(schoolEntity));
    }

    @Transactional(readOnly = true)
    public School getById(Long schoolId){
        return schoolRepository.findById(schoolId)
                .map(schoolMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("School not found!"));
    }

    @Transactional(readOnly = true)
    public List<School> getAll() {
        return schoolRepository
                .findAll()
                .stream()
                .map(schoolMapper::toDto)
                .toList();
    }

    @Transactional
    public School update(Long id, School dto) {
        SchoolEntity entity = schoolRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("School not found!"));

        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setRating(dto.getRating());
        return schoolMapper.toDto(schoolRepository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }



    @Transactional(readOnly = true)
    protected double calculateAverageGPA(Long schoolId) {
        SchoolEntity school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School not found!"));

        return school.getStudents().stream()
                .mapToDouble(StudentEntity::getGpa)
                .average()
                .orElse(0.0);
    }



    @Transactional(readOnly = true)
    public void printFullInfoSchool(Long schoolId) {
        School school = getById(schoolId);
        System.out.println("School: " + school.getName() + " | Rating: " + school.getRating());
        System.out.println("Average GPA: " + calculateAverageGPA(schoolId));
        System.out.println("Students: " + school.getStudents().size());
        System.out.println("Teachers: " + school.getTeachers().size());
    }



}
