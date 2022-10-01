<%@ page import="model.Cat" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Corse
  Date: 30.09.2022
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cat</title>
</head>
<body>
<h1>Cat</h1>
<p>Name: ${cat.name}</p>
<p>Age: ${cat.age}</p>
<p>Children</p>
<hr>
<ul>
    <% if (((Cat)request.getAttribute("cat")).getChildren() != null) %>
    <% for (Cat cat : (List<Cat>) ((Cat)request.getAttribute("cat")).getChildren()) { %>
    <li>name: <%=cat.getName()%>; age: <%=cat.getAge()%></li>
    <% } %>
</ul>
</body>
</html>
