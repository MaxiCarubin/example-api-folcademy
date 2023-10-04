package com.folcademy.exampleapi.Models.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
}
