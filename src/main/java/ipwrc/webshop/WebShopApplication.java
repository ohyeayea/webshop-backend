package ipwrc.webshop;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ipwrc.webshop.core.HibernateBundle;
import ipwrc.webshop.core.MigrationsBundle;

public class WebShopApplication extends Application<WebShopConfiguration> {

  public static void main(final String[] args) throws Exception {
    new WebShopApplication().run(args);
  }

  @Override
  public String getName() {
    return "HelloWorld";
  }

  @Override
  public void initialize(final Bootstrap<WebShopConfiguration> bootstrap) {
    bootstrap.addBundle(new HibernateBundle());
    bootstrap.addBundle(new MigrationsBundle());
  }

  @Override
  public void run(final WebShopConfiguration configuration,
                  final Environment environment) {
//     TODO: implement application
  }

}
