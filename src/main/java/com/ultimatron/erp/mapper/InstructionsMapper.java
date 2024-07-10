package com.ultimatron.erp.mapper;

import com.ultimatron.erp.dto.InstructionDto;
import com.ultimatron.erp.entities.Instructions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructionsMapper {
    Instructions toInstructions(InstructionDto instructionDto);
    InstructionDto toInstructionDto(Instructions instructions);
}
