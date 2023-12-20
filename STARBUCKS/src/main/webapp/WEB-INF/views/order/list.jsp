<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>스타벅스</title>
	</head>
	<body>
		<div>
			<ul>
				<c:forEach var="order" items="${orderList }" >
					<li>
						<c:out value="${order.seq }" />
						<c:out value="${order.menu }" />
						<c:out value="${order.amount }" />
						<c:out value="${order.sum }" />
						<c:out value="${order.user_id }" />
						<c:out value="${order.create_date }" />
					</li>
				</c:forEach>
			</ul>
		</div>
	</body>
</html>