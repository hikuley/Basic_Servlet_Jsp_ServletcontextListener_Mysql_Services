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
    <meta charset="utf-8">
</head>
<body>

<form action="example" method="post">
    <table>
        <tr>
            <td>Adı :</td>
            <td><input type="text" name="firstname"/></td>
        </tr>
        <tr>
            <td>Soyadı :</td>
            <td><input type="text" name="lastname"/></td>
        </tr>
        <tr>
            <td>Cinsiyet :</td>
            <td><select name="gender" id="">
                <option value="Erkek">Erkek</option>
                <option value="Kadın">Kadın</option>
            </select></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Gönder"/></td>
        </tr>
    </table>
</form>

</body>
</html>
