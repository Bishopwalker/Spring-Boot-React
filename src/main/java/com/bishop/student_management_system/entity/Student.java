package com.bishop.student_management_system.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "student_seq")
    private Long id;


    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;


}
