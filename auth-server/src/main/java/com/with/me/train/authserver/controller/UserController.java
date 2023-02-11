package com.with.me.train.authserver.controller;

import com.baitando.openapi.samples.gen.springbootserver.model.UserDto;
import com.with.me.train.authserver.mappers.UserMapper;
import com.with.me.train.authserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(
                UserMapper.INSTANCE.mapTo(userRepository.findAll())
        );
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser(@PathVariable int id) {
        return ResponseEntity.ok(userRepository.findById(id)
                .map(UserMapper.INSTANCE::mapTo)
                .orElse(null));
    }

    @PostMapping
    public ResponseEntity<?> user(@RequestBody UserDto user) {

        Optional.of(userRepository.findById(user.getId()))
                .ifPresentOrElse(user1 -> {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, ()-> userRepository.save(
                        UserMapper.INSTANCE.mapTo(user)
                ));

        return ResponseEntity.ok().build();
    }
}
