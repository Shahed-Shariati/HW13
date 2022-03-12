package database;

import model.Course;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;

public class SessionFactorySingleton {
    private SessionFactorySingleton(){}

    public static class LazyHolder{
        private static SessionFactory  INSTANCE;

        static {
            var  serviceRegistry =  new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
              INSTANCE = new MetadataSources(serviceRegistry)

                      .buildMetadata()
                      .buildSessionFactory();
        }
    }

    public static SessionFactory getSessionFactory(){
        return LazyHolder.INSTANCE;
    }
}
