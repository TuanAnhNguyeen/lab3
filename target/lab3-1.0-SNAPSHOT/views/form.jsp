<%--
  Created by IntelliJ IDEA.
  User: Duy
  Date: 7/2/2021
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="uploadfile" method="post"  enctype="multipart/form-data">
      Hình Ảnh : <input type="file" name="photo_file"  required accept=".jpg,.png" > <br>
      Tài Liệu : <input type="file" name="readFile" required accept=".doxc,.pdf,.xlsx"> <br>
      <hr>
      <button>Upload</button>
    </form>
</body>
</html>
