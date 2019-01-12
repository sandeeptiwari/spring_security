package co.in.security.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = ANNOTATION,
        value = EnableWebMvc.class)},
        basePackages = "co.in.security.web.model")
public class RootConfiguration {

}
