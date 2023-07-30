package util;


import java.util.Properties;


import entities.Favorite;
import entities.Report;
import entities.User;
import entities.Video;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
                settings.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=polye");
                settings.put(Environment.USER, "sa");
                settings.put(Environment.PASS, "0395789472");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "none");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Favorite.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Video.class);
                configuration.addAnnotatedClass(Report.class);


                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
