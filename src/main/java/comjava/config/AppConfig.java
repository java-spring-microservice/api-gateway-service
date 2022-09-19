package comjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import brave.sampler.Sampler;

@Configuration
public class AppConfig {

    @Bean
    Sampler sampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
