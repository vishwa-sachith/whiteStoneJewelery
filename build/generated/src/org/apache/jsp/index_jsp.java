package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;
import Connection.NewHibernateUtil;
import Pojos.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\" integrity=\"sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.13/css/all.css\" integrity=\"sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/imageslider.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/paragraph.css\">\n");
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
      out.write("    <body background=\"http://balasoremarket.com/Jewellery/Anand-Jewellers-Motiganaj-Balasore/images/background.jpg\" >\n");
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
      out.write("                        \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-md-1\">\n");
      out.write("                    <a href=\"ViewCart.jsp\"><img src=\"Images/cart.png\" style=\"height: 30px; width: 30px;\"> </a>\n");
      out.write("                    <a href=\"#\"><img src=\"Images/wish.png\" style=\"height: 25px; width: 25px;\"> </a>\n");
      out.write("                </div>\n");
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
      out.write("                            ");

                                if (u.getUserType().getType().equals("Admin")) {
                            
      out.write("\n");
      out.write("                            <a class=\"dropdown-item\" href=\"Adminpnl.jsp\">Admin Panel</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"ProductRegistration.jsp\">Add Product</a>\n");
      out.write("                            ");

                            } else {
                            
      out.write("\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">My Orders</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"ViewCart.jsp\">Cart</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"Watchlist.jsp\">Watch List</a>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
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
      out.write("        <!-- Body -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class='csslider1 autoplay '>\n");
      out.write("            <input name=\"cs_anchor1\" id='cs_slide1_0' type=\"radio\" class='cs_anchor slide' >\n");
      out.write("            <input name=\"cs_anchor1\" id='cs_slide1_1' type=\"radio\" class='cs_anchor slide' >\n");
      out.write("            <input name=\"cs_anchor1\" id='cs_slide1_2' type=\"radio\" class='cs_anchor slide' >\n");
      out.write("            <input name=\"cs_anchor1\" id='cs_play1' type=\"radio\" class='cs_anchor' checked>\n");
      out.write("            <input name=\"cs_anchor1\" id='cs_pause1' type=\"radio\" class='cs_anchor' >\n");
      out.write("            <ul>\n");
      out.write("                <div style=\"width: 100%; visibility: hidden; font-size: 0px; line-height: 0;\">\n");
      out.write("                    <img src=\"Images/slider/diamond-slider.jpg\" style=\"width: 100%;\">\n");
      out.write("                </div>\n");
      out.write("                <li class='num0 img'>\n");
      out.write("                    <a href=\"#\" target=\"\"><img src='Images/slider/gold.jpg' alt='Gold' title='Gold' /> </a>\n");
      out.write("                </li>\n");
      out.write("                <li class='num1 img'>\n");
      out.write("                    <a href=\"#\" target=\"\"><img src='Images/slider/pearl.jpg' alt='Pearls' title='Pearls' /> </a> \n");
      out.write("                </li>\n");
      out.write("                <li class='num2 img'>\n");
      out.write("\n");
      out.write("                    <a href=\"#\" target=\"\"><img src='Images/slider/diamond-slider.jpg' alt='Diamond Rings' title='Diamond Rings' /> </a> \n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("            <div class='cs_description'>\n");
      out.write("                <label class='num0'>\n");
      out.write("                    <span class=\"cs_title\"><span class=\"cs_wrapper\">Gold</span></span>\n");
      out.write("                </label>\n");
      out.write("                <label class='num1'>\n");
      out.write("                    <span class=\"cs_title\"><span class=\"cs_wrapper\">Pearls</span></span>\n");
      out.write("                </label>\n");
      out.write("                <label class='num2'>\n");
      out.write("                    <span class=\"cs_title\"><span class=\"cs_wrapper\">Diamond Rings</span></span>\n");
      out.write("                </label>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class='cs_arrowprev'>\n");
      out.write("                <label class='num0' for='cs_slide1_0'></label>\n");
      out.write("                <label class='num1' for='cs_slide1_1'></label>\n");
      out.write("                <label class='num2' for='cs_slide1_2'></label>\n");
      out.write("            </div>\n");
      out.write("            <div class='cs_arrownext'>\n");
      out.write("                <label class='num0' for='cs_slide1_0'></label>\n");
      out.write("                <label class='num1' for='cs_slide1_1'></label>\n");
      out.write("                <label class='num2' for='cs_slide1_2'></label>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class='cs_bullets'>\n");
      out.write("                <label class='num0' for='cs_slide1_0'>\n");
      out.write("                    <span class='cs_point'></span>\n");
      out.write("                    <span class='cs_thumb'><img src='Images/slider/gold-mini.jpg' alt='Gold' title='Gold' /></span>\n");
      out.write("                </label>\n");
      out.write("                <label class='num1' for='cs_slide1_1'>\n");
      out.write("                    <span class='cs_point'></span>\n");
      out.write("                    <span class='cs_thumb'><img src='Images/slider/pearl-mini.jpg' alt='Pearls' title='Pearls' /></span>\n");
      out.write("                </label>\n");
      out.write("                <label class='num2' for='cs_slide1_2'>\n");
      out.write("                    <span class='cs_point'></span>\n");
      out.write("                    <span class='cs_thumb'><img src='Images/slider/diamond-mini.jpg' alt='Diamond Rings' title='Diamond Rings' /></span>\n");
      out.write("                </label>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <br /><br />\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("\n");
      out.write("            <div class=\"col-lg-10 col-lg-push-1 clearfix\">\n");
      out.write("                <div class=\"img-space\"><img src=\"https://www.rajajewellers.com/wp-content/uploads/2018/05/raja1.png\" alt=\"Beautifully Crafted Wedding Ring from Stone Jewellers\"></div>\n");
      out.write("                <div class=\"seo-text text-justify\">\n");
      out.write("                    <div class=\"seo-text-wrapper\">\n");
      out.write("                        <span class=\"free-text\"></span>\n");
      out.write("                        <h1 class=\"text-center\">Monarch of the Jewellery World</h1>\n");
      out.write("                        <p>Through passionately observed processes and using the finest materials, we create exquisite jewellery in Sri Lanka. Our reputation is a result of our commitment to providing customers superior gems &amp; jewellery, masterfully crafted by our skilled team.</p>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- \t\t\t\t<code>Share popup</code>\n");
      out.write("                                                    <div id=\"share-us\">\n");
      out.write("                                                            <a href=\"#\" data-toggle=\"modal\" data-target=\"#eme-share\">share</a>\n");
      out.write("                                                    </div> -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div style=\"height: 200px\"></div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    <script>\n");
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
