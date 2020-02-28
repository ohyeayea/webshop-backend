package ipwrc.webshop.core;

import io.dropwizard.db.PooledDataSourceFactory;
import ipwrc.webshop.WebShopConfiguration;

public class MigrationsBundle extends io.dropwizard.migrations.MigrationsBundle<WebShopConfiguration> {

  @Override
  public PooledDataSourceFactory getDataSourceFactory(WebShopConfiguration webShopConfiguration) {
    return webShopConfiguration.getDataSourceFactory();
  }
}
