package com.ibrahimkuley.com.services;

import com.ibrahimkuley.com.dao.JDBCPeople;
import com.ibrahimkuley.com.dao.People;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by halil on 08.08.2014.
 */
public class JspWrite extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        Connection connection = JDBCPeople.getConnection(context);

        List<People> peopleList = null;

        try {
            peopleList = JDBCPeople.getRecords(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("peopleListesi", peopleList);

        RequestDispatcher view = request.getRequestDispatcher("jspFiles/writeJsp.jsp"); // jsp dosyamızı adlık
        view.forward(request, response); // jsp dosyamıza istek ve cevap larımızı gönderip ekrana bastık

    }
}
