/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearing;

import com.so.bearingsstore.domain.Users;
import com.so.bearingsstore.domain.UsersDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Никита
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
     
               
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        String login = request.getParameter("user");
        String pass = request.getParameter("pass");
        try{
        Users user = new UsersDaoImpl().getbyLogin(login);
            if(user.getPassword().equals(pass))
            {
                Cookie auth = new Cookie("auth", "accepted");
                response.addCookie(auth); 
                response.sendRedirect("users"); 
            }
            else{ 
                    response.sendError(401, "bad credentials"); 
                } 
        }
        catch(Exception ex)
        {
            response.sendError(401, "bad credentials");
        }
        
    }
    

   
   
}
