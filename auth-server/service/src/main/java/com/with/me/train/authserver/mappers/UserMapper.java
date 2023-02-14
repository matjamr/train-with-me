package com.with.me.train.authserver.mappers;

import com.with.me.train.authserver.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.UserDto;

@Mapper
public interface UserMapper {

    public static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
//            @Mapping(target = "userId", source = "id"),
//            @Mapping(target = "userName", source = "user")
    })
    User mapTo(UserDto userDto);

//    @InheritConfiguration
    UserDto mapTo(User user);



}
