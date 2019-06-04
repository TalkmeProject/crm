package com.hlebik.crm.converter;

import com.hlebik.crm.dbo.CustomerStatusDbo;
import com.hlebik.crm.dto.CustomerStatusDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerStatusConverter implements DtoConverter<CustomerStatusDto, CustomerStatusDbo> {
    @Override
    public CustomerStatusDto convertToDto(CustomerStatusDbo dbo) {
        final CustomerStatusDto dto = new CustomerStatusDto();
        BeanUtils.copyProperties(dbo, dto);
        return dto;
    }

    @Override
    public CustomerStatusDbo convertToDbo(CustomerStatusDto dto) {
        final CustomerStatusDbo dbo = new CustomerStatusDbo();
        BeanUtils.copyProperties(dto, dbo);
        return dbo;
    }
}