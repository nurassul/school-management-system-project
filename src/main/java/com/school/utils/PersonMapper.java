package com.school.utils;

import com.school.domain.PersonEntity;
import com.school.dto.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    void updatePersonFromDto(Person dto, @MappingTarget PersonEntity entity);
}