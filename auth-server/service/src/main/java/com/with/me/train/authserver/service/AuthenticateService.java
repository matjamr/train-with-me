package com.with.me.train.authserver.service;

import com.with.me.train.authserver.model.request.AuthenticationRequest;
import com.with.me.train.authserver.model.response.AuthenticationResponse;
import com.with.me.train.authserver.model.request.RegisterRequest;

public interface AuthenticateService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request) throws Exception;
}
