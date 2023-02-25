package com.with.me.train.authserver.service.impl;

import com.with.me.train.authserver.config.GoogleOAuth2User;
import com.with.me.train.authserver.model.entity.Provider;
import com.with.me.train.authserver.model.entity.User;
import com.with.me.train.authserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleOauth2Service extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user =  super.loadUser(userRequest);
        return new GoogleOAuth2User(user);
    }

    public void processOAuthPostLogin(String email) {
        User existUser = userRepository.findByEmail(email)
                .orElse(null);

        if (existUser == null) {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setProvider(Provider.GOOGLE);
//            newUser.setEnabled(true);

            userRepository.save(newUser);
        }

    }
}