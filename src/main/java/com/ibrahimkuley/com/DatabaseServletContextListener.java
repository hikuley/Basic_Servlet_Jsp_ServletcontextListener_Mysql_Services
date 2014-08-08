package com.ibrahimkuley.com;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Created by halil on 04.08.2014.
 * Servlet ilk deploy edildiğinde veri tabanına bağlanmak için oluşturduk bu sınıfı .
 */
public class DatabaseServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    /*
        ServletContext objemiz ilk oluşturulduğunda tetiklenip çalıştırılacak metot .
     */

        ServletContext context = servletContextEvent.getServletContext();

        // dispatcher dan config bilgilerimizi alıyoruz . . .
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // bağlantı oluşturuyoruz . . .
        Connection connection = createConnection(url, username, password);
        context.setAttribute("connecitonAttribute", connection);

        System.out.println(" ################ Veri Tabanı ile bağlantı oluşturuldu  . . . ################ ");

    }

    private Connection createConnection(String url, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        /*
            ServletContext objemiz yaşam döngüsünü sonlandırınca çalışacaktır.
         */
        System.out.println(" #### Connection Destroyed ####");
    }
}
