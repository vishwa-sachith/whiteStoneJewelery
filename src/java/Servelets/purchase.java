/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Connection.NewHibernateUtil;
import Pojos.Cart;
import Pojos.CartHasProduct;
import Pojos.Img;
import Pojos.Product;
import Pojos.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
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
public class purchase extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            User u = (User) request.getSession().getAttribute("user");
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            Criteria cc = s.createCriteria(Cart.class);
            cc.add(Restrictions.eq("user", u));
            Cart c = (Cart) cc.uniqueResult();
            Set<CartHasProduct> chp_set = c.getCartHasProducts();
            Cart c1 = (Cart) cc.uniqueResult();
            Set<CartHasProduct> chp_set1 = c1.getCartHasProducts();
            Transaction tr = s.beginTransaction();
            for (CartHasProduct chp : chp_set) {
                Product p = chp.getProduct();
                p.setCount(p.getCount() - chp.getQuantity());
                s.delete(chp);
                s.update(p);
            }
                tr.commit();
                s.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
