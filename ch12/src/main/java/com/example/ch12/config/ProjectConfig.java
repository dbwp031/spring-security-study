package com.example.ch12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2Login(c -> c.clientRegistrationRepository(clientRepository()));

        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        return http.build();
    }

    private ClientRegistrationRepository clientRepository() {
        var c = clientRegistration();
        return new InMemoryClientRegistrationRepository(c);
    }
    @Bean
    public ClientRegistration clientRegistration() {
//        ClientRegistration cr = ClientRegistration.withRegistrationId("github")
//                .clientId("지워버림")
//                .clientSecret("지워버림")
//                .scope(new String[]{"read:user"})
//                .authorizationUri("https://github.com/login/oauth.authorize") //클라이언트가 인증을 위해 사용자를 리디렉션하는 URI
//                .tokenUri("https://github.com/login/oauth/access_token") //액세스 토큰과 갱신 토큰을 얻기 위해 호출하는 URI
//                .userInfoUri("https://api.github.com/user") // 클라이언트가 액세스 토큰을 얻은 후 사용자의 세부 정보를 얻기 위해 호출하는 URI
//                .userNameAttributeName("id")
//                .clientName("Github")
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUri("{baseUrl}/{action}/oauth/code/{registrationId}")
//                .build();
        var cr = CommonOAuth2Provider.GITHUB
                .getBuilder("github")
                .clientId("지워버림")
                .clientSecret("지워버림")
                .build();
        return cr;
    }
}