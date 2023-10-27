<%@ page import="vn.edu.iuh.fit.models.Candidate" %>
<%@ page import="vn.edu.iuh.fit.models.Experience" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/27/2023
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Candidate canDetail = (Candidate) request.getAttribute("canDetail");
    %>
<h1>Detail</h1>
<h2>Id: <%= canDetail.getId()%></h2>
<h2>Full name: <%= canDetail.getFullName()%></h2>
<h2>Email: <%= canDetail.getEmail()%></h2>
<h2>Phone: <%= canDetail.getPhone()%></h2>
<h2>Experience</h2><br>
<%for (Experience experience : canDetail.getExperiences()){%>
    <h3>Company: <%= experience.getCompanyName()%></h3>
    <h3>Role: <%= experience.getRoles()%></h3>
    <h3>Work-description: <%= experience.getWorkDescription()%></h3>
    <h3>From date: <%= experience.getFromDate()%></h3>
    <h3>To date: <%= experience.getToDate()%></h3>
<%}%>
</body>
</html>
