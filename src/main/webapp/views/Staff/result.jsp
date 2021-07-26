<%--
  Created by IntelliJ IDEA.
  User: Duy
  Date: 6/30/2021
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thông Tin Đăng Kí</h1>
<ul>
    <li>Họ Tên là : <b>${bean.name}</b></li>
    <li>Hình Ảnh : <img src="files/${bean.photo}" width="200" height="200"></li>
    <li>Ngày Sinh là : <b>${bean.convertNgaySinh()}</b></li>
    <li>Giới Tính là : <b>${bean.gender ? "Nam" : "Nữ"}</b></li>
    <li>Quốc Tịch là : <b>${bean.country == "vn" ? "Việt Nam" : "Mỹ"}</b></li>
    <li>Tình Trạng Hôn Nhân là : <b>${bean.married ? "Đã Kết Hôn" : "Chưa kết hôn"}</b></li>
    <li>Sở Thích là : <b>${bean.toString()}</b></li>
    <li>Ghi Chú la :<b>${bean.note}</b></li>
</ul>
</body>
</html>
