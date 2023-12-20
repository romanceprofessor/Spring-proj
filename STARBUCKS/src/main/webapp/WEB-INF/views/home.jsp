<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
	</head>
	<body>
		<h1>
			Hello world!  
		</h1>
		<P>  The time on the server is ${serverTime}. </P>
		<div>
			<ul>
				<li><a href="<c:url value='/order/list'/>">주문조회</a></li>
				<li><a href="<c:url value='/order/orderView'/>">주문하기</a></li>
			</ul>
		</div>
	</body>
</html>
