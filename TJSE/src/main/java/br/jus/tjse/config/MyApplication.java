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
		// register(ProcessoResources.class);
		// register(JacksonFeature.class);
		// register(AllExceptionMapper.class);
		System.out.println(ProcessoResources.class.getPackage().getName());
		// register(ApiListingResource.class);
		// register(ApiDeclarationProvider.class);
		// register(ApiListingResourceJSON.class);
		// register(ResourceListingProvider.class);

		// property(MessageProperties.XML_FORMAT_OUTPUT, true);
		// property(ServerProperties.TRACING, "ALL");
		//

		// Resources.
		// System.out.println(ProcessoResources.class.getPackage().getName());
		// packages(ProcessoResources.class.getPackage().getName());
		// Validation.
		// register(ValidationConfigurationContextResolver.class);

		// Providers - JSON.
		// register(MoxyJsonFeature.class);
		// register(new MoxyJsonConfig().setFormattedOutput(true)
		// // Turn off BV otherwise the entities on server would be validated by
		// MOXy as well.
		// .property(MarshallerProperties.BEAN_VALIDATION_MODE,
		// BeanValidationMode.NONE)
		// .resolver());
		// register(ValidationException.class);
	}

	// @PostConstruct
	// public void initializeSwaggerConfiguration() {
	//
	// final ReflectiveJaxrsScanner scanner = new ReflectiveJaxrsScanner();
	// scanner.setResourcePackage("br.jus.tjse.server");
	// ScannerFactory.setScanner(scanner);
	// ClassReaders.setReader(new DefaultJaxrsApiReader());
	// final SwaggerConfig config = ConfigFactory.config();
	// config.setApiVersion("1.0");
	// config.setBasePath("http://localhost:8080/TJSE/rest");
	// }

	/*
	 * @Override public Set<Class<?>> getClasses() { Set<Class<?>> resources =
	 * new HashSet<>(); resources.add(ProcessoResources.class);
	 * 
	 * //classes do swagger... resources.add(ApiListingResource.class);
	 * resources.add(SwaggerSerializers.class); return resources; }
	 */
	//
	// public static class ValidationConfigurationContextResolver implements
	// ContextResolver<ValidationConfig> {
	//
	// @Context
	// private ResourceContext resourceContext;
	//

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

	// @Override
	// public ValidationConfig getContext(final Class<?> type) {
	// return new ValidationConfig()
	// .constraintValidatorFactory(resourceContext.getResource(InjectingConstraintValidatorFactory.class))
	// .parameterNameProvider(new CustomParameterNameProvider());
	// }
	//
	// /**
	// * See ContactCardTest#testAddInvalidContact.
	// */
	// private class CustomParameterNameProvider implements
	// ParameterNameProvider {
	//
	// private final ParameterNameProvider nameProvider;
	//
	// public CustomParameterNameProvider() {
	// nameProvider =
	// Validation.byDefaultProvider().configure().getDefaultParameterNameProvider();
	// }
	//
	// @Override
	// public List<String> getParameterNames(final Constructor<?> constructor) {
	// return nameProvider.getParameterNames(constructor);
	// }
	//
	// @Override
	// public List<String> getParameterNames(final Method method) {
	//// // See ContactCardTest#testAddInvalidContact.
	//// if ("addContact".equals(method.getName())) {
	//// return Arrays.asList("contact");
	//// }
	// return nameProvider.getParameterNames(method);
	// }
	// }
	// }

}
