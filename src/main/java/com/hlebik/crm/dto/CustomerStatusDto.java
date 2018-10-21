package com.hlebik.crm.dto;

import com.hlebik.crm.enumerated.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerStatusDto {
    private long id;
    private Status status;
}
