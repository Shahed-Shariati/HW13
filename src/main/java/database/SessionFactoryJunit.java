package database;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryJunit {
    private SessionFactoryJunit(){}

    public static class LazyHolder{
        private static SessionFactory INSTANCE;
        static {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernatetest.cfg.xml")
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
