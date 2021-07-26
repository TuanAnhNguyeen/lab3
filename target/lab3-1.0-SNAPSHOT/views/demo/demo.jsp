<%--
  Created by IntelliJ IDEA.
  User: Duy
  Date: 7/24/2021
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
</head>
<body>
<div class="card-body">
  <div class="wrapper text-center">
    <h4 class="card-title">Alerts Popups</h4>
    <p class="card-description">A success message!</p> <button class="btn btn-outline-success" onclick="showSwal('success-message')">Click here!</button>
  </div>
</div>
<script>
  (function($) {
    showSwal = function(type) {
      'use strict';
      if (type === 'success-message') {
        swal({
          title: 'Congratulations!',
          text: 'You entered the correct answer',
          type: 'success',
          button: {
            text: "Continue",
            value: true,
            visible: true,
            className: "btn btn-primary"
          }
        })

      }else{
        swal("Error occured !");
      }
    }

  })(jQuery);
</script>
</body>
</html>
