package edu.tcu.cs.hogwartsartifactsonline.client.ai.chat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientBuilderConfiguration {

    /**
     * Replace the auto-configured RestClient.Builder bean which defaults to a SimpleClientHttpRequestFactory.
     * This bean will use JdkClientHttpRequestFactory.
     *
     * @return
     */
    @Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder()
                .requestFactory(new JdkClientHttpRequestFactory());
    }

}
