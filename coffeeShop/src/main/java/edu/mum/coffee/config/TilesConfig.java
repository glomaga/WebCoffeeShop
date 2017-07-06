package edu.mum.coffee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfig {

    @Bean
       public UrlBasedViewResolver viewResolver() {
           UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
           viewResolver.setViewClass(TilesView.class);
           viewResolver.setOrder(-2);
           return viewResolver;
       }

       @Bean
       public TilesConfigurer tilesConfigurer() {
           TilesConfigurer tilesConfigurer = new TilesConfigurer();
           tilesConfigurer.setDefinitions("/layouts/definitions/tiles.xml");
           tilesConfigurer.setCheckRefresh(true);

           return tilesConfigurer;
       }
       

}
