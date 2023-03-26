package edu.tcu.cs.hogwartsartifactsonline.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

/**
 * This class handles unsuccessful JWT authorization.
 */
@Component
public class CustomBearerTokenAccessDeniedHandler implements AccessDeniedHandler {

    private final HandlerExceptionResolver resolver;


    public CustomBearerTokenAccessDeniedHandler(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        this.resolver.resolveException(request, response, null, accessDeniedException);
    }

}
