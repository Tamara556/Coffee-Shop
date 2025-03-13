package org.example.coffeeshop.mapper;

import org.example.coffeeshop.dto.RegisterUserRequestDto;
import org.example.coffeeshop.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromRequestDto(RegisterUserRequestDto registerUserRequestDto);
}
