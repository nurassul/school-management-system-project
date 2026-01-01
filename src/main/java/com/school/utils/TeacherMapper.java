package com.school.utils;


import com.school.domain.TeacherEntity;
import com.school.dto.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mapping(target = "id", source = "id")
    Teacher toDto(TeacherEntity entity);

    TeacherEntity toEntity(Teacher dto);
}
