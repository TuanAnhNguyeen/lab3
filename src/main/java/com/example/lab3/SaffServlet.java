package com.example.lab3;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@MultipartConfig
@WebServlet("/staff")
public class SaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/Staff/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        SaffModel saff = new SaffModel();
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("yyyy-mm-dd");
            ConvertUtils.register(dtc, Date.class);
            BeanUtils.populate(saff, req.getParameterMap());
            System.out.println(saff.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(req.getServletContext().getRealPath("/files"));
        if(!file.exists()){
            file.mkdirs();
        }
        Part photo = req.getPart("photo");
        File photo_file = new File(file, photo.getSubmittedFileName());
        photo.write(photo_file.getAbsolutePath());
        boolean check = true;
        if (saff.getName().trim().equals("")) {
            req.setAttribute("errName", "Bạn chưa nhập Tên Đăng Nhập");
            check = false;
        }
        String a = req.getParameter("ngaySinh");
        String gender = req.getParameter("gender");
        ;
        if (a.equals("")) {
            req.setAttribute("errDate", "Bạn chưa chọn ngày sinh");
            check = false;
        } else {
            try {
                Date date = new SimpleDateFormat("yyyy-mm-dd").parse(a);
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                int yearofBrith = c.get(c.YEAR);
                c.setTime(new Date());
                int yearNow = c.get(c.YEAR);
                if (yearNow - yearofBrith < 18) {
                    req.setAttribute("errDate", "Bạn Chưa Đủ 18 tuổi mời bạn chọn đúng ngày sinh");
                    check = false;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        if (gender == null) {
            req.setAttribute("errGender", "Bạn chưa Chọn Giới Tính");
            check = false;
        }
        if (check == false) {
            req.getRequestDispatcher("/views/Staff/form.jsp").forward(req, resp);
            return;
        }
        String uri = req.getRequestURI();
        saff.setPhoto(photo_file.getName());
        req.setAttribute("bean", saff);
        if (uri.contains("/staff")) {
            req.getRequestDispatcher("/views/Staff/result.jsp").forward(req, resp);
        }
    }
}
