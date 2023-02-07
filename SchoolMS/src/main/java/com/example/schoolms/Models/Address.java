package com.example.schoolms.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "address")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotEmpty
    private String area;
    @NotEmpty
    private String street;
    @NotNull
    private int buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
