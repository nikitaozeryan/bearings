/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearing;

import com.so.bearingsstore.domain.Users;
import com.so.bearingsstore.domain.UsersDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stan
 */
@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/deleteuser"})
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = -1;
        try{
            id = Integer.parseInt(req.getParameter("id"));
            if(id <= 0)
                throw new Exception ("illegal id");
        }catch(Exception ex){
            resp.sendError(404, "User not found or illegal identyfier");
        }
        
        UsersDaoImpl us = new UsersDaoImpl();
        try{
            int num = us.deleteUser(id);
            if(num > 0){
                resp.sendRedirect("users");
            }else{
                throw new Exception();
            }
        }catch(Exception ex){
            resp.sendError(404, "User not found or illegal identyfier");
        }
        
        
    }
    
    
    
}
