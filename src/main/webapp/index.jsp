<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Title</th>
				<th scope="col">Language</th>
				<th scope="col"># Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">
			<tr>
				<th scope="row"><c:out value="${book.id}" /></th>
				<td><a href="/books/${book.id}"><c:out value="${book.title}" /></a></td>
				<td><c:out value="${book.language}" /></td>
				<td><c:out value="${book.pages}" /></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>