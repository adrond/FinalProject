package com.adrond.finalproject.Data;


import com.adrond.finalproject.Data.BalanceEntity;
import com.adrond.finalproject.Data.ReadHibernateConfig;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class DataBaseoperation {
    private static SessionFactory sessionFactory;

    public DataBaseoperation() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(BalanceEntity.class);
                ReadHibernateConfig readHibernateConfig = new ReadHibernateConfig("HibernateConfig.txt");
                configuration.setProperty("hibernate.connection.url", readHibernateConfig.url);
                configuration.setProperty("hibernate.connection.username", readHibernateConfig.baseLogin);
                configuration.setProperty("hibernate.connection.password", readHibernateConfig.basePass);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Error!!! " + e);
            }
        }
        return sessionFactory;
    }

}
