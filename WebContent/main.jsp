<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE hmtl>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Animes</title>
</head>
<body style=background-color:black;>
    Lista: <br />
     <ul>
        <c:forEach items="${name_anime}" var="anime">
            <li>
            <a href=watch?anime=${anime }">editar</a>
            
            </li>
        </c:forEach>
    </ul>

</body>
</html>


<a href=watch?anime="+resultSet.getString("name_anime") "'>
<img src=resultSet.getString("img_anime")> 
</body></html>