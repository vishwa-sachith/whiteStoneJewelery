<%-- 
    Document   : AboutUs
    Created on : Nov 17, 2019, 10:55:48 PM
    Author     : ASUS
--%>

<%@page import="Pojos.User"%>
<%@page import="Connection.NewHibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About US</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <link rel="stylesheet" href="css/imageslider.css">
        <link rel="stylesheet" href="css/paragraph.css">
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

                        
                </div>

                <div class="col-md-1">
                    <a href="ViewCart.jsp"><img src="Images/cart.png" style="height: 30px; width: 30px;"> </a>
                    <a href="Watchlist.jsp"><img src="Images/wish.png" style="height: 25px; width: 25px;"> </a>
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

        <section id="about">
            <div class="container">

                <header class="section-header text-center mb-5 pb-2">
                    <h3>About Us</h3>
                    <p>We are WhiteStone Jewelles! A team of designers, developers and crafters. Since 1950, WhiteStone Jewellers has made it their mission to strive every day to earn the confidence and trust of our clients by meeting and exceeding their expectations of quality, service, and unsurpassed value. We ensure our actions are consistent with our Corporate Values, enabling us to maintain the relationships and reputation, which our family – owned firm has developed throughout our history.

                        The foundation of a family business, and the basis on which our company has grown; an emphasis on personalization and strong ties to our clients, industry, and communities, WhiteStone Jeweller’s provides our clients with more than they imagined for less than they anticipate. We offer the finest items – well manufactured, well designed, properly represented by a knowledgeable staff, and beautifully wrapped – regardless the budget.

                        We will continually enhance the value of the Taylor Brand by being foremost in the minds of people looking to commemorate life’s events, and providing an exceptional experience for our clients, associates, and communities in order to build long term relationships.

                        We’re ready. When you’re ready. 

                    <div class="row about-cols">

                        <div class="col-md-4 wow fadeInUp">
                            <div class="about-col">
                                <div class="img">
                                    <img src="img/about-mission.webp" alt="" class="img-fluid">
                                    <div class="icon"><i class="ion-ios-speedometer-outline"></i></div>
                                </div>
                                <h2 class="title"><a href="#">Our Mission</a></h2>
                                <p class="text-center">
                                    To utilize the power of technology in setting and reaching goals...
                                </p>
                            </div>
                        </div>

                        <div class="col-md-4 wow fadeInUp" data-wow-delay="0.1s">
                            <div class="about-col">
                                <div class="img">
                                    <img src="img/about-plan.webp" alt="" class="img-fluid">
                                    <div class="icon"><i class="ion-ios-list-outline"></i></div>
                                </div>
                                <h2 class="title"><a href="#">Our Plan</a></h2>
                                <p class="text-center">
                                    We Plan to bring you the best thing.
                                </p>
                            </div>
                        </div>


                        <div class="col-md-4 wow fadeInUp" data-wow-delay="0.2s">
                            <div class="about-col">
                                <div class="img">
                                    <img src="img/about-vision.webp" alt="" class="img-fluid">
                                    <div class="icon"><i class="ion-ios-eye-outline"></i></div>
                                </div>
                                <h2 class="title"><a href="#">Our Vision</a></h2>
                                <p class="text-center">
                                    Make your special day more special.               
                                </p>
                            </div>
                        </div>

                    </div>

            </div>
        </section><!-- #about -->

        <!--==========================
          Call To Action Section
        ============================-->
        <section id="call-to-action" class="wow fadeIn">
            <div class="container text-center">
                <h3>Having Problems keeping track on your goals?</h3>
                <p class="text-center">
                    With Iris Goal Tracker you can set and track your goals, track time, manage task, and lots more.      </p>
                <a class="cta-btn" href="#">Get Started</a>
            </div>
        </section><!-- #call-to-action -->



    </body>

    <style>
        #about {

            padding: 60px 0 40px 0;
            position: relative;
        }

        #about::before {
            content: '';
            position: absolute;
            left: 0;
            right: 0;
            top: 0;
            bottom: 0;
            background: lightgrey;
            z-index: 9;
        }

        #about .container {
            position: relative;
            z-index: 10;
        }

        #about .about-col {
            background: #fff;
            border-radius: 0 0 4px 4px;
            box-shadow: 0px 2px 12px rgba(0, 0, 0, 0.08);
            margin-bottom: 20px;
        }

        #about .about-col .img {
            position: relative;
        }

        #about .about-col .img img {
            border-radius: 4px 4px 0 0;
        }

        #about .about-col .icon {
            width: 64px;
            height: 64px;
            padding-top: 8px;
            text-align: center;
            position: absolute;
            background-color: #3C5A99;
            border-radius: 50%;
            text-align: center;
            border: 4px solid #fff;
            left: calc( 50% - 32px);
            bottom: -30px;
            transition: 0.3s;
        }

        #about .about-col i {
            font-size: 36px;
            line-height: 1;
            color: #fff;
            transition: 0.3s;
        }

        #about .about-col:hover .icon {
            background-color: #fff;
        }

        #about .about-col:hover i {
            color: #3C5A99;
        }

        #about .about-col h2 {
            color: #000;
            text-align: center;
            font-weight: 700;
            font-size: 20px;
            padding: 0;
            margin: 40px 0 12px 0;
        }

        #about .about-col h2 a {
            color: #000;
        }

        #about .about-col h2 a:hover {
            color: #3C5A99;
        }

        #about .about-col p {
            font-size: 14px;
            line-height: 24px;
            color: #333;
            margin-bottom: 0;
            padding: 0 20px 20px 20px;
        }


        #call-to-action {
            background: linear-gradient(rgba(21, 86, 112, 0.1), rgba(0, 0, 0, 0.1)), url(../img/call-to-action\ image.webp) fixed center center;
            background-size: cover;
            padding: 60px 0;
        }

        #call-to-action h3 {
            color: black;
            font-size: 28px;
            font-weight: 700;
        }

        #call-to-action p {
            color: black;
        }

        #call-to-action .cta-btn {
            font-family: "Montserrat", sans-serif;
            text-transform: uppercase;
            font-weight: 500;
            font-size: 16px;
            letter-spacing: 1px;
            display: inline-block;
            padding: 8px 28px;
            border-radius: 25px;
            transition: 0.5s;
            margin-top: 10px;
            border: 2px solid #000;
            color: #000;
        }
        #call-to-action .cta-btn:hover {
            background: #3C5A99;
            border: 2px solid #3C5A99;
        }
    </style>

</html>
