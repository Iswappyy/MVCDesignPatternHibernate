package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtill {
     private static final SessionFactory sessionFactory = buildSessionFactory();
     
     private static SessionFactory buildSessionFactory() {
    	 return new Configuration().configure().buildSessionFactory();
    	 
     }
     
     public static SessionFactory getSessionFactory() {
		return sessionFactory;
    	 
     }
     
     public static void close() {
    	 getSessionFactory().close();
    	 
     }
}
