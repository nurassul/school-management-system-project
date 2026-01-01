package com.school.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class StudentEntity extends PersonEntity {

    private double gpa;

    @Column(name = "student_group")
    private String group;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

}
