<%-- 
    Document   : ViewCart
    Created on : Jun 24, 2018, 1:13:45 PM
    Author     : ASUS
--%>

<%@page import="Pojos.Img"%>
<%@page import="Pojos.CartHasProduct"%>
<%@page import="Pojos.Cart"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="Pojos.User"%>
<%@page import="Connection.NewHibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <script type="text/javascript" src="https://www.payhere.lk/lib/payhere.js"></script>
        <style>
            #filechooser{

                display: none;

            }
        </style>

    </head>
    <body>


        <div>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="height: 75px;">
                <!-- Brand -->
                <div class="col-md-2">
                    <a class="navbar-brand" href="index.jsp"><img src="Images/logo.png" style="width: 138px; height: 39px"></a>
                </div>
                <div class="col-md-8">
                    <!-- Links -->
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="ProductsAndAdvancedSearch.jsp">Products</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AboutUs.jsp">About US</a>
                        </li> 

                        <!-- Dropdown 
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                Dropdown link
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">Link 1</a>
                                <a class="dropdown-item" href="#">Link 2</a>
                                <a class="dropdown-item" href="#">Link 3</a>
                            </div>
                        </li>-->
                </div>



                <div class="col-md-1">
                    <a href="ViewCart.jsp"><img src="Images/cart.png" style="height: 30px; width: 30px;"> </a>
                    <a href="#"><img src="Images/wish.png" style="height: 25px; width: 25px;"> </a>
                </div>


                <%

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

                %>

                <div class="col-md-1">
                    <li>   
                        <label id="dLabe2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="bg-dark navbar-dark fas fa-user" style="color: #c0c0c0"></label>
                        <div class="dropdown-menu" style="left: -40%">
                            <center>
                                <img id="preview" src="<%=img%>" style="height: 50px; width: 50px; border: #000 solid 1px; border-radius: 100px; padding: 0px;">
                            </center>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Profile</a>
                            <a class="dropdown-item" href="#">My Orders</a>
                            <a class="dropdown-item" href="#" onclick="logout();">Logout</a>
                        </div></li>
                </div>

                <%
                } else {
                %>

                <div class="col-md-1">
                    <li>   
                        <label id="dLabel" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="bg-dark navbar-dark" style="color: #c0c0c0">Login</label>
                        <div class="dropdown-menu" style="left: -90%">
                            <div class="px-4 py-3">
                                <div class="form-group">
                                    <label for="exampleDropdownFormEmail1">Email address</label>
                                    <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com">
                                </div>
                                <div class="form-group">
                                    <label for="exampleDropdownFormPassword1">Password</label>
                                    <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">
                                </div>
                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" id="rembme">
                                    <label class="form-check-label" for="dropdownCheck">
                                        Remember This Device
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label label label-danger" style="color: red" id="oopzy"></label>
                                </div>
                                <button onclick="login();" class="btn btn-primary">Sign in</button>
                            </div>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#exampleModal" >New around here? Sign up</a>
                            <a class="dropdown-item" href="#"  data-toggle="modal" data-target="#exampleModal2">Forgot password?</a>
                        </div></li>
                </div>

                <%
                    }

                %>

                </ul>
            </nav>
        </div>

        <%                try {
                if (!request.getParameter("msg").equals(null)) {
        %>

        <div  id="regdone">
            <div class="alert alert-success"><button type="button" class="close" data-dismiss="alert">x</button><strong><%=request.getParameter("msg")%></strong></div>
        </div>


        <%
                }
            } catch (java.lang.NullPointerException e) {

            }

        %>




        <!-- User Reg Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">User Sign up</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="closemodal">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <center>
                            <label for="filechooser"><img id="preview" src="Images/add-user.png" style="height: 80px; width: 80px; border: #000 solid 1px; border-radius: 100px; padding: 10px;"></label>
                            <input type="file" name="img" id="filechooser" onchange="preview();">
                        </center>
                        <form>
                            <div class="form-group">
                                <label for="fname" class="col-form-label">First Name:</label>
                                <input type="text" class="form-control" id="fname">
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-form-label">Email:</label>
                                <input type="email" class="form-control" id="email">
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-form-label">Password:</label>
                                <input type="password" class="form-control" id="password">
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-form-label">Confirm Password:</label>
                                <input type="password" class="form-control" id="cpassword">
                            </div>
                            <div class="form-group">
                                <label class="col-form-label label label-danger"  style="color: red" id="oopz"></label>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="save_data();">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>




        <!-- Password Reset Modal -->
        <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel2">Reset Password</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="closemodal2">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <form>
                            <div class="form-group">
                                <label for="fname" class="col-form-label">Registered Email:</label>
                                <input type="text" class="form-control" id="resetemail">
                            </div>

                            <div class="form-group">
                                <label class="col-form-label label label-danger"  style="color: red" id="oopz2"></label>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="fogotpassword();">Reset Password</button>
                    </div>
                </div>
            </div>
        </div>






        <h1 id="aaaa"></h1>

        <%                double total = 0;

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
        %>
        <div class="container">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card bg-light" style="border: none;border-left: solid 2px;border-color:gold;">
                            <div class="card-body"><div class="row">
                                    <div class="col-md-3">
                                        <img src="Images//Product_Images//<%=im.getUrl1()%>" style="width: 150px;">
                                    </div>
                                    <div class="col-md-6">
                                        <span class="text-success font-weight-bold"><%= chp.getProduct().getId()%></span><br>
                                        <span class="text-primary font-weight-bold" style="font-size: 20px;"><%= chp.getProduct().getName()%></span><br>
                                        <span class="text-success font-weight-bold">Price $<%= chp.getProduct().getPrice()%></span><br>
                                        <span class="text-danger font-weight-bold">QTY </span><span class="text-danger font-weight-bold" id="qty<%= chp.getProduct().getId()%>"><%= chp.getQuantity()%></span><br>
                                    </div>
                                    <div class="col-md-3 bg-info">
                                        <div class="form-group bg-info">
                                            <input class="form-control mt-md-4" placeholder="count" id="<%= chp.getProduct().getId()%>">
                                            <button class="btn btn-block btn-danger mt-3" onclick="remove(<%= chp.getProduct().getId()%>);">Remove</button>

                                        </div>
                                    </div>
                                </div></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
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


        %>
        <div class="container">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card bg-light" style="border: none;border-left: solid 2px;border-color:gold;">
                            <div class="card-body"><div class="row">
                                    <div class="col-md-3">
                                        <img src="Images//Product_Images//<%=im.getUrl1()%>"style="width: 150px;">
                                    </div>
                                    <div class="col-md-6">
                                        <span class="text-success font-weight-bold"><%= chp.getProduct().getId()%></span><br>
                                        <span class="text-primary font-weight-bold" style="font-size: 20px;"><%= chp.getProduct().getName()%></span><br>
                                        <span class="text-success font-weight-bold">Price $<%= chp.getProduct().getPrice()%></span><br>
                                        <span class="text-danger font-weight-bold">QTY </span><span class="text-danger font-weight-bold" id="qty<%= chp.getProduct().getId()%>"><%= chp.getQuantity()%></span><br>
                                    </div>
                                    <div class="col-md-3 bg-info">
                                        <div class="form-group bg-info">
                                            <input class="form-control mt-md-4" type="number" placeholder="count" id="<%= chp.getProduct().getId()%>">
                                            <button class="btn btn-block btn-danger mt-3" onclick="remove(<%= chp.getProduct().getId()%>);">Remove</button>

                                        </div>
                                    </div>
                                </div></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
                }

            }
        %>



        <br><br>
        <span>Total Value :- </span> $<span id="total"><%=total%></span>
        
        <%
        
        if (a||b) {
        
        %>
        
        <button onclick="payment()">Checkout</button> 
       

<%

        }
%>



    </body>

    <script>


function payment(){
       
       var payment = {
        "sandbox": true,
        "merchant_id": "1213398",       // Replace your Merchant ID
        "return_url": "",
        "cancel_url": "",
        "notify_url": "",
        "order_id": "ItemNo12345",
        "items": "Item",
        "amount": document.getElementById("total").innerHTML,
        "currency": "LKR",
        "first_name": "",
        "last_name": "",
        "email": "",
        "phone": "",
        "address": "",
        "city": "",
        "country": "",
        "delivery_address": "",
        "delivery_city": "",
        "delivery_country": "",
        "custom_1": "",
        "custom_2": ""
    };
    
    
        payhere.startPayment(payment);
        payhere.onCompleted = function onCompleted(orderId) {
            
            var request = new XMLHttpRequest();

            request.onreadystatechange = function () {

                if (request.readyState === 4) {

                    if (request.status === 200) {

                        window.location = "invoice.jsp";
                    }
                }
            };

            request.open("POST", "purchase", true);

            request.send();
        
        //Note: validate the payment and show success or failure page to the customer
    };
   
   }



        function remove(id) {
            var request = new XMLHttpRequest();
            var iqty = document.getElementById(id).value;
            var qty;

            if (iqty === "") {
                qty = document.getElementById("qty" + id).innerHTML;
            } else {
                qty = iqty;
            }

            request.onreadystatechange = function () {
                if (request.readyState === 4 && request.status === 200) {

                    location.reload();
                    document.getElementById("aaaa").innerHTML = request.responseText;


                }
            };

            request.open("GET", "RemoveFromCart?id=" + id + "&qty=" + qty, true);
            request.send();
        }


        function checkout() {
            
            

            

        }







        function preview() {

            var file = document.getElementById("filechooser").files[0];
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (content) {
                document.getElementById("preview").src = content.target.result;
            };
        }



        function save_data() {

            var fname = document.getElementById("fname").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;
            var cpassword = document.getElementById("cpassword").value;
            var file = document.getElementById("filechooser").files[0];


            var form = new FormData();

            form.append("fname", fname);
            form.append("email", email);
            form.append("password", password);
            form.append("cpassword", cpassword);
            form.append("file", file);


            var request = new XMLHttpRequest();

            request.onreadystatechange = function () {

                if (request.readyState === 4) {

                    if (request.status === 200) {

                        if (request.responseText === "Saved") {

                            window.location = "index.jsp?msg=User Registered";

                        } else {
                            document.getElementById("oopz").innerHTML = request.responseText;
                        }
                    }
                }
            };

            request.open("POST", "user_reg", true);

            request.send(form);

        }


        function login() {
            var request = new XMLHttpRequest();


            request.onreadystatechange = function () {
                if (request.readyState === 4) {

                    if (request.status === 200) {
                        var response = request.responseText;
                        // document.getElementById(element).innerHTML = ;
                        //document.getElementById("ww").innerHTML=response;
                        if (response === "aa") {
                            window.location = "index.jsp";
                        } else if (response === "0") {
                            document.getElementById("oopzy").innerHTML = "Your Account Has Been Deactivated";
                        } else if (response === "100") {
                            document.getElementById("oopzy").innerHTML = "Password Reset In Progress Check Your Email For A Link";
                        } else {

                            document.getElementById("oopzy").innerHTML = response;

                        }
                    }
                }
            };

            var check;

            if (document.getElementById("rembme").checked) {
                check = "yep";
            } else {
                check = "nope";
            }

            request.open("POST", "login", true);
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            request.send("email=" + document.getElementById("exampleDropdownFormEmail1").value + "&" + "pw=" + document.getElementById("exampleDropdownFormPassword1").value + "&" + "rembme=" + check);
        }


        function logout() {
            var request = new XMLHttpRequest();


            request.onreadystatechange = function () {
                if (request.readyState === 4) {

                    if (request.status === 200) {
                        window.location = "index.jsp";
                    }
                }
            };

            request.open("POST", "logout", true);
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            request.send();
        }



        function fogotpassword() {
            var request = new XMLHttpRequest();


            request.onreadystatechange = function () {
                if (request.readyState === 4) {
                    if (request.status === 200) {
                        document.getElementById("oopz2").innerHTML = request.responseText;
                    }
                }
            };

            request.open("POST", "SendResetPasswordEmail", true);
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            request.send("email=" + document.getElementById("resetemail").value);
        }

    </script>



</html>
