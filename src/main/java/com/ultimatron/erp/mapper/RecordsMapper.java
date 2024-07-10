package com.ultimatron.erp.mapper;

import com.ultimatron.erp.dto.RecordDto;
import com.ultimatron.erp.entities.Records;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecordsMapper {
    Records toRecords(RecordDto recordDto);
    RecordDto toRecordDto(Records records);
}
