/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Connection.NewHibernateUtil;
import Pojos.Img;
import Pojos.Material;
import Pojos.Product;
import Pojos.Type;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author ASUS
 */
public class LoadProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            Session s = NewHibernateUtil.getSessionFactory().openSession();

            Criteria c = s.createCriteria(Product.class);

            JSONParser jp = new JSONParser();

            String ss = req.getParameter("a");
            String i = req.getParameter("i");
            JSONObject ob = (JSONObject) jp.parse(ss);

            /*               JSONArray arr1 = (JSONArray) jp.parse(ob.get("os").toString());
             if (!arr1.isEmpty()) {
             JSONArray arr = (JSONArray) jp.parse(ob.get("os").toString());

             // Criteria cc = s.createCriteria(ProductHasFeatures.class);
             // cc.add(Restrictions.in("value", arr));
                    
             for (int i = 0; i < arr.size(); i++) {
             Criterion cri = (Restrictions.eq("value", arr.get(i).toString()));
             //  cc.add(Restrictions.or(cri));
                    
             }
             //List<ProductHasFeatures> ll = cc.list();
                    
                
             ArrayList al=new ArrayList();
                
             //  for (ProductHasFeatures ll1 : ll) {
             //        al.add(ll1.getProduct().getId());
             //     }
                
             c.add(Restrictions.in("id", al));
                
             for (int i = 0; i < ll.size(); i++) {
             System.out.println(ll.get(i)+" omggg");
             Criterion cri = (Restrictions.eq("value", arr.get(i)));
             c.add(Restrictions.or(cri));
                    
             }
                    
             //c.add(Restrictions.in("productHasFeatureses", ll));
                    
                

             } */
            if (!ob.get("min").equals("")) {
                if (!ob.get("max").equals("")) {
                    c.add(Restrictions.between("price", Integer.parseInt(ob.get("min").toString()), Integer.parseInt(ob.get("max").toString())));
                } else {
                    c.add(Restrictions.between("price", Integer.parseInt(ob.get("min").toString()), 999999999));
                }

            } else {
                if (!ob.get("max").equals("")) {
                    c.add(Restrictions.between("price", 0, Integer.parseInt(ob.get("max").toString())));
                }
            }

            if (!ob.get("material").toString().equals("0")) {
                Material bbo = (Material) s.load(Material.class, Integer.parseInt(ob.get("material").toString()));
                c.add(Restrictions.like("material", bbo));
            }

            if (!ob.get("type").toString().equals("0")) {
                Criteria cc = s.createCriteria(Type.class);
                cc.add(Restrictions.eq("type", ob.get("type").toString()));
                Type bbo = (Type) cc.uniqueResult();
                c.add(Restrictions.eq("type", bbo));
            }

            c.add(Restrictions.like("name", ob.get("name").toString(), MatchMode.START));

            if (ob.get("asd").toString().equals("ard")) {
                c.addOrder(Order.asc("dateCreated"));
            } else if (ob.get("asd").toString().equals("drd")) {
                c.addOrder(Order.desc("dateCreated"));
            } else if (ob.get("asd").toString().equals("ap")) {
                c.addOrder(Order.asc("price"));
            } else if (ob.get("asd").toString().equals("dp")) {
                c.addOrder(Order.desc("price"));
            }

            int page = c.list().size() / 4;//pages kiyak thiyenawada kiyala

            String buttons = "";
            for (int j = 0; j <= page; j++) {

                buttons += "<td><input type=\"button\" value=\"" + (j + 1) + "\" onclick=\"m(" + (j * 4) + ");\"></td>";

            }

            c.setFirstResult(Integer.parseInt(i));//starting node
            c.setMaxResults(4);//count

            List<Product> l = c.list();

            JSONArray a = new JSONArray();

            for (Product u : l) {

                JSONObject ar = new JSONObject();
                ar.put("name", u.getName());
                ar.put("price", u.getPrice());
                ar.put("count", u.getCount());
                ar.put("id", u.getId());
                ar.put("desc", u.getDescription());
                ar.put("type", u.getType().getType());

                Material bbo = (Material) s.load(Material.class, u.getMaterial().getId());
                ar.put("material", bbo.getMaterial());
                System.out.println(bbo.getMaterial());

                Criteria cc = s.createCriteria(Img.class);
                cc.add(Restrictions.eq("product", u));
                Img im = (Img) cc.uniqueResult();
                ar.put("imgone", im.getUrl1());
                a.add(ar);

            }

            resp.getWriter().write(a.toJSONString() + "^" + buttons);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
