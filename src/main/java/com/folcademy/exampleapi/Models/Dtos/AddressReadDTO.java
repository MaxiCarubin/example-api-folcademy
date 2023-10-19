package com.folcademy.exampleapi.Models.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressReadDTO {
    private String number;
    private String street;
}
