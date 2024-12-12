package com.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;

    @NotEmpty(message = "area is mandatory")
    @Column(columnDefinition = "varchar(50) not null")
    private String area;

    @NotEmpty(message = "street is mandatory")
    @Column(columnDefinition = "varchar(50) not null")
    private String street;

    @Positive(message = "buildingNumber must be positive")
    @Column(columnDefinition = "int null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
