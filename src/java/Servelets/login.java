/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Connection.NewHibernateUtil;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import Pojos.Cart;
import Pojos.CartHasProduct;
import Pojos.Product;
import Pojos.User;
import javax.servlet.http.Cookie;

/**
 *
 * @author ASUS
 */
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String u = request.getParameter("email");
            String p = request.getParameter("pw");
            boolean b = false;

            if (request.getSession().getAttribute("cart") == null) {
                System.out.println("llllllll");
            } else {
                System.out.println("pppppppp");
                b = true;
            }

            System.out.println(u + p);
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            /*
             Criteria c = s.createCriteria(User.class);
             c.add(Restrictions.eq("email", u));
             c.add(Restrictions.eq("password", p));
             System.out.println("eeeeeeeeeeeeeeeeeeeee");
             User l = (User) c.uniqueResult();
             System.out.println("eeoooooooooooooo");
             */

            User l = (User) s.load(User.class, u);

            if (l != null) {

                if (l.getPassword().equals(p)) {

                    if (l.getStatus().equals("1")) {

                        HttpSession ses = request.getSession();
                        ses.setAttribute("user", l);
                        System.out.println("done nigga");

                        if (request.getParameter("rembme").equals("yep")) {
                            Cookie c = new Cookie("em", u);
                            c.setMaxAge(2592000);
                            response.addCookie(c);

                            Cookie c2 = new Cookie("pw", p);
                            c2.setMaxAge(2592000);
                            response.addCookie(c2);
                        }

                        if (b) {
                            addToDbCart(request, response, l);
                        }
                        response.getWriter().write("aa");

                    } else {
                        response.getWriter().write(l.getStatus());
                    }

                } else {
                    response.getWriter().write("Wrong Password");
                    System.out.println("fuckoff wrongPW");
                }

            } else {
                System.out.println("fuckoff");
                response.getWriter().write("Wrong Email");

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

    private void addToDbCart(HttpServletRequest request, HttpServletResponse response, User l) throws IOException {

        User u = (User) l;

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Criteria c = s.createCriteria(Cart.class);
        c.add(Restrictions.eq("user", u));

        //Cart sc = (Cart) request.getSession().getAttribute("cart");
        ArrayList<CartHasProduct> carthp = (ArrayList<CartHasProduct>) request.getSession().getAttribute("cart_has_products");

        for (CartHasProduct carthp1 : carthp) {
            Product p = carthp1.getProduct();
            int iqty = carthp1.getQuantity();

            if (c.list().isEmpty()) {
                //no cart make new cart
                System.out.println("ane mnda");
                Cart ct = new Cart();
                ct.setUser(u);

                CartHasProduct chp = new CartHasProduct();
                chp.setCart(ct);
                chp.setProduct(p);
                chp.setQuantity(iqty);

                s.save(ct);
                s.save(chp);

                Transaction t = s.beginTransaction();
                t.commit();
                s.flush();

            } else {
                System.out.println("epa wenwa");

                Cart ct = (Cart) c.uniqueResult();

                Criteria cl = s.createCriteria(CartHasProduct.class);
                cl.add(Restrictions.eq("cart", ct));
                cl.add(Restrictions.eq("product", p));

                if (cl.list().isEmpty()) {
                    System.out.println("omg");
                    CartHasProduct chp = new CartHasProduct();
                    chp.setCart(ct);
                    chp.setProduct(p);
                    chp.setQuantity(iqty);

                    s.save(chp);

                    Transaction t = s.beginTransaction();
                    t.commit();
                    s.flush();

                } else {
                    System.out.println("oooooo");

                    CartHasProduct chp = (CartHasProduct) cl.uniqueResult();

                    int already_added = chp.getQuantity();

                    if (already_added + iqty > p.getCount()) {
                        response.getWriter().write("Can't Update Cart");
                    } else {
                        chp.setQuantity(already_added + iqty);
                        s.update(chp);

                        Transaction t = s.beginTransaction();
                        t.commit();
                        s.flush();
                    }

                }

            }

        }

        request.getSession().setAttribute("cart_has_products", new ArrayList<CartHasProduct>());

    }

}
