package test.app.server.server.config.log;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
public class Config {

    @Bean
    public MappedInterceptor someMethodName(Interceptor interceptor) {
        return new MappedInterceptor(
                new String[]{"/**"},
                new String[]{"/actuator/**"},
                interceptor
        );
    }

}