<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
<body>
	<%-- out of service method --%>
	<%! String _ip; %>
	<%-- in service method --%>
	<%
	_ip = request.getRemoteAddr();
	out.println("IP address = " + _ip ); 
	%>
	<p>
		<fmt:setLocale value="de" />
		<fmt:bundle basename="i18n.bundleName">
			<fmt:message key="lang" />
		</fmt:bundle>
		<fmt:setLocale value="en" />
		<fmt:bundle basename="i18n.bundleName">
			<fmt:message key="lang" />
		</fmt:bundle>
	</p>
	<hr>
	<c:out value="c:out test" />
	<hr>
	<table border="1">
		<tr>
			<th>String</th>
		</tr>
		<c:forEach var="str" items="${strings}">
			<tr>
				<td>${str}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>