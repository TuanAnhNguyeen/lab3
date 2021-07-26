package com.example.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String getUsername = CookieUtils.get("username",req);
        String getPass = CookieUtils.get("passworld",req);
        req.setAttribute("username",getUsername);
        req.setAttribute("pass",getPass);
       req.getRequestDispatcher("/views/login/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pass = req.getParameter("pass");
        String remember = req.getParameter("remember");
        boolean check = true;
        if(!username.equalsIgnoreCase("poly")){
            req.setAttribute("errUsername","Sai Tên Đăng Nhập");
            check=false;
        }
        if(!pass.equalsIgnoreCase("poly")){
            req.setAttribute("errPass","Sai Mật Khẩu");
            check=false;
        }
        if(check==false){
            req.getRequestDispatcher("/views/login/login.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("img","Đăng Nhập Thành Công");
        int hours = (remember==null) ? 0 : 30*24;
        CookieUtils.add("username",username,hours,resp);
        CookieUtils.add("passworld",pass,hours,resp);
        req.getRequestDispatcher("/views/login/login.jsp").forward(req,resp);
    }
}
