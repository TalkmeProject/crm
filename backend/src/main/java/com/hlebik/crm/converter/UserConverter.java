package com.hlebik.crm.converter;

import com.hlebik.crm.dbo.UserDbo;
import com.hlebik.crm.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class UserConverter implements DtoConverter<UserDto, UserDbo> {
    @Override
    public UserDto convertToDto(@NotNull UserDbo dbo) {
        if (dbo == null) return null;
        final UserDto dto = new UserDto();
        BeanUtils.copyProperties(dbo, dto);
        return dto;
    }

    @Override
    public UserDbo convertToDbo(UserDto dto) {
        final UserDbo dbo = new UserDbo();
        BeanUtils.copyProperties(dto, dbo);
        return dbo;
    }
}