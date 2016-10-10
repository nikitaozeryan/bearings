/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearing;

import com.so.bearingsstore.domain.BearingDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Никита
 */
@WebServlet(name = "MainPageServlet", urlPatterns = {"/main"})
public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bearings", new BearingDaoImpl().getList());
        req.getRequestDispatcher("main.jsp").forward(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

   

    
}
