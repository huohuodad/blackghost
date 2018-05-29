package com.firetech.blackghost;

import javax.inject.Singleton;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.firetech.blackghost.impl.CustomerServiceMockImpl;
import com.firetech.blackghost.impl.DeliveryServiceMockImpl;
import com.firetech.blackghost.impl.DriverServiceMockImpl;
import com.firetech.blackghost.impl.RecipientServiceMockImpl;
import com.firetech.blackghost.services.CustomerService;
import com.firetech.blackghost.services.DeliveryService;
import com.firetech.blackghost.services.DriverService;
import com.firetech.blackghost.services.RecipientService;

public class Application extends ResourceConfig {

    public Application() {
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(DriverServiceBindFactory.class)
                    .to(DriverService.class)
                    .in(Singleton.class);
            }
        });
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(CustomerServiceBindFactory.class)
                    .to(CustomerService.class)
                    .in(Singleton.class);
            }
        });
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(RecipientServiceBindFactory.class)
                    .to(RecipientService.class)
                    .in(Singleton.class);
            }
        });
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(DeliveryServiceBindFactory.class)
                    .to(DeliveryService.class)
                    .in(Singleton.class);
            }
        });
        packages(true, Application.class.getPackage().getName() + ".resources");
    }

    public static class DriverServiceBindFactory
    implements Factory<DriverService> {

        private DriverService service;

        public DriverServiceBindFactory() {
            service = new DriverServiceMockImpl();
        }

        public DriverService provide() {
            return service;
        }

        public void dispose(DriverService instance) {
 
        }
    }

    public static class CustomerServiceBindFactory
    implements Factory<CustomerService> {

        private CustomerService service;

        public CustomerServiceBindFactory() {
            service = new CustomerServiceMockImpl();
        }

        public CustomerService provide() {
            return service;
        }

        public void dispose(CustomerService instance) {
 
        }
    }

    public static class RecipientServiceBindFactory
    implements Factory<RecipientService> {

        private RecipientService service;

        public RecipientServiceBindFactory() {
            service = new RecipientServiceMockImpl();
        }

        public RecipientService provide() {
            return service;
        }

        public void dispose(RecipientService instance) {
 
        }
    }

    public static class DeliveryServiceBindFactory
    implements Factory<DeliveryService> {

        private DeliveryService service;

        public DeliveryServiceBindFactory() {
            service = new DeliveryServiceMockImpl();
        }

        public DeliveryService provide() {
            return service;
        }

        public void dispose(DeliveryService instance) {

        }
        
    }
}
