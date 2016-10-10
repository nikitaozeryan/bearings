/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearing;

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
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
    String user = request.getParameter("user"); 
    String pass = request.getParameter("pass"); 
        if(user != null && pass !=null){ 
            if(user.equals("admin") && pass.equals("adin")){ 
                Cookie auth = new Cookie("auth", "accepted"); 
                response.addCookie(auth); 
                response.sendRedirect("secured"); 
            } 
                else{ 
                    response.sendError(401, "bad credentials"); 
                    } 
        } 
    }
    

   
   
}
