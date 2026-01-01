package com.school.service;

import com.school.domain.SchoolEntity;
import com.school.domain.StudentEntity;
import com.school.dto.SchoolType;
import com.school.dto.Student;
import com.school.repository.SchoolRepository;
import com.school.repository.StudentRepository;
import com.school.utils.StudentMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;
    private final StudentMapper mapper;



    @Transactional
    public Student create(Student dto) {
        return mapper.toDto(studentRepository.save(mapper.toEntity(dto)));
    }

    @Transactional(readOnly = true)
    public Student getById(Long studentId) {
        return studentRepository.findById(studentId)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Student not found!"));
    }

    @Transactional
    public Student update(Long id, Student dto) {
        StudentEntity entity = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found!"));

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setGpa(dto.getGpa());
        entity.setGroup(dto.getGroup());
        return mapper.toDto(studentRepository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void enrollStudent(Long schoolId, Long studentId) {
        SchoolEntity school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new EntityNotFoundException("School not found!"));

        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found!"));

        if (student.getSchool() != null && student.getSchool().getId().equals(schoolId)) {
            throw new IllegalArgumentException("Student already enrolled!");
        }

        if (school.getType() == SchoolType.GYMNASIUM || school.getType() == SchoolType.LICEUM) {

            if (student.getGpa() >= 2.5) {
                student.setSchool(school);
                studentRepository.save(student);
                System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + " successfully added!");
            } else {
                System.out.println("Rejected: Low GPA! " + student.getGpa());
            }
        } else {
            student.setSchool(school);
        }
        studentRepository.save(student);
    }



}
