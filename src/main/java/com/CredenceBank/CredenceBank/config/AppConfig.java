package com.CredenceBank.CredenceBank.config;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

//To define Spring-managed beans and centralize application configuration.
//Spring application start होताना:// 1. @Configuration class scan होते
                                // 2. @Bean methods execute होतात
                                // 3. Returned objects Spring container मध्ये store होतात
@Configuration
public class AppConfig {

   // Why use @Bean -> To manually register objects inside Spring IoC container.
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine(); //Thymeleaf templates process करतं.
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver(); //Templates कुठे आहेत ते शोधतो.
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");  // Spring ला कळतं: home -> home.html
        templateResolver.setCharacterEncoding("UTF-8"); //Special characters support.

        templateEngine.setTemplateResolver(templateResolver); //Resolver engine ला जोडतो.
        return templateEngine; //Spring container मध्ये object store होतो.
    }

    //Why use ModelMapper -> To reduce boilerplate code for object conversion between DTOs and Entities.
    @Bean
    public ModelMapper modelMapperConfig(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setFieldMatchingEnabled(true)                                                  //Private fields directly map होऊ शकतात.
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)  //Private variables access करू देतो.
                .setMatchingStrategy(MatchingStrategies.STANDARD);                              //Fields किती strictly match करायचे.

        return modelMapper ;                                                                    //Spring container मध्ये object store होतो.
    }
}
