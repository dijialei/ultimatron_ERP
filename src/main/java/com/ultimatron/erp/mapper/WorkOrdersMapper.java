package com.ultimatron.erp.mapper;

import com.ultimatron.erp.dto.WorkOrderDto;
import com.ultimatron.erp.entities.WorkOrders;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkOrdersMapper {
    WorkOrders toWorkOrders(WorkOrderDto workOrderDto);
    WorkOrderDto toWorkOrderDto(WorkOrders workOrders);
}
