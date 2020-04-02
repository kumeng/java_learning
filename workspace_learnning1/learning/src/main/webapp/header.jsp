<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setContentType("text/html;charset=UTF-8");
%>
    
<div class="header">
<div  class="title">    
在线拍卖系统
</div>
<div class="login">
<c:if test="${sessionScope.loginUser!=null}">
    <a class="button" href="Login?action=logout" onclick="">注销</a>

</c:if>

<c:if  test="${sessionScope.loginUser==null}" >
<a class="button" href="login.jsp" onclick="">登录</a>
</c:if>
</div>
</div>

