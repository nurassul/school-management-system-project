package com.school.service;

import com.school.domain.SchoolEntity;
import com.school.domain.TeacherEntity;
import com.school.dto.Teacher;
import com.school.repository.SchoolRepository;
import com.school.repository.TeacherRepository;
import com.school.utils.TeacherMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final SchoolRepository schoolRepository;
    private final TeacherMapper teacherMapper;


    @Transactional
    public Teacher create(Teacher dto) {
        return teacherMapper.toDto(teacherRepository.save(teacherMapper.toEntity(dto)));
    }

    @Transactional(readOnly = true)
    public Teacher getById(Long id) {
        return teacherRepository.findById(id).map(teacherMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found!"));
    }

    @Transactional
    public Teacher update(Long id, Teacher dto) {
        TeacherEntity entity = teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found!"));

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSubject(dto.getSubject());
        entity.setDegree(dto.getDegree());
        return teacherMapper.toDto(teacherRepository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Transactional
    public void hireTeacher(Long schoolId, Long teacherId) {
        SchoolEntity school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new EntityNotFoundException("School not found!"));
        TeacherEntity teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found!"));

        teacher.setSchool(school);
        teacherRepository.save(teacher);
    }


}
