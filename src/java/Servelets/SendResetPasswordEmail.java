/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Classes.SendMail;
import Connection.NewHibernateUtil;
import Pojos.User;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ASUS
 */
public class SendResetPasswordEmail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String em = request.getParameter("email");
            System.out.println(em);
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = s.createCriteria(User.class);
            cr.add(Restrictions.eq("email", em));
            User l = (User) cr.uniqueResult();
            if ("".equals(em)) {
                System.out.println("mona huttkda");
                response.getWriter().write("Enter Email");
            } else {
                if (l != null) {
                    if (l.getEmail().equals(em)) {
                        System.out.println(l.getEmail());
                        System.out.println(l.getFname());
                        Random rand = new Random();
                        int value = rand.nextInt(999999);
                        String ss = "http://localhost:8080/WhiteStoneJwell/PwResetRedirect.jsp?pin=" + value + "&em=" + em;
                        String sss = "<a href=\"" + ss + "\">Click here To Reset Password</a>";
                        SendMail sm = new SendMail();
                        sm.sendEmail("Reset Password", em, sss);
                        l.setBackupPin(value + "");
                        l.setStatus("100");
                        s.update(l);
                        Transaction t = s.beginTransaction();
                        t.commit();
                        s.flush();
                        response.getWriter().write("Link Sent To Your Account");
                    } else {
                        System.out.println("oooiippppiii");
                        response.getWriter().write("Wrong Email");
                    }
                } else {
                    System.out.println("oooiiiii");
                    response.getWriter().write("Wrong Email");
                }
            }
        } catch (org.hibernate.ObjectNotFoundException ee) {
            System.out.println("User Not Found");
            response.getWriter().write("User Not Found");
        } catch (java.lang.NullPointerException ex) {
            response.getWriter().write("Enter Data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
