package com.school.utils;


import com.school.domain.StudentEntity;
import com.school.dto.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toDto(StudentEntity entity);

    StudentEntity toEntity(Student dto);
}
