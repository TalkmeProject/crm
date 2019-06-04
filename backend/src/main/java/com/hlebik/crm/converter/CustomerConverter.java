package com.hlebik.crm.converter;

import com.hlebik.crm.dbo.CustomerDbo;
import com.hlebik.crm.dto.CustomerDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerConverter  implements DtoConverter<CustomerDto, CustomerDbo>{
    @Autowired
    CustomerStatusConverter customerStatusConverter;
    @Autowired
    UserConverter userConverter;

    @Override
    public CustomerDto convertToDto(CustomerDbo dbo) {
        final CustomerDto dto = new CustomerDto();
        BeanUtils.copyProperties(dbo,dto);
        dto.setCustomerStatusDto(customerStatusConverter.convertToDto(dbo.getCustomerStatusDbo()));
        dto.setUserDto(userConverter.convertToDto(dbo.getUserDbo()));
        return dto;
    }

    @Override
    public CustomerDbo convertToDbo(CustomerDto dto) {
        final CustomerDbo dbo = new CustomerDbo();
        BeanUtils.copyProperties(dto,dbo);
        dbo.setCustomerStatusDbo(customerStatusConverter.convertToDbo(dto.getCustomerStatusDto()));
        dbo.setUserDbo(userConverter.convertToDbo(dto.getUserDto()));
        return dbo;
    }
}
