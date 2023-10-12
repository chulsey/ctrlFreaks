package com.codefest.ejcraft.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

  @Bean()
  OpenAPI apiInfo() {
    return new OpenAPI()
        .info(
            new Info()
                .title("EJCRaft")
                .description("EJCRaft takes Jira stories and create a CR(Change Request)")
                .version("1.0.0"));
  }
}
