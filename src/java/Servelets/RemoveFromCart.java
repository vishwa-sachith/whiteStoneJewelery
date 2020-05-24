/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Connection.NewHibernateUtil;
import Pojos.Cart;
import Pojos.CartHasProduct;
import Pojos.Product;
import Pojos.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class RemoveFromCart extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            String qty = request.getParameter("qty");
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            Product p = (Product) s.load(Product.class, Integer.parseInt(id));
            System.out.println(id);
            boolean isInt = false;

            try {
                Integer.parseInt(qty);
                isInt = true;
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (isInt) {

                int iqty = Integer.parseInt(qty);

                if (iqty >= 1) {

                    User u = (User) request.getSession().getAttribute("user");

                    if (request.getSession().getAttribute("user") != null) {
                        //logged
                        Criteria c = s.createCriteria(Cart.class);
                        c.add(Restrictions.eq("user", u));
                        Cart ct = (Cart) c.uniqueResult();

                        Criteria cl = s.createCriteria(CartHasProduct.class);
                        cl.add(Restrictions.eq("cart", ct));
                        cl.add(Restrictions.eq("product", p));

                        CartHasProduct chp = (CartHasProduct) cl.uniqueResult();

                        int already_added = chp.getQuantity();

                        if (already_added >= iqty) {
                            chp.setQuantity(already_added - iqty);

                            if (chp.getQuantity() == 0) {
                                s.delete(chp);
                            } else {
                                s.update(chp);
                            }

                            Transaction t = s.beginTransaction();
                            t.commit();
                            s.flush();
                        } else {
                            response.getWriter().write("Can't Update Cart");

                        }

                    } else {
                        //not logged
                        ArrayList<CartHasProduct> carthp = (ArrayList<CartHasProduct>) request.getSession().getAttribute("cart_has_products");

                        for (CartHasProduct carthp1 : carthp) {

                            if (carthp1.getProduct().getId().equals(Integer.parseInt(id))) {

                                if (carthp1.getQuantity() >= iqty) {
                                    carthp1.setQuantity(carthp1.getQuantity() - iqty);
                                    if (carthp1.getQuantity() == 0) {
                                        carthp.remove(carthp1);
                                    }
                                } else {
                                    response.getWriter().write("Can't Update Cart");
                                }

                            }

                        }

                        request.getSession().setAttribute("cart_has_products", carthp);

                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
