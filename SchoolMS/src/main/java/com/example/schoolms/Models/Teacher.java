package com.example.schoolms.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Table(name = "teachers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "teacher_id")
    @NotNull
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotNull
    private int age;
    @NotNull
    private double salary;

    //when ever we create/delete/update teacher we need to do the same for address
    // means we need to create address first
    // also onetpone will create a foreign key in this table, and the name will be
    // the reference table which's address
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    //join is to choose the foreign key name in DB
    @JoinColumn(name = "fk_address_id")
    @PrimaryKeyJoinColumn
    private Address address;

}
