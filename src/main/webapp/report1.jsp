<%@ page import="vn.edu.iuh.fit.models.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.models.Roles" %>
<%@ page import="org.checkerframework.checker.units.qual.C" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/27/2023
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<select id="roleId">
    <%for(Roles r : Roles.values()){%>
        <option value="<%= r.toString()%>"><%= r.toString()%></option>
    <%}%>
</select>
<a id="link" onclick="updateLink()">View</a>
<table>
    <%
        List<Candidate> can = (List<Candidate>) request.getAttribute("candidates");
    %>
    <h1>Detail</h1>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    <% for( Candidate candidate : can ) {%>
    <tr>
        <td><%= candidate.getId()%></td>
        <td><%= candidate.getFullName()%></td>
    </tr>
    <%}%>
</table>
<script>
    function updateLink(){
        const role = document.getElementById("role");
        const value = role.value;
        document.getElementById("link").href = "/home?action=report1&role="+value;
    }
</script>
</body>
</html>
