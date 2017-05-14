<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>查询结果</title>
</head>
<body>
	<table style="border:1px solid #CFCFCF;">
	 		<tr>
	 			<th>产品编号</th>
	 			<th>规格</th>
	 			<th>背侧板材料</th>
	 			<th>面板材料</th>
	 			<th>分类</th>
	 			<th>价格</th>
	 			
	 		</tr>
	 	<c:forEach var="matchingGuitar" items="${requestScope.matchingGuitar}"> 
	 		<tr>
	 			<td>${matchingGuitar.serialNumber}</td>
	 			<td>${matchingGuitar.spec.type}</td>
	 			<td>${matchingGuitar.spec.topWood}</td>
	 			<td>${matchingGuitar.spec.backWood}</td>
	 			<td>${matchingGuitar.model}</td>
	 			<td>${matchingGuitar.price}</td>
	 			
	 		</tr>			
	 	</c:forEach>

	</table>
</body>
</html>