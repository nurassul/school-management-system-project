package com.school.utils;

import com.school.domain.SchoolEntity;
import com.school.dto.School;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, TeacherMapper.class})
public interface SchoolMapper {

    @Mapping(target = "schoolType", source = "schoolType")
    School toDto(SchoolEntity entity);

    @Mapping(target = "schoolType", source = "schoolType")
    SchoolEntity toEntity(School dto);
}