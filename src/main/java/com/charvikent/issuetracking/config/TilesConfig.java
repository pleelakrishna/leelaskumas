package com.charvikent.issuetracking.config;

import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;


@Configuration
public class TilesConfig {
    /**
     * Initialise Tiles on application startup and identify the location of the tiles configuration file, tiles.xml.
     * 
     * @return tiles configurer
     */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();

		String[] defs = { "WEB-INF/tiles/tiles.xml" };

		tilesConfigurer.setDefinitions(defs);

		return tilesConfigurer;
	}
    
    /**
     * 
     * @return
     */
	@Bean
	public UrlBasedViewResolver tilesViewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();

		tilesViewResolver.setViewClass(TilesView.class);

		return tilesViewResolver;
	}
	
	@Bean
	public VelocityEngine velocityEngine() throws Exception {
	    Properties properties = new Properties();
	    properties.setProperty("input.encoding", "UTF-8");
	    properties.setProperty("output.encoding", "UTF-8");
	    properties.setProperty("resource.loader", "class");
	    properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	    VelocityEngine velocityEngine = new VelocityEngine(properties);
	    return velocityEngine;
	}
	
}
