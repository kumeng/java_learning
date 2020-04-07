<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="testMybatisPlusMapper.test.entity.ACCOUNT" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<%=request.getContextPath()
/* 	response.sendRedirect(request.getContextPath()
		+ "/login.jsp"); */
		
%>
<a href="/test/aCCOUNT/addone.do">ADD</a>
<a href="/test/aCCOUNT/updateOne.do">UPDATE</a>
<a href="/test/aCCOUNT/selectALl.do">SELECT</a>
<a href="/test/aCCOUNT/DELALl.do">DEL</a>
<%=request.getAttribute("msg") %>
<br/>
list
<br/>
<%
Object obj = request.getAttribute("list");

if(obj!=null){
	List selectList = (List)obj;
	Iterator iterator = selectList.iterator();
	ACCOUNT ac = null;
	while(iterator.hasNext()){
		ac = (ACCOUNT)iterator.next();
%>
		<%=ac.toString() %><br/>
<%		
	}

}

%>
</body>
</html>