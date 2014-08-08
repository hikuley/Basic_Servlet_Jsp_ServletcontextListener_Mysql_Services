<%@ page import="java.sql.Connection" %>
<%@page import="java.util.List" %>
<%@ page import="com.ibrahimkuley.com.dao.JDBCPeople" %>
<%@ page import="com.ibrahimkuley.com.dao.People" %>
<%@ page import="java.sql.SQLException" %>

<%--
  Created by IntelliJ IDEA.
  User: halil
  Date: 05.08.2014
  Time: 01:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%
    ServletContext context = getServletContext();
    Connection connection = JDBCPeople.getConnection(context);

    List<People> peopleList = null;
    try {
        peopleList = JDBCPeople.getRecords(connection);
    } catch (SQLException e) {
        e.printStackTrace();
    }

%>
<table>
    <tr bgcolor="#a4a4a4">
        <td>First Name</td>
        <td>Last Name</td>
        <td>Gender</td>
    </tr>
    <% for (People person : peopleList) {%>
    <tr>
        <td><%=person.getFirstname()%></td>
        <td><%=person.getLastname()%></td>
        <td><%=person.getGender()%></td>
    </tr>
    <% }%>
</table>

</body>
</html>
