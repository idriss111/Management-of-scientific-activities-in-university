<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Menu1.css">
</head>
<body>
<nav>
  <input class="toggle" id="nav" type="checkbox"/>
  <label class="label" for="nav">
    <p>Menu</p><span class="hum"></span>
    <ul class="list">
      <li class="list__home"><a href="${pageContext.request.contextPath}">Home</a></li>
      <li class="list__about"><a href="About.jsp">About</a></li>
      <li class="list__contact"><a href="${pageContext.request.contextPath}/Projets">Publications</a></li>
    </ul>
  </label>
</nav>
</body>
</html>