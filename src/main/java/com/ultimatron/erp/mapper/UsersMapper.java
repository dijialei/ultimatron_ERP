package com.ultimatron.erp.mapper;

import com.ultimatron.erp.dto.UserDto;
import com.ultimatron.erp.entities.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    Users toUsers(UserDto userDto);
    UserDto toUserDto(Users users);
}
