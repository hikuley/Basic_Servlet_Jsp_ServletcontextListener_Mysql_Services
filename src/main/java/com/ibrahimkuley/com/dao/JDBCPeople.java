package com.ibrahimkuley.com.dao;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by halil on 05.08.2014.
 */

public class JDBCPeople {

    private static Connection connection = null;


    public static Connection getConnection(ServletContext context) {// Connection nesnesi oluşturmak için kullanılır.

        if (connection == null) {
            connection = (Connection) context.getAttribute("connecitonAttribute"); //connecitonAttribute ile kaynak ismi belirledik
        }
        return connection;
    }

    public static void insert(People people, Connection connection) throws SQLException {

        String sql = "insert into people" + " (firstname,lastname,gender) values(?,?,?)";

        java.sql.PreparedStatement ps = connection.prepareStatement(sql);// sorgumuzu oluşturduk

        ps.setString(1, people.getFirstname()); // sıralarına kayıtları yapıştırdık
        ps.setString(2, people.getLastname());// sıralarına kayıtları yapıştırdık
        ps.setString(3, people.getGender());// sıralarına kayıtları yapıştırdık
        ps.executeUpdate();//kayıdı güncelledik
        ps.close();//ve kapattık

    }

    public static List<People> getRecords(Connection connection) throws SQLException {
        String sql = "Select * from people"; // sorgumuzu oluşturduk
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql); // sql işlenmesi için metoda verdik

        ResultSet resultSet = preparedStatement.executeQuery(); // liste halinde result set ederk getirdik.

        List<People> peopleList = new ArrayList<People>(); // liste şeklinde People lar oluşturduk

        while (resultSet.next()) {
            /*
                ve her satırı okuyarak "peoplelist" nesnesini doldurduk
             */
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String gender = resultSet.getString("gender");
            People people = new People(firstname, lastname, gender);
            peopleList.add(people);
        }

        return peopleList;
    }

    public static void delete(String id, Connection connection) throws SQLException {

        String sql = "Delete from people where id=" + id;
        java.sql.PreparedStatement ps = connection.prepareStatement(sql); //SQL sorgumuzu verdik nesneye
        ps.executeUpdate();  // SQL sorgumuzu çalıştırdık

    }

    public static void update(People people, Connection connection) throws SQLException {
        String sql = "Update people set firstname=?,lastname=?,gender=? where id=?";
        java.sql.PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, people.getFirstname());
        ps.setString(2, people.getLastname());
        ps.setString(3, people.getGender());
        ps.setInt(4, people.getId());
        ps.executeUpdate();

    }


}
