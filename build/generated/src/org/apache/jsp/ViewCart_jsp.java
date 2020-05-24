package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Pojos.Img;
import Pojos.CartHasProduct;
import Pojos.Cart;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.hibernate.Criteria;
import java.util.ArrayList;
import java.util.Set;
import Pojos.User;
import Connection.NewHibernateUtil;

public final class ViewCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cart</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\" integrity=\"sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.13/css/all.css\" integrity=\"sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp\" crossorigin=\"anonymous\">\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"https://www.payhere.lk/lib/payhere.js\"></script>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            #filechooser{\n");
      out.write("\n");
      out.write("                display: none;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\" style=\"height: 75px;\">\n");
      out.write("                <!-- Brand -->\n");
      out.write("                <div class=\"col-md-2\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"Images/logo.png\" style=\"width: 138px; height: 39px\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <!-- Links -->\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"ProductsAndAdvancedSearch.jsp\">Products</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"AboutUs.jsp\">About US</a>\n");
      out.write("                        </li> \n");
      out.write("\n");
      out.write("                        <!-- Dropdown \n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">\n");
      out.write("                                Dropdown link\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-menu\">\n");
      out.write("                                <a class=\"dropdown-item\" href=\"#\">Link 1</a>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"#\">Link 2</a>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"#\">Link 3</a>\n");
      out.write("                            </div>\n");
      out.write("                        </li>-->\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"col-md-1\">\n");
      out.write("                    <a href=\"ViewCart.jsp\"><img src=\"Images/cart.png\" style=\"height: 30px; width: 30px;\"> </a>\n");
      out.write("                    <a href=\"Watchlist.jsp\"><img src=\"Images/wish.png\" style=\"height: 25px; width: 25px;\"> </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                ");


                    boolean a = false;
                    boolean b = false;

                    Cookie c_list[] = request.getCookies();
                    String un = null;
                    String pw = null;
                    for (int i = 0; c_list.length > i; i++) {

                        if (c_list[i].getName().equals("em")) {
                            un = c_list[i].getValue();
                        }
                        if (c_list[i].getName().equals("pw")) {
                            pw = c_list[i].getValue();
                        }

                    }

                    if (un != null && pw != null) {

                        try {

                            Session s = NewHibernateUtil.getSessionFactory().openSession();
                            User l = (User) s.load(User.class, un);

                            if (l != null) {

                                if (l.getPassword().equals(pw)) {
                                    a = true;
                                    HttpSession ses = request.getSession();
                                    ses.setAttribute("user", l);
                                } else {
                                    a = false;
                                }
                            } else {
                                a = false;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            a = false;
                        }

                    }

                    if (request.getSession().getAttribute("user") != null) {
                        b = true;
                    }

                    if (a || b) {
                        User u = (User) request.getSession().getAttribute("user");

                        Cookie c = new Cookie("em", u.getEmail());
                        c.setMaxAge(2592000);
                        response.addCookie(c);

                        Cookie c2 = new Cookie("pw", u.getPassword());
                        c2.setMaxAge(2592000);
                        response.addCookie(c2);

                        String img;
                        if (u.getImg() == null) {
                            img = "Images/add-user.png";
                        } else {
                            img = "User_Images/" + u.getImg();
                        }

                
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"col-md-1\">\n");
      out.write("                    <li>   \n");
      out.write("                        <label id=\"dLabe2\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" class=\"bg-dark navbar-dark fas fa-user\" style=\"color: #c0c0c0\"></label>\n");
      out.write("                        <div class=\"dropdown-menu\" style=\"left: -40%\">\n");
      out.write("                            <center>\n");
      out.write("                                <img id=\"preview\" src=\"");
      out.print(img);
      out.write("\" style=\"height: 50px; width: 50px; border: #000 solid 1px; border-radius: 100px; padding: 0px;\">\n");
      out.write("                            </center>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Profile</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">My Orders</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\" onclick=\"logout();\">Logout</a>\n");
      out.write("                        </div></li>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                ");

                } else {
                
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"col-md-1\">\n");
      out.write("                    <li>   \n");
      out.write("                        <label id=\"dLabel\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" class=\"bg-dark navbar-dark\" style=\"color: #c0c0c0\">Login</label>\n");
      out.write("                        <div class=\"dropdown-menu\" style=\"left: -90%\">\n");
      out.write("                            <div class=\"px-4 py-3\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"exampleDropdownFormEmail1\">Email address</label>\n");
      out.write("                                    <input type=\"email\" class=\"form-control\" id=\"exampleDropdownFormEmail1\" placeholder=\"email@example.com\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"exampleDropdownFormPassword1\">Password</label>\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" id=\"exampleDropdownFormPassword1\" placeholder=\"Password\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-check\">\n");
      out.write("                                    <input type=\"checkbox\" class=\"form-check-input\" id=\"rembme\">\n");
      out.write("                                    <label class=\"form-check-label\" for=\"dropdownCheck\">\n");
      out.write("                                        Remember This Device\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"col-form-label label label-danger\" style=\"color: red\" id=\"oopzy\"></label>\n");
      out.write("                                </div>\n");
      out.write("                                <button onclick=\"login();\" class=\"btn btn-primary\">Sign in</button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#exampleModal\" >New around here? Sign up</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\"  data-toggle=\"modal\" data-target=\"#exampleModal2\">Forgot password?</a>\n");
      out.write("                        </div></li>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                ");

                    }

                
      out.write("\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
                try {
                if (!request.getParameter("msg").equals(null)) {
        
      out.write("\n");
      out.write("\n");
      out.write("        <div  id=\"regdone\">\n");
      out.write("            <div class=\"alert alert-success\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\">x</button><strong>");
      out.print(request.getParameter("msg"));
      out.write("</strong></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

                }
            } catch (java.lang.NullPointerException e) {

            }

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- User Reg Modal -->\n");
      out.write("        <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">User Sign up</h5>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\" id=\"closemodal\">\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <center>\n");
      out.write("                            <label for=\"filechooser\"><img id=\"preview\" src=\"Images/add-user.png\" style=\"height: 80px; width: 80px; border: #000 solid 1px; border-radius: 100px; padding: 10px;\"></label>\n");
      out.write("                            <input type=\"file\" name=\"img\" id=\"filechooser\" onchange=\"preview();\">\n");
      out.write("                        </center>\n");
      out.write("                        <form>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"fname\" class=\"col-form-label\">First Name:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"fname\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"email\" class=\"col-form-label\">Email:</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" id=\"email\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"password\" class=\"col-form-label\">Password:</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"password\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"password\" class=\"col-form-label\">Confirm Password:</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"cpassword\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"col-form-label label label-danger\"  style=\"color: red\" id=\"oopz\"></label>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"save_data();\">Sign Up</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Password Reset Modal -->\n");
      out.write("        <div class=\"modal fade\" id=\"exampleModal2\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel2\">Reset Password</h5>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\" id=\"closemodal2\">\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("\n");
      out.write("                        <form>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"fname\" class=\"col-form-label\">Registered Email:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"resetemail\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"col-form-label label label-danger\"  style=\"color: red\" id=\"oopz2\"></label>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"fogotpassword();\">Reset Password</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <h1 id=\"aaaa\"></h1>\n");
      out.write("\n");
      out.write("        ");
                double total = 0;

            if (request.getSession().getAttribute("user") != null) {
                User u = (User) request.getSession().getAttribute("user");

                if (u.getCarts().isEmpty()) {

                } else {
                    // have cart
                    Session s = NewHibernateUtil.getSessionFactory().openSession();

                    Criteria cc = s.createCriteria(Cart.class);
                    cc.add(Restrictions.eq("user", u));
                    Cart c = (Cart) cc.uniqueResult();
                    Set<CartHasProduct> chp_set = c.getCartHasProducts();

                    for (CartHasProduct chp : chp_set) {

                        Criteria ccc = s.createCriteria(Img.class);
                        ccc.add(Restrictions.eq("product", chp.getProduct()));
                        Img im = (Img) ccc.uniqueResult();

                        total += chp.getProduct().getPrice() * chp.getQuantity();
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div class=\"card bg-light\" style=\"border: none;border-left: solid 2px;border-color:gold; background-color: #ccccff\">\n");
      out.write("                            <div class=\"card-body\"><div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-3\">\n");
      out.write("                                        <img src=\"Images//Product_Images//");
      out.print(im.getUrl1());
      out.write("\" style=\"width: 150px;\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <span class=\"text-success font-weight-bold\">");
      out.print( chp.getProduct().getId());
      out.write("</span><br>\n");
      out.write("                                        <span class=\"text-primary font-weight-bold\" style=\"font-size: 20px;\">");
      out.print( chp.getProduct().getName());
      out.write("</span><br>\n");
      out.write("                                        <span class=\"text-success font-weight-bold\">Price $");
      out.print( chp.getProduct().getPrice());
      out.write("</span><br>\n");
      out.write("                                        <span class=\"text-danger font-weight-bold\">QTY </span><span class=\"text-danger font-weight-bold\" id=\"qty");
      out.print( chp.getProduct().getId());
      out.write('"');
      out.write('>');
      out.print( chp.getQuantity());
      out.write("</span><br>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-3 bg-info\">\n");
      out.write("                                        <div class=\"form-group bg-info\">\n");
      out.write("                                            <input class=\"form-control mt-md-4\" placeholder=\"count\" id=\"");
      out.print( chp.getProduct().getId());
      out.write("\">\n");
      out.write("                                            <button class=\"btn btn-block btn-danger mt-3\" onclick=\"remove(");
      out.print( chp.getProduct().getId());
      out.write(");\">Remove</button>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

                }
            }
        } else {

            ArrayList<CartHasProduct> chp_set = (ArrayList<CartHasProduct>) request.getSession().getAttribute("cart_has_products");

            for (CartHasProduct chp : chp_set) {
                total += chp.getProduct().getPrice() * chp.getQuantity();

                Session s = NewHibernateUtil.getSessionFactory().openSession();
                Criteria ccc = s.createCriteria(Img.class);
                ccc.add(Restrictions.eq("product", chp.getProduct()));
                Img im = (Img) ccc.uniqueResult();


        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div class=\"card bg-light\" style=\"border: none;border-left: solid 2px;border-color:gold;\">\n");
      out.write("                            <div class=\"card-body\"><div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-3\">\n");
      out.write("                                        <img src=\"Images//Product_Images//");
      out.print(im.getUrl1());
      out.write("\"style=\"width: 150px;\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <span class=\"text-success font-weight-bold\">");
      out.print( chp.getProduct().getId());
      out.write("</span><br>\n");
      out.write("                                        <span class=\"text-primary font-weight-bold\" style=\"font-size: 20px;\">");
      out.print( chp.getProduct().getName());
      out.write("</span><br>\n");
      out.write("                                        <span class=\"text-success font-weight-bold\">Price $");
      out.print( chp.getProduct().getPrice());
      out.write("</span><br>\n");
      out.write("                                        <span class=\"text-danger font-weight-bold\">QTY </span><span class=\"text-danger font-weight-bold\" id=\"qty");
      out.print( chp.getProduct().getId());
      out.write('"');
      out.write('>');
      out.print( chp.getQuantity());
      out.write("</span><br>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-3 bg-info\">\n");
      out.write("                                        <div class=\"form-group bg-info\">\n");
      out.write("                                            <input class=\"form-control mt-md-4\" type=\"number\" placeholder=\"count\" id=\"");
      out.print( chp.getProduct().getId());
      out.write("\">\n");
      out.write("                                            <button class=\"btn btn-block btn-danger mt-3\" onclick=\"remove(");
      out.print( chp.getProduct().getId());
      out.write(");\">Remove</button>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

                }

            }
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("        <div class=\"col-md-3\"></div>\n");
      out.write("        <div class=\"col-md-9\">\n");
      out.write("            <span>Total Value :- </span> $<span id=\"total\">");
      out.print(total);
      out.write("</span>\n");
      out.write("        <<button type=\"submit\" id=\"payhere-payment\" >PayHere Pay</button>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        function remove(id) {\n");
      out.write("            var request = new XMLHttpRequest();\n");
      out.write("            var iqty = document.getElementById(id).value;\n");
      out.write("            var qty;\n");
      out.write("\n");
      out.write("            if (iqty === \"\") {\n");
      out.write("                qty = document.getElementById(\"qty\" + id).innerHTML;\n");
      out.write("            } else {\n");
      out.write("                qty = iqty;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            request.onreadystatechange = function () {\n");
      out.write("                if (request.readyState === 4 && request.status === 200) {\n");
      out.write("\n");
      out.write("                    location.reload();\n");
      out.write("                    document.getElementById(\"aaaa\").innerHTML = request.responseText;\n");
      out.write("\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            request.open(\"GET\", \"RemoveFromCart?id=\" + id + \"&qty=\" + qty, true);\n");
      out.write("            request.send();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("        function checkout() {\n");
      out.write("\n");
      out.write("            var request = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("\n");
      out.write("            request.onreadystatechange = function () {\n");
      out.write("                if (request.readyState === 4 && request.status === 200) {\n");
      out.write("\n");
      out.write("                    if (request.responseText === \"gg\") {\n");
      out.write("                        window.location = \"index.jsp\";\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            request.open(\"GET\", \"Purchase?uu=viewcart.jsp\", true);\n");
      out.write("            request.send();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        function preview() {\n");
      out.write("\n");
      out.write("            var file = document.getElementById(\"filechooser\").files[0];\n");
      out.write("            var reader = new FileReader();\n");
      out.write("            reader.readAsDataURL(file);\n");
      out.write("            reader.onload = function (content) {\n");
      out.write("                document.getElementById(\"preview\").src = content.target.result;\n");
      out.write("            };\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        function save_data() {\n");
      out.write("\n");
      out.write("            var fname = document.getElementById(\"fname\").value;\n");
      out.write("            var email = document.getElementById(\"email\").value;\n");
      out.write("            var password = document.getElementById(\"password\").value;\n");
      out.write("            var cpassword = document.getElementById(\"cpassword\").value;\n");
      out.write("            var file = document.getElementById(\"filechooser\").files[0];\n");
      out.write("\n");
      out.write("\n");
      out.write("            var form = new FormData();\n");
      out.write("\n");
      out.write("            form.append(\"fname\", fname);\n");
      out.write("            form.append(\"email\", email);\n");
      out.write("            form.append(\"password\", password);\n");
      out.write("            form.append(\"cpassword\", cpassword);\n");
      out.write("            form.append(\"file\", file);\n");
      out.write("\n");
      out.write("\n");
      out.write("            var request = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("            request.onreadystatechange = function () {\n");
      out.write("\n");
      out.write("                if (request.readyState === 4) {\n");
      out.write("\n");
      out.write("                    if (request.status === 200) {\n");
      out.write("\n");
      out.write("                        if (request.responseText === \"Saved\") {\n");
      out.write("\n");
      out.write("                            window.location = \"index.jsp?msg=User Registered\";\n");
      out.write("\n");
      out.write("                        } else {\n");
      out.write("                            document.getElementById(\"oopz\").innerHTML = request.responseText;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            request.open(\"POST\", \"user_reg\", true);\n");
      out.write("\n");
      out.write("            request.send(form);\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("        function login() {\n");
      out.write("            var request = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("\n");
      out.write("            request.onreadystatechange = function () {\n");
      out.write("                if (request.readyState === 4) {\n");
      out.write("\n");
      out.write("                    if (request.status === 200) {\n");
      out.write("                        var response = request.responseText;\n");
      out.write("                        // document.getElementById(element).innerHTML = ;\n");
      out.write("                        //document.getElementById(\"ww\").innerHTML=response;\n");
      out.write("                        if (response === \"aa\") {\n");
      out.write("                            window.location = \"index.jsp\";\n");
      out.write("                        } else if (response === \"0\") {\n");
      out.write("                            document.getElementById(\"oopzy\").innerHTML = \"Your Account Has Been Deactivated\";\n");
      out.write("                        } else if (response === \"100\") {\n");
      out.write("                            document.getElementById(\"oopzy\").innerHTML = \"Password Reset In Progress Check Your Email For A Link\";\n");
      out.write("                        } else {\n");
      out.write("\n");
      out.write("                            document.getElementById(\"oopzy\").innerHTML = response;\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            var check;\n");
      out.write("\n");
      out.write("            if (document.getElementById(\"rembme\").checked) {\n");
      out.write("                check = \"yep\";\n");
      out.write("            } else {\n");
      out.write("                check = \"nope\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            request.open(\"POST\", \"login\", true);\n");
      out.write("            request.setRequestHeader(\"Content-Type\", \"application/x-www-form-urlencoded\");\n");
      out.write("            request.send(\"email=\" + document.getElementById(\"exampleDropdownFormEmail1\").value + \"&\" + \"pw=\" + document.getElementById(\"exampleDropdownFormPassword1\").value + \"&\" + \"rembme=\" + check);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("        function logout() {\n");
      out.write("            var request = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("\n");
      out.write("            request.onreadystatechange = function () {\n");
      out.write("                if (request.readyState === 4) {\n");
      out.write("\n");
      out.write("                    if (request.status === 200) {\n");
      out.write("                        window.location = \"index.jsp\";\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            request.open(\"POST\", \"logout\", true);\n");
      out.write("            request.setRequestHeader(\"Content-Type\", \"application/x-www-form-urlencoded\");\n");
      out.write("            request.send();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        function fogotpassword() {\n");
      out.write("            var request = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("\n");
      out.write("            request.onreadystatechange = function () {\n");
      out.write("                if (request.readyState === 4) {\n");
      out.write("                    if (request.status === 200) {\n");
      out.write("                        document.getElementById(\"oopz2\").innerHTML = request.responseText;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            request.open(\"POST\", \"SendResetPasswordEmail\", true);\n");
      out.write("            request.setRequestHeader(\"Content-Type\", \"application/x-www-form-urlencoded\");\n");
      out.write("            request.send(\"email=\" + document.getElementById(\"resetemail\").value);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
