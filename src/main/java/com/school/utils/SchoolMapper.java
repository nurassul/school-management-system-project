package com.school.utils;

import com.school.domain.SchoolEntity;
import com.school.dto.School;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, TeacherMapper.class})
public interface SchoolMapper {
    @Mapping(target = "id", source = "id")
    School toDto(SchoolEntity entity);

    SchoolEntity toEntity(School dto);
}