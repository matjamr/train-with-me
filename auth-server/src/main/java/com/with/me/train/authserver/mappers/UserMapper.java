package com.with.me.train.authserver.mappers;

import com.baitando.openapi.samples.gen.springbootserver.model.UserDto;
import com.with.me.train.authserver.model.entity.User;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    public static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
//            @Mapping(target = "userId", source = "id"),
//            @Mapping(target = "userName", source = "user")
    })
    User mapTo(UserDto userDto);
    List<UserDto> mapTo(List<User> userDto);

    @InheritConfiguration
    UserDto mapTo(User user);



}
