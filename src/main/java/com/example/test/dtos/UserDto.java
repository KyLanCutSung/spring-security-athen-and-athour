package com.example.test.dtos;

import com.example.test.models.countries.dtos.CountryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private CountryDto countryDto;
    private List<RoleDto> roleDtoList;
}
