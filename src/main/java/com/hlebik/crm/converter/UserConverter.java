package com.hlebik.crm.converter;

import com.hlebik.crm.dbo.UserDbo;
import com.hlebik.crm.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserConverter implements DtoConverter<UserDto, UserDbo> {
    @Override
    public UserDto convertToDto(UserDbo dbo) {
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