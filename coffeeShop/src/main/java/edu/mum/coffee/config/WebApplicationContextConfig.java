package edu.mum.coffee.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;
import org.springframework.web.util.UrlPathHelper;


@Configuration
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter {
    
	// esto es para poder utilizar @MatrixVariable(pathVar="params") en los
		// controllers
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
       UrlPathHelper urlPathHelper = new UrlPathHelper();
       urlPathHelper.setRemoveSemicolonContent(false);

       configurer.setUrlPathHelper(urlPathHelper);
    }
    
    @Bean
    public LocaleResolver localeResolver(){
       SessionLocaleResolver resolver = new SessionLocaleResolver();
       resolver.setDefaultLocale(new Locale("en"));
       
       return resolver;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	LocaleChangeInterceptor localeChangeInterceptor = new
    			LocaleChangeInterceptor(); localeChangeInterceptor.setParamName("language"); 
    			registry.addInterceptor(localeChangeInterceptor);
    }
    
//    
//    
//    @Bean(name = "validator")
//    public LocalValidatorFactoryBean validator() {
//       LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//       bean.setValidationMessageSource(messageSource());
//       return bean;
//    }
//    
//    @Override
//    public Validator getValidator(){
//       return validator();
//    }
//    
//    @Bean
//    public ProductValidator productValidator () {
//       Set<Validator> springValidators = new HashSet<>();
//       springValidators.add(new UnitsInStockValidator());
//       
//       ProductValidator productValidator = new ProductValidator();
//       productValidator.setSpringValidators(springValidators);
//       
//       return productValidator;
//    }

}
