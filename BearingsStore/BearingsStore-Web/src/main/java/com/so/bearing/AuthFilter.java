package com.so.bearing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Никита
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/secured","/users"})
public class AuthFilter implements Filter {
    
    private FilterConfig filterConfig = null;
    
    public AuthFilter() {
    }    
    
     
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest)request).getCookies();
        Cookie auth = null;
        for(Cookie c: cookies){
            if(c.getName().equals("auth"))
                auth = c;
        }
        if(auth ==null){
            ((HttpServletResponse)response).sendError(401, "bad credentials");
        }else{
            String value = auth.getValue();
            if(!value.equals("accepted")){
                ((HttpServletResponse)response).sendError(401, "bad credentials");
            }else{
                chain.doFilter(request, response);
            }
        }
               
        
    }

    
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    
    
}
