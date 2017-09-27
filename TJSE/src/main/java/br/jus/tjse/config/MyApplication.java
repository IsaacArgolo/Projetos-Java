package br.jus.tjse.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.jus.tjse.server.ProcessoResources;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

//ResourceConfig
@ApplicationPath("/v1")
public class MyApplication extends Application {

	public MyApplication() {

		// swagger
		BeanConfig conf = new BeanConfig();
		conf.setTitle("TJSE API");
		conf.setDescription("Processos");
		conf.setVersion("1.0.0");
		conf.setHost("localhost:8080");
		conf.setBasePath("/TJSE/");
		conf.setSchemes(new String[] { "http" });
		conf.setResourcePackage(ProcessoResources.class.getPackage().getName());
		conf.setScan(true);
		
		System.out.println(ProcessoResources.class.getPackage().getName());
		
	}

	

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		resources.add(JacksonJavaTimeConfiguration.class);
		resources.add(ProcessoResources.class);

		// classes do swagger...
		resources.add(ApiListingResource.class);
		resources.add(SwaggerSerializers.class);
		return resources;
	}

	
}
