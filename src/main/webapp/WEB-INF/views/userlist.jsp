<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>User List</title>
</head>
<body>
<h1>
	List Page  
</h1>

	<table>
		<c:forEach var="person" items="${list}" begin="${page_begin}" end="${page_end}">
			<tr>
				<td>UserName</td>
				<td>${person.getU_ID()}</td>
				<td>Password</td>
				<td>${person.getU_PASSWORD()}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		
		<% for( int i=1; i <= Integer.parseInt(request.getAttribute("totalpage").toString()); i++) { %>
			<a href="userlist?page_num=<%=i%>"> <%=i%> </a>
		<% }%>
		
	</div> 
	<div>${test}</div>
</body>
</html>
