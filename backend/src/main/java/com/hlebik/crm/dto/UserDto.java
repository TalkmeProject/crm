package com.hlebik.crm.dto;

import com.hlebik.crm.enumerated.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
    private String userName;
    private String password;
    private boolean active;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Role> roles;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CustomerDto customerDto;
}
