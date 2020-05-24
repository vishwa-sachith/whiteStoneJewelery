/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Pojos.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ASUS
 */
public class ResetPw extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("pw").equals(request.getParameter("cpw")) && !"".equals(request.getParameter("pw")) && !"".equals(request.getParameter("cpw"))) {
            
            String email;
            
            HttpSession ses = request.getSession();
            Session sess = Connection.NewHibernateUtil.getSessionFactory().openSession();
            
            if (ses.getAttribute("em")!=null) {
                System.out.println("monahukkdnasnzxjhn");
                System.out.println("wtf man   "+ses.getAttribute("em"));
                email = (String) ses.getAttribute("em");

            } else {
                User u = (User) ses.getAttribute("user");
                email = u.getEmail();
                
                if (u.getPassword().equals(request.getParameter("oldpw"))) {

                } else {
                    response.getWriter().write("Wrong Old Password");
                }
                
            }
            
                User l = (User) sess.load(User.class, email);
                
                l.setBackupPin(null);
                l.setStatus("1");
                l.setPassword(request.getParameter("pw"));
                
                ses.setAttribute("em", null);
                
                Transaction tr = sess.beginTransaction();

                sess.update(l);

                tr.commit();
            
                response.getWriter().write("gg");
            
        } else {
            response.getWriter().write("Password Dont Match");
        }        
        
    }


}
