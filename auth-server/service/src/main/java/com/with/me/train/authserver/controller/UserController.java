package com.with.me.train.authserver.controller;

import com.with.me.train.authserver.mappers.UserMapper;
import com.with.me.train.authserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UserApi;
import org.openapitools.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserRepository userRepository;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return UserApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<UserDto>> getUsers(Integer limit) {
        return UserApi.super.getUsers(limit);
    }

    @Override
    public ResponseEntity<UserDto> showUserById(Integer id) {
        return ResponseEntity.ok(userRepository.findById(id)
                .map(UserMapper.INSTANCE::mapTo)
                .orElse(null));
    }
}
