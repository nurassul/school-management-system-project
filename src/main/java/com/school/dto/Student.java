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
public class Student extends Person {

    private double gpa;
    private String group;

    public boolean isExcellent() {
        return gpa >= 3.5;
    }

    @Override
    public String getRoleDetails() {
        return "Student: " + group + ", GPA: " + gpa;
    }

    @Override
    public String toString() {
        return super.toString() + " | Role: Student" + " | GPA: " + gpa + " | group: " + group;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Double.compare(gpa, student.gpa) == 0 && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gpa, group);
    }

}
