/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Classes.AddToTableObject;
import Pojos.Img;
import Pojos.Material;
import Pojos.Product;
import Pojos.ProductHasStone;
import Pojos.Purity;
import Pojos.Stone;
import Pojos.Type;
import Pojos.Weight;
import Pojos.Weightmesurement;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ASUS
 */
public class RegProducts extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nam = null;
            Type t = new Type();
            Session sess = Connection.NewHibernateUtil.getSessionFactory().openSession();
            Product product = new Product();
            Img im = new Img();
            Weightmesurement wm = new Weightmesurement();
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload files = new ServletFileUpload(factory);
            List<FileItem> items = files.parseRequest(req);
            for (FileItem fileitem : items) {
                if (fileitem.getFieldName().equals("weightmesurement")) {
                    wm.setId(Integer.parseInt(fileitem.getString()));
                }
            }
            for (FileItem fileitem : items) {
                if (fileitem.isFormField()) {
                    if (fileitem.getFieldName().equals("type")) {
                        t.setId(Integer.parseInt(fileitem.getString()));
                        product.setType(t);
                    } else if (fileitem.getFieldName().equals("name")) {
                        //Product l = (Product) sess.load(Product.class, fileitem.getString());
                        Criteria c = sess.createCriteria(Product.class);
                        c.add(Restrictions.eq("name", fileitem.getString()));
                        Product l = (Product) c.uniqueResult();
                        if (l != null) {
                            resp.getWriter().write("aa");
                        }
                        product.setName(fileitem.getString());
                        nam = fileitem.getString();
                    } else if (fileitem.getFieldName().equals("purity")) {
                        Purity p = new Purity();
                        p.setId(Integer.parseInt(fileitem.getString()));
                        product.setPurity(p);
                    } else if (fileitem.getFieldName().equals("weight")) {
                        Criteria c = sess.createCriteria(Weight.class);
                        c.add(Restrictions.eq("weight", fileitem.getString()));
                        c.add(Restrictions.eq("weightmesurement", wm));
                        //Weight l = (Weight) c.uniqueResult();
                        List<Weight> ll = c.list();
                        if (ll.isEmpty()) {
                            Weight w = new Weight();
                            w.setWeightmesurement(wm);
                            w.setWeight(fileitem.getString());
                            Transaction tr = sess.beginTransaction();
                            sess.save(w);
                            tr.commit();
                        }
                        Criteria c2 = sess.createCriteria(Weight.class);
                        c2.add(Restrictions.eq("weight", fileitem.getString()));
                        c2.add(Restrictions.eq("weightmesurement", wm));
                        List<Weight> ll2 = c2.list();
                        product.setWeight(ll2.get(0));
                    } else if (fileitem.getFieldName().equals("material")) {
                        Material m = new Material();
                        m.setId(Integer.parseInt(fileitem.getString()));
                        product.setMaterial(m);
                    } else if (fileitem.getFieldName().equals("cost")) {
                        product.setCost(Integer.parseInt(fileitem.getString()));
                    } else if (fileitem.getFieldName().equals("price")) {
                        product.setPrice(Integer.parseInt(fileitem.getString()));
                    } else if (fileitem.getFieldName().equals("discount")) {
                        if ("".equals(fileitem.getString())) {
                            product.setDiscount(0);
                        } else {
                            product.setDiscount(Integer.parseInt(fileitem.getString()));
                        }
                    } else if (fileitem.getFieldName().equals("datecreated")) {
                        if (!fileitem.getString().equals("")) {
                            product.setDateCreated(new SimpleDateFormat("yyyy-MM-dd").parse(fileitem.getString()));
                        }
                    } else if (fileitem.getFieldName().equals("count")) {
                        product.setCount(Integer.parseInt(fileitem.getString()));
                    } else if (fileitem.getFieldName().equals("description")) {
                        product.setDescription(fileitem.getString());
                    }
                } else {
                    String actualpath = req.getServletContext().getRealPath("/");
                    String folder = "Images\\Product_Images\\";
                    String name = null;

                    if (fileitem.getFieldName().equals("file1")) {
                        name = nam + "1.jpg";
                        im.setUrl1(name);
                    } else if (fileitem.getFieldName().equals("file2")) {
                        name = nam + "2.jpg";
                        im.setUrl2(name);
                    } else if (fileitem.getFieldName().equals("file3")) {
                        name = nam + "3.jpg";
                        im.setUrl3(name);
                    } else if (fileitem.getFieldName().equals("file4")) {
                        name = nam + "4.jpg";
                        im.setUrl4(name);
                    } else if (fileitem.getFieldName().equals("file5")) {
                        name = nam + "5.jpg";
                        im.setUrl5(name);
                    }
                    String path = actualpath + folder + name;
                    System.out.println(path);
                    File f = new File(path);
                    fileitem.write(f);
                }
            }
            product.setStatus("1");
            Transaction tr = sess.beginTransaction();
            sess.save(product);
            tr.commit();
            Criteria c = sess.createCriteria(Product.class);
            c.add(Restrictions.eq("name", nam));
            Product l = (Product) c.uniqueResult();
            im.setProduct(l);
            sess.save(im);
            Transaction tr1 = sess.beginTransaction();
            sess.save(product);
            tr1.commit();
            HashMap<String, AddToTableObject> tbh = (HashMap<String, AddToTableObject>) req.getSession().getAttribute("tbhmap");
            for (Map.Entry me : tbh.entrySet()) {
                AddToTableObject gg = (AddToTableObject) me.getValue();
                ProductHasStone phs = new ProductHasStone();
                phs.setProduct(l);
                Stone s = new Stone();
                s.setId(Integer.parseInt(gg.getStoneid()));
                phs.setStone(s);
                Purity p = new Purity();
                p.setId(Integer.parseInt(gg.getPurityid()));
                phs.setPurity(p);
                Criteria cc = sess.createCriteria(Weight.class);
                cc.add(Restrictions.eq("weight", gg.getWeight()));
                Weightmesurement wmm = new Weightmesurement();
                wmm.setId(Integer.parseInt(gg.getWeightmesuid()));
                cc.add(Restrictions.eq("weightmesurement", wmm));
                List<Weight> lll = cc.list();
                if (lll.isEmpty()) {
                    Weight w = new Weight();
                    Weightmesurement wmmm = new Weightmesurement();
                    wmmm.setId(Integer.parseInt(gg.getWeightmesuid()));
                    w.setWeightmesurement(wmmm);
                    w.setWeight(gg.getWeight());
                    Transaction trr = sess.beginTransaction();
                    sess.save(w);
                    trr.commit();
                }
                Criteria cc1 = sess.createCriteria(Weight.class);
                cc1.add(Restrictions.eq("weight", gg.getWeight()));
                Weightmesurement wmm2 = new Weightmesurement();
                wmm2.setId(Integer.parseInt(gg.getWeightmesuid()));
                cc1.add(Restrictions.eq("weightmesurement", wmm));
                List<Weight> lll2 = cc1.list();
                phs.setWeight(lll2.get(0));
                phs.setCount(Integer.parseInt(gg.getCount()));
                Transaction tr2 = sess.beginTransaction();
                sess.save(phs);
                tr2.commit();
            }
            sess.flush();
            req.getSession().setAttribute("tbhmap", null);
            resp.getWriter().write("gg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
