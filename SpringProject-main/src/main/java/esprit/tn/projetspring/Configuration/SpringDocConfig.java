package esprit.tn.projetspring.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringDocConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Configurer CORS pour tous les endpoints commençant par "/api"
                .allowedOrigins("http://localhost:4200") // Autoriser les requêtes provenant de ce domaine
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Autoriser ces méthodes HTTP
    }
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("projet Spring")
                .contact(contactAPI());
    }


    public Contact contactAPI() {
        return new Contact().name("Equipe ASI II")
                .email("riabi.hadil@esprit.tn")
                .url("https://www.linkedin.com/in/**********/");
    }

    @Bean
    public GroupedOpenApi burrialeApi() {
        return GroupedOpenApi.builder()
                .group("Only Burrial Location Management API")
                .pathsToMatch("/api/burrials/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi ceremonyApi() {
        return GroupedOpenApi.builder()
                .group("Only ceremony Management API")
                .pathsToMatch("/api/ceremonies/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi FlowerApi() {
        return GroupedOpenApi.builder()
                .group("Only Flower Management API")
                .pathsToMatch("/api/flowers/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi funeralApi() {
        return GroupedOpenApi.builder()
                .group("Only Funeral location Management API")
                .pathsToMatch("/api/funerals/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi mealApi() {
        return GroupedOpenApi.builder()
                .group("Only meals Management API")
                .pathsToMatch("/api/meals/**")
                .pathsToExclude("**")
                .build();
    }
}
