package com.ultimatron.erp.mapper;

import com.ultimatron.erp.dto.StateDto;
import com.ultimatron.erp.entities.States;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {
    States toStates(StateDto stateDto);
    StateDto toStateDto(States states);
}
