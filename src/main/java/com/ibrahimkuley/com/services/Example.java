package com.ibrahimkuley.com.services;

import com.google.gson.Gson;
import com.ibrahimkuley.com.dao.JDBCPeople;
import com.ibrahimkuley.com.dao.People;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by halil on 04.08.2014.
 */
public class Example extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalStateException {
        response.setContentType("text/html; charset=utf-8");//Türkçe Karekter sorunu çözdük
        ServletContext context = getServletContext();
        Connection connection = JDBCPeople.getConnection(context);

        People people = createPeopleInstance(request);
        try {
            JDBCPeople.insert(people, connection); // Bağlantıyı gönderdik vede objemizi gönderdik . . .
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalStateException {
        ServletContext context = getServletContext();
        Connection connection = JDBCPeople.getConnection(context);

        List<People> peopleList = null;
        try {
            peopleList = JDBCPeople.getRecords(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson(); // Gson Kütüphanesini ekledik
        String peoplesJson = gson.toJson(peopleList); // Listemizi Json nesnesine çevirdik
        PrintWriter writer = response.getWriter(); //ekrana bastık
        writer.println(peoplesJson);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalStateException {
        super.doDelete(req, resp);
        ServletContext context = getServletContext(); //servlet context nesnesini aldık
        Connection connection = JDBCPeople.getConnection(context); // bağlantı nesnesi oluşturduk

        String id = req.getParameter("id");

        try {
            JDBCPeople.delete(id, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPut(request, response);
        ServletContext context = getServletContext();
        Connection connection = JDBCPeople.getConnection(context);

        Integer id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        People people = new People(id, firstName, lastname, gender);

        try {
            JDBCPeople.update(people, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println(id);

    }

    public People createPeopleInstance(HttpServletRequest request) throws UnsupportedEncodingException {

        String firstName = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        People people = new People(firstName, lastname, gender);
        return people;
    }

}
