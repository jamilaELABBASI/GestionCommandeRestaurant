package util;


import entities.Client;
import entities.Commande;
import entities.Repas;
import entities.RepasRest;
import entities.Responsable;
import entities.Restaurant;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;

    static{
        factory = new Configuration().configure()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Commande.class)
                .addAnnotatedClass(Repas.class)
                .addAnnotatedClass(RepasRest.class)
                .addAnnotatedClass(Responsable.class)
                .addAnnotatedClass(Restaurant.class)
                .buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
