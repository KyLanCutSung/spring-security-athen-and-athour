package com.example.test.dtos;

import com.example.test.models.countries.dtos.CountryDto;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private CountryDto countryDto;
    private List<RoleDto> roleDtoList;
}
