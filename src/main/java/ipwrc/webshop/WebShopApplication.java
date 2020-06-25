package ipwrc.webshop;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ipwrc.webshop.core.AppBinder;
import ipwrc.webshop.core.HibernateBundle;
import ipwrc.webshop.core.MigrationsBundle;
import ipwrc.webshop.resources.ProductResource;
import ipwrc.webshop.resources.ShoppingCartResource;
import ipwrc.webshop.resources.UserResource;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.hibernate.SessionFactory;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class WebShopApplication extends Application<WebShopConfiguration> {

  private final HibernateBundle hibernateModule = new HibernateBundle();
  private final MigrationsBundle migrationsBundle = new MigrationsBundle();

  public static void main(final String[] args) throws Exception {
    new WebShopApplication().run(args);
  }

  @Override
  public String getName() {
    return "Webshop";
  }

  @Override
  public void initialize(final Bootstrap<WebShopConfiguration> bootstrap) {
    bootstrap.addBundle(hibernateModule);
    bootstrap.addBundle(migrationsBundle);
  }

  @Override
  public void run(final WebShopConfiguration configuration, final Environment environment) {
    SessionFactory factory = hibernateModule.getSessionFactory();
    environment.jersey().register(new AppBinder(hibernateModule));
    environment.jersey().register(ProductResource.class);
    environment.jersey().register(ShoppingCartResource.class);
    environment.jersey().register(UserResource.class);

    // Enable CORS headers
    final FilterRegistration.Dynamic cors =
            environment.servlets().addFilter("CORS", CrossOriginFilter.class);

    // Configure CORS parameters
    cors.setInitParameter("allowedOrigins", "*");
    cors.setInitParameter("allowedHeaders", "*X-Requested-With,Content-Type,Accept,Origin");
    cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

    // Add URL mapping
    cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    // DO NOT pass a preflight request to down-stream auth filters
    // unauthenticated preflight requests should be permitted by spec
    cors.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());
  }
}
