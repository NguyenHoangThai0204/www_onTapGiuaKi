<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/27/2023
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
<%
    List<Candidate> candidateList = (List<Candidate>) request.getAttribute("listCan");
%>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <% for( Candidate candidate : candidateList ) {%>
            <tr>
                <td><%= candidate.getId()%></td>
                <td><%= candidate.getFullName()%></td>
                <td><a href="home?action=viewDetail&id=<%=candidate.getId()%>">View</a></td>
                <td><a href="home?action=delete&id=<%=candidate.getId()%>">Delete</a></td>
                <td><a href="home?action=update&id=<%=candidate.getId()%>">Update</a></td>
            </tr>
        <%}%>
    </table>
</body>
</html>
