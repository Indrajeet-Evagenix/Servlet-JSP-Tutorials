<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <h1>Function Tag Example</h1>
	<hr> -->
	<%-- <c:set var="channelName" value="Welcome to The Becoder"></c:set> --%>
	<%-- <c:if test="${fn:containsIgnoreCase(channelName,'Becoder') }">
		<h4>Founds Becoder</h4>
	</c:if>

	<c:if test="${fn:contains(channelName,'BecoderAlert') }">
		<h4>Found BecoderAlert</h4>
	</c:if> --%>
	
	<%-- <c:set var="channelName" value="Welcome to The Becoder"></c:set>
	<c:if test="${fn:endsWith(channelName,'Becoder') }">
		<h4>Founds Becoder</h4>
	</c:if> --%>
	
	<%-- <c:set var="channelName" value="Welcome to The Becoder"></c:set>
	<h1>String Index of: ${fn:indexOf(channelName,'to')}</h1> --%>
	
	<%-- <c:set var="channelName" value="Welcome to The Becoder"></c:set>
	<h1>String length without Trim: ${fn:length(channelName)}</h1> --%>
	
	<%-- <c:set var="channelName" value="Welcome to The Becoder      "></c:set>
	<h1>String length without Trim: ${fn:length(channelName)}</h1>

	<c:set value="${fn:trim(channelName) }" var="str"></c:set>
	<h1>String length with Trim: ${fn:length(str)}</h1> --%>
	
	<%-- <c:set var="channelName" value="Welcome to The Becoder"></c:set>
	<c:if test="${fn:startsWith(channelName,'Welcome') }">
		<h4>Founds Welcome</h4>
	</c:if> --%>
	
	<%-- <c:set var="str1" value="Welcome to The Becoder"></c:set>
	<c:set var="str2" value="${fn:split(str1,' ') }"></c:set>
	<c:set var="str3" value="${fn:join(str2,'-') }"></c:set>
	${str3 } --%>
	
	<%-- <c:set var="str1" value="Welcome to The Becoder"></c:set>
	${fn:toLowerCase(str1) }
	${fn:toUpperCase(str1) } --%>
	
	<%-- <c:set var="str1" value="Welcome to The Becoder"></c:set>
	${fn:substring(str1,4,6) } --%>
	
	<%-- <c:set var="str1" value="Welcome to The Becoder"></c:set>
	${fn:substringAfter(str1,'to') }
	${fn:substringBefore(str1,'to') } --%>
	
	<%-- <c:set var="str1" value="Welcome to The Becoder"></c:set>
	${fn:replace(str1,'to','Indrajeet') } --%>
	
	
	
	

</body>
</html>