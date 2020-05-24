/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Connection.NewHibernateUtil;
import Pojos.Purity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author ASUS
 */
public class logout extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().setAttribute("user", null);
        Cookie c = new Cookie("em", "10");
            c.setMaxAge(0);
            response.addCookie(c);
            
            Cookie c2 = new Cookie("pw", "10");
            c2.setMaxAge(0);
            response.addCookie(c2);
            

            
        
    }


}
