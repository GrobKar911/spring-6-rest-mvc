package com.grobkar.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Customer {

    private final String CustomerName;
    private UUID customerId;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifyDate;
}
