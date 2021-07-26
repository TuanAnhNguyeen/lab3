<%--
  Created by IntelliJ IDEA.
  User: Duy
  Date: 7/5/2021
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h1>Send Mail</h1>
        <form action="sendEmail" method="post">
            From : <input type="email" name="emailFrom">
            To : <input type="email" name ="emailTo">
            Subject : <input type="text" name="subject">
            Body : <textarea name="body"></textarea>
            <hr>
            <button>send</button>
        </form>
</body>
</html>
