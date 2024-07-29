package edu.tcu.cs.hogwartsartifactsonline.security;

import edu.tcu.cs.hogwartsartifactsonline.client.rediscache.RedisCacheClient;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final RedisCacheClient redisCacheClient;


    public JwtInterceptor(RedisCacheClient redisCacheClient) {
        this.redisCacheClient = redisCacheClient;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Retrieve the Authorization header from the request
        String authorizationHeader = request.getHeader("Authorization");
        // If the Authorization header is not null, and it starts with "Bearer ", then we need to verify if its token is present in Redis
        // Else this request is just a public request that does not need a token. E.g., login, register, etc.
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwt = (Jwt) authentication.getPrincipal();

            // Retrieve the userId from the JWT claims and check if the token is in the Redis whitelist or not
            String userId = jwt.getClaim("userId").toString();
            if (!this.redisCacheClient.isUserTokenInWhiteList(userId, jwt.getTokenValue())) {
                throw new BadCredentialsException("Invalid token");
            }
        }
        return true;
    }

}
