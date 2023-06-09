package com.example.ch13.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;

import java.util.List;
import java.util.Map;


@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter{
    @Autowired
    AuthenticationManager authenticationManager;
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.inMemory()
                .withClient("client")
                .secret("secret")
                .authorizedGrantTypes("authorization_code")
                .scopes("read")
                .redirectUris("http://localhost:9090/home")
                .and()
                .withClient("client2")
                .secret("secret2")
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                .scopes("read")
                .redirectUris("http://localhost:8080.home");

//        clients.inMemory().withClient("client")
//                .secret("secret")
//                .authorizedGrantTypes("password")
//                .scopes("read");

//        var service = new InMemoryClientDetailsService();
//
//        var cd = new BaseClientDetails();
//        cd.setClientId("client");
//        cd.setClientSecret("secret");
//        cd.setScope(List.of("read"));
//        cd.setAuthorizedGrantTypes(List.of("password"));
//
//        service.setClientDetailsStore(Map.of("client",cd));
//
//        clients.withClientDetails(service);
    }
}
