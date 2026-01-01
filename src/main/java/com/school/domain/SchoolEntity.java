package com.school.domain;


import com.school.dto.SchoolType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schools")
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String address;

    @Enumerated(EnumType.STRING)
    private SchoolType type;

    private double rating;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<StudentEntity> students;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<TeacherEntity> teachers;


}
