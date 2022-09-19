package comjava.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        // Function<PredicateSpec, Buildable<Route>> x;

        return builder.routes().route(p -> p.path("/products/**").uri("lb://product-service"))
                .route(p -> p.path("/product-list/**").filters(
                        f -> f.rewritePath("/product-list(?<segment>.*)", "/products${segment}"))
                        .uri("lb://product-service"))
                .build();
    }

}
