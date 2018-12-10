package com.hlebik.crm.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class CustomerDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mainImage;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CustomerStatusDto customerStatusDto;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserDto userDto;
}
