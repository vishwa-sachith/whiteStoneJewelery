<%-- 
    Document   : index
    Created on : May 3, 2018, 12:56:16 PM
    Author     : ASUS
--%>

<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="Connection.NewHibernateUtil"%>
<%@page import="Pojos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <link rel="stylesheet" href="css/imageslider.css">
        <link rel="stylesheet" href="css/paragraph.css">
        
        <style>
            #filechooser{

                display: none;

            }
        </style>

    </head>
    <body background="http://balasoremarket.com/Jewellery/Anand-Jewellers-Motiganaj-Balasore/images/background.jpg" >
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
                            <%
                                if (u.getUserType().getType().equals("Admin")) {
                            %>
                            <a class="dropdown-item" href="Adminpnl.jsp">Admin Panel</a>
                            <a class="dropdown-item" href="ProductRegistration.jsp">Add Product</a>
                            <%
                            } else {
                            %>
                            <a class="dropdown-item" href="#">My Orders</a>
                            <a class="dropdown-item" href="ViewCart.jsp">Cart</a>
                            <a class="dropdown-item" href="Watchlist.jsp">Watch List</a>
                            <%
                                }
                            %>
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


        <!-- Body -->


        <div class='csslider1 autoplay '>
            <input name="cs_anchor1" id='cs_slide1_0' type="radio" class='cs_anchor slide' >
            <input name="cs_anchor1" id='cs_slide1_1' type="radio" class='cs_anchor slide' >
            <input name="cs_anchor1" id='cs_slide1_2' type="radio" class='cs_anchor slide' >
            <input name="cs_anchor1" id='cs_play1' type="radio" class='cs_anchor' checked>
            <input name="cs_anchor1" id='cs_pause1' type="radio" class='cs_anchor' >
            <ul>
                <div style="width: 100%; visibility: hidden; font-size: 0px; line-height: 0;">
                    <img src="Images/slider/diamond-slider.jpg" style="width: 100%;">
                </div>
                <li class='num0 img'>
                    <a href="#" target=""><img src='Images/slider/gold.jpg' alt='Gold' title='Gold' /> </a>
                </li>
                <li class='num1 img'>
                    <a href="#" target=""><img src='Images/slider/pearl.jpg' alt='Pearls' title='Pearls' /> </a> 
                </li>
                <li class='num2 img'>

                    <a href="#" target=""><img src='Images/slider/diamond-slider.jpg' alt='Diamond Rings' title='Diamond Rings' /> </a> 
                </li>

            </ul>
            <div class='cs_description'>
                <label class='num0'>
                    <span class="cs_title"><span class="cs_wrapper">Gold</span></span>
                </label>
                <label class='num1'>
                    <span class="cs_title"><span class="cs_wrapper">Pearls</span></span>
                </label>
                <label class='num2'>
                    <span class="cs_title"><span class="cs_wrapper">Diamond Rings</span></span>
                </label>
            </div>

            <div class='cs_arrowprev'>
                <label class='num0' for='cs_slide1_0'></label>
                <label class='num1' for='cs_slide1_1'></label>
                <label class='num2' for='cs_slide1_2'></label>
            </div>
            <div class='cs_arrownext'>
                <label class='num0' for='cs_slide1_0'></label>
                <label class='num1' for='cs_slide1_1'></label>
                <label class='num2' for='cs_slide1_2'></label>
            </div>

            <div class='cs_bullets'>
                <label class='num0' for='cs_slide1_0'>
                    <span class='cs_point'></span>
                    <span class='cs_thumb'><img src='Images/slider/gold-mini.jpg' alt='Gold' title='Gold' /></span>
                </label>
                <label class='num1' for='cs_slide1_1'>
                    <span class='cs_point'></span>
                    <span class='cs_thumb'><img src='Images/slider/pearl-mini.jpg' alt='Pearls' title='Pearls' /></span>
                </label>
                <label class='num2' for='cs_slide1_2'>
                    <span class='cs_point'></span>
                    <span class='cs_thumb'><img src='Images/slider/diamond-mini.jpg' alt='Diamond Rings' title='Diamond Rings' /></span>
                </label>
            </div>
        </div>

        <br /><br />

        <div class="row">

            <div class="col-lg-10 col-lg-push-1 clearfix">
                <div class="img-space"><img src="https://www.rajajewellers.com/wp-content/uploads/2018/05/raja1.png" alt="Beautifully Crafted Wedding Ring from Stone Jewellers"></div>
                <div class="seo-text text-justify">
                    <div class="seo-text-wrapper">
                        <span class="free-text"></span>
                        <h1 class="text-center">Monarch of the Jewellery World</h1>
                        <p>Through passionately observed processes and using the finest materials, we create exquisite jewellery in Sri Lanka. Our reputation is a result of our commitment to providing customers superior gems &amp; jewellery, masterfully crafted by our skilled team.</p>
                    </div>
                    <!-- 				<code>Share popup</code>
                                                    <div id="share-us">
                                                            <a href="#" data-toggle="modal" data-target="#eme-share">share</a>
                                                    </div> -->
                </div>
            </div>
        </div>


        <div style="height: 200px"></div>
    </body>

    <script>
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
