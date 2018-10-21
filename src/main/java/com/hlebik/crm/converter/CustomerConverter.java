package com.hlebik.crm.converter;

import com.hlebik.crm.dbo.CustomerDbo;
import com.hlebik.crm.dto.CustomerDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerConverter  implements DtoConverter<CustomerDto, CustomerDbo>{
    @Override
    public CustomerDto convertToDto(CustomerDbo dbo) {
        final CustomerDto dto = new CustomerDto();
        BeanUtils.copyProperties(dbo,dto);
        return dto;
    }

    @Override
    public CustomerDbo convertToDbo(CustomerDto dto) {
        final CustomerDbo dbo = new CustomerDbo();
        BeanUtils.copyProperties(dto,dbo);
        return dbo;
    }
}
