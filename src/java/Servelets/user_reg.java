/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets;

import Pojos.Product;
import Pojos.User;
import Pojos.UserType;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ASUS
 */
public class user_reg extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User u = new User();
            String pass = null;
            String cpass = null;
            String res = null;
            boolean isit;
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload files = new ServletFileUpload(factory);
            List<FileItem> items = files.parseRequest(request);
            for (FileItem fileitem : items) {
                if (fileitem.isFormField()) {
                    if (fileitem.getFieldName().equals("fname")) {
                        if ("".equals(fileitem.getString())) {
                            res = "Fill All The Fields";
                            isit = false;
                        } else {
                            u.setFname(fileitem.getString());
                            isit = true;
                        }
                    } else if (fileitem.getFieldName().equals("email")) {
                        if ("".equals(fileitem.getString())) {
                            res = "Fill All The Fields";
                            isit = false;
                        } else {
                            u.setEmail(fileitem.getString());
                            isit = true;
                        }
                    } else if (fileitem.getFieldName().equals("password")) {
                        if ("".equals(fileitem.getString())) {
                            res = "Fill All The Fields";
                            isit = false;
                        } else {
                            pass = fileitem.getString();
                            isit = true;
                        }
                    } else if (fileitem.getFieldName().equals("cpassword")) {
                        if ("".equals(fileitem.getString())) {
                            res = "Fill All The Fields";
                            isit = false;
                        } else {
                            cpass = fileitem.getString();
                            isit = true;
                        }
                    }

                } else {
                    String actualpath = request.getServletContext().getRealPath("/");
                    String name = new SimpleDateFormat("yyyy_MM_dd").format(new Date()) + "_" + new SimpleDateFormat("HH_mm_ss").format(new Date()) + "_" + System.currentTimeMillis() + ".jpg";
                    String folder = "User_Images\\";
                    u.setImg(name);
                    String path = actualpath + folder + name;
                    System.out.println(path);
                    File f = new File(path);
                    fileitem.write(f);
                }
            }
            if (pass == null && cpass == null) {
                res = "Fill All The Fields";
                isit = false;
            } else {
                if (pass.equals(cpass)) {
                    u.setPassword(pass);
                    isit = true;
                } else {
                    res = "Password Don't Match";
                    isit = false;
                }
            }
            if (isit) {
                UserType ut = new UserType();
                ut.setIdUserType(2);
                u.setUserType(ut);
                u.setStatus("1");
                Session sess = Connection.NewHibernateUtil.getSessionFactory().openSession();
                Transaction tr = sess.beginTransaction();
                sess.save(u);
                tr.commit();
                res = "Saved";
            } else {
            }
            response.getWriter().write(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
