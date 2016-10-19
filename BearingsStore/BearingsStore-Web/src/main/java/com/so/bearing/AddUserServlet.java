/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearing;


import com.so.bearingsstore.domain.Users;
import com.so.bearingsstore.domain.UsersDaoImpl;
import com.sun.mail.handlers.text_html;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddUserServlet", urlPatterns = {"/adduser"})
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/adduser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        
        List<String> errors = new ArrayList<>();
        
        if(firstname!=null){
            if(firstname.length() == 0){
                errors.add("Empty firstname");
            }
        }else{
            errors.add("Empty firstname");
        }
        
        if(lastname!=null){
            if(lastname.length() == 0){
                errors.add("Empty lastname");
            }
        }else{
            errors.add("Empty lastname");
        }
        
        if(new UsersDaoImpl().getbyLogin(login) != null)
        {
            errors.add("Login exist");
        }
        if(login!=null){
            if(login.length() == 0){
                errors.add("Empty login");
            }
        }else{
            errors.add("Empty login");
        }
        
        if(phone!=null){
            if(phone.length() == 0){
                errors.add("Empty phone");
            }
        }else{
            errors.add("Empty phone");
        }
        
        if(email!=null){
            if(email.length() == 0){
                errors.add("Empty email");
            }
        }else{
            errors.add("Empty email");
        }
        
        if(password!=null){
            if(password.length() == 0){
                errors.add("Empty password");
            }
        }else{
            errors.add("Empty password");
        }
        
        
        if(errors.size() > 0){
            req.setAttribute("errors", errors);
            req.setAttribute("firstname", firstname);
            req.setAttribute("lastname", lastname);
            req.setAttribute("login", login);
            req.setAttribute("email", email);
            req.setAttribute("phone", phone);
            req.getRequestDispatcher("WEB-INF/views/adduser.jsp").forward(req, resp);
        }else{
            Users u = new Users();
            u.setEmail(email);
            u.setFirstname(firstname);
            u.setLastname(lastname);
            u.setLogin(login);
            u.setPassword(password);
            u.setPhone(phone);
            
            new UsersDaoImpl().save(u);
            
            // allohadance
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, 
                    new GmailAuthenticator(
                    CredentialsBundle.resolveCredentials("username"),
                    CredentialsBundle.resolveCredentials("password"))
                    
            );
            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("ozeryan.nikita@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ozeryan.nikita@gmail.com"));
                message.setSubject("<a href=\"localhost:8080/check?key=as>checkemail</a>");
                message.setHeader("Content-type", "text/html");
                
                message.setText("Dear "  + u.getFirstname() + " " + u.getLastname() +
                        "\n\n <a href=\"localhost:8080/check?key=as>checkemail</a>");
                Transport.send(message);
                System.out.println("Done"); 
            }
            catch(MessagingException e){
                System.out.println("err");
            }
            
            //allohadanceend
            
            
            
            
            
            
            
            
            
            resp.sendRedirect("users");
        }  
    }
    static class GmailAuthenticator extends Authenticator{
                String user;
                String pw;
                public GmailAuthenticator(String name, String password)
                {
                    super();
                    this.user = name;
                    this.pw = password;
                }
                public PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(user, pw);
                }
            }
    
    
    
    
}
