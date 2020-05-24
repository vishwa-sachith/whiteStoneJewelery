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
public class addtocart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            String pid = request.getParameter("id");
            String qty = request.getParameter("qty");
            System.out.println(pid);
            boolean isInt = false;
            try {
                Integer.parseInt(qty);
                isInt = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (isInt) {
                //valid qty
                System.out.println("ai yakooo");
                int iqty = Integer.parseInt(qty);
                Session s = NewHibernateUtil.getSessionFactory().openSession();
                Product p = (Product) s.load(Product.class, Integer.parseInt(pid));
                if (iqty > p.getCount()) {
                    response.getWriter().write("Qumtity Out Of Stock");
                } else {
                    //qty Ok
                    System.out.println("mona magulkda");
                    User u = (User) request.getSession().getAttribute("user");
                    if (iqty >= 1) {
                        //qty - value ek neme
                        if (request.getSession().getAttribute("user") != null) {
                            //user logged
                            //add to cart
                            Criteria c = s.createCriteria(Cart.class);
                            c.add(Restrictions.eq("user", u));
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
                        } else {
                            //user not logged add to session cart
                            if (request.getSession().getAttribute("cart") != null) {
                                //cart ekk thiyenwa ekata add krnna
                                Cart cc = (Cart) request.getSession().getAttribute("cart");
                                ArrayList<CartHasProduct> carthp = (ArrayList<CartHasProduct>) request.getSession().getAttribute("cart_has_products");
                                boolean yy = true;
                                for (CartHasProduct carthp1 : carthp) {
                                    if (carthp1.getProduct().getId().equals(Integer.parseInt(pid))) {
                                        carthp1.setQuantity(iqty + carthp1.getQuantity());
                                        yy=false;
                                        break;
                                    }
                                }
                                if (yy) {
                                    System.out.println("oohh yeeeaahhh");
                                    CartHasProduct chpp = new CartHasProduct();
                                    chpp.setCart(cc);
                                    chpp.setProduct(p);
                                    chpp.setQuantity(iqty);
                                    carthp.add(chpp);
                                    System.out.println("hari");
                                }
                                request.getSession().setAttribute("cart_has_products", carthp);
                            } else {
                                //cart ekk nh hdnna
                                Cart c = new Cart();
                                c.setUser(u);
                                ArrayList<CartHasProduct> carthp = new ArrayList<CartHasProduct>();
                                CartHasProduct chp = new CartHasProduct();
                                chp.setCart(c);
                                chp.setProduct(p);
                                chp.setQuantity(iqty);
                                carthp.add(chp);
                                request.getSession().setAttribute("cart", c);
                                request.getSession().setAttribute("cart_has_products", carthp);
                                System.out.println(chp.getProduct().getName() + " " + chp.getQuantity() + "ssssss");
                            }
                        }
                    } else {
                        response.getWriter().write("Invalide Quntity Type");
                    }
                }
            } else {
                response.getWriter().write("Invalide Quntity Type");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
