package com.example.lab3;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/sendEmail")
public class Email extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/sendEmail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = "doduy23071995@gmail.com";
        final String passworld = "anhyeu12345";

        String emailFrom = req.getParameter("emailFrom");
        String emailTo = req.getParameter("emailTo");
        String subject = req.getParameter("subject");
        String body = req.getParameter("body");
        System.out.println(body);

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.ssl.trust", "*");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
//                String username = "thutamxd@gmail.com";
//                String password = "thutam123";
                return new PasswordAuthentication(username, passworld);
            }
        });

        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress("thutamxd@gmail.com"));
            mimeMessage.setRecipients(Message.RecipientType.TO, emailTo);
            mimeMessage.setSubject(subject, "UTF-8");
            mimeMessage.setText(body, "UTF-8", "html");
            mimeMessage.setReplyTo(mimeMessage.getFrom());

            Transport.send(mimeMessage);
            System.out.println("thành công");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
