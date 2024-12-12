package com.example.schoolmanagement.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;
    @NotEmpty(message = "area is mandatory")
    private String area;
    @NotEmpty(message = "street is mandatory")
    private String street;
    @Positive(message = "buildingNumber must be positive")
    private Integer buildingNumber;


}
