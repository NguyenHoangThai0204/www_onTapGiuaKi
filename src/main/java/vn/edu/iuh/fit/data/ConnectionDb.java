package vn.edu.iuh.fit.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.Experience;

import java.net.ConnectException;

public class ConnectionDb {
    private static ConnectionDb instance = null;
    private SessionFactory sessionFactory = null;
    private ConnectionDb(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata= new MetadataSources(registry)
                .addAnnotatedClass(Candidate.class)
                .addAnnotatedClass(Experience.class)
                .getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static ConnectionDb getInstance(){
        if(instance == null)
            instance = new ConnectionDb();
        return instance;
    }

}
