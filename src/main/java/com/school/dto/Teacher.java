package com.school.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Teacher extends Person {

    // specific fields of class
    private String subject;
    private String position;
    private String degree;


    @Override
    public String getRoleDetails() {
        return "Teacher: " + subject + ", position: " + position + ", degree: " + degree;
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: Teacher" + " | Subject: " + subject + " | position: " + position + " | degree: " + degree;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(subject, teacher.subject) && Objects.equals(position, teacher.position) && Objects.equals(degree, teacher.degree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject, position, degree);
    }


}
