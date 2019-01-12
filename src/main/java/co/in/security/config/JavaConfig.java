package co.in.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration
//@Import({SecurityConfig.class, DataSourceConfig.class})
/*@ComponentScan(basePackages =
        {
                "co.in.security.config"
              *//*  "com.packtpub.springsecurity.dataaccess",
                "com.packtpub.springsecurity.domain",
                "com.packtpub.springsecurity.service"*//*
        }
)
@PropertySource(value = {"classpath:application.properties"})*/
public class JavaConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

} // The end...
