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
@WebServlet(name = "EditUserServlet", urlPatterns = {"/edituser"})
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        Users u;
        try{
            id = Integer.parseInt(req.getParameter("id"));
            if(id <= 0){
                throw new IllegalArgumentException();
            }
            
            u = new UsersDaoImpl().getById(id);
            if(u == null){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException ex){
            resp.sendError(404, "Such user not found");
            return;
        }
        
        req.setAttribute("user", u);
        req.getRequestDispatcher("WEB-INF/views/edituser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        Users u;
        try{
            id = Integer.parseInt(req.getParameter("id"));
            if(id <= 0){
                throw new IllegalArgumentException();
            }
            
            u = new UsersDaoImpl().getById(id);
            if(u == null){
                throw new IllegalArgumentException();
            }
            u.setFirstname(req.getParameter("firstname"));
            u.setLastname(req.getParameter("lastname"));
            u.setEmail(req.getParameter("email"));
            u.setPhone(req.getParameter("phone"));
            new UsersDaoImpl().update(u);
            resp.sendRedirect("users");
        }catch(IllegalArgumentException ex){
            resp.sendError(404, "Such user not found");
        }
    }
    
    
    
}
