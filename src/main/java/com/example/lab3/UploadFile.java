package com.example.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
@MultipartConfig
@WebServlet("/uploadfile")
public class UploadFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/views/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File(req.getServletContext().getRealPath("files"));
        if(!file.exists()){
            file.mkdirs();
        }
        Part photo = req.getPart("photo_file");
        File photoFile = new File(file, photo.getSubmittedFileName());
        photo.write(photoFile.getAbsolutePath());
        System.out.println(photoFile);

        Part read = req.getPart("readFile");
        File readFile = new File(file, read.getSubmittedFileName());
        read.write(readFile.getAbsolutePath());

        req.setAttribute("img",photoFile);
        req.setAttribute("read",readFile);
        req.getRequestDispatcher("/views/result.jsp").forward(req,resp);

    }
}
