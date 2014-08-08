<%@ page import="java.util.List" %>
<%@ page import="com.ibrahimkuley.com.dao.People" %>
<%--
  Created by IntelliJ IDEA.
  User: halil
  Date: 08.08.2014
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Peoples</h1>
<table>
    <tr style="font-weight: bold">
        <td width="150">First Name</td>
        <td width="150">Last Name</td>
        <td width="150">Gender</td>
    </tr>
    <%
        //peopleListesi anahtar kelimesi ile  veri setimizi aldık
        List<People> peopleList = (List<People>) request.getAttribute("peopleListesi");
        // For döngüsü ile ekrana bastık
        for (People person : peopleList) {
    %>
    <tr>
        <td><%=person.getFirstname()%></td>
        <td><%=person.getLastname()%></td>
        <td><%=person.getFirstname()%></td>
    </tr>
    <% }%>


</table>

</body>
</html>
