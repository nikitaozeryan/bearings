/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearing;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Никита
 */
public class CheckRegistration extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        String sample = "as";
        if(key.equals(sample)){
            req.setAttribute("result", "Success");
        }
        else{
            req.setAttribute("result", "Error");
        }
        req.getRequestDispatcher("WEB-INF/views/checkreg.jsp").forward(req, resp);
    }
     
}
