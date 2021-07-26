<%--
  Created by IntelliJ IDEA.
  User: Duy
  Date: 7/2/2021
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <h2>1. Hình : ${img.name}</h2>
      <img src="files/${img.name}" height="100">
      <h2>2. Tài Liệu : ${read.name}</h2>
      <a href="files/${read.name}">Tải Về</a>
</body>
</html>
