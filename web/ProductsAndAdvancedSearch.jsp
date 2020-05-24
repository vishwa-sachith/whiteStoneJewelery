<%-- 
    Document   : ProductsAndAdvancedSearch
    Created on : Jun 11, 2018, 11:46:27 AM
    Author     : ASUS
--%>

<%@page import="org.hibernate.Session"%>
<%@page import="Connection.NewHibernateUtil"%>
<%@page import="Pojos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
        <style>
            body {
            font-family: "Open Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Helvetica, Arial, sans-serif; 
        }
            .view{
                font-family: Candra;
                font-size: 18px;
                border-style: outset;
                width: 930px;
                padding: 10px;

            }

            .txtpara{
                word-break: break-all;
            }

            .stbtn{
                margin-left: 2px;
                margin-right: 2px;
                margin-top: 2px;
                margin-bottom: 2px;
            }

            .txt{
                width: 70px;
            }

            #filechooser{

                display: none;

            }

            .text1{
                font-size: 0.8rem;
            }

        </style>
    </head>
    <body onload="m(0)" style="background-color: #D0D5DB">


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





        <!-- Actual Page -->





    <center><h2>Products</h2></center>
    <br>
    <ul style="display: block">
        <center><li style="list-style: none"> <div> <input class="form-control" style="width: 400px" type="text" placeholder="Name" id="name" onkeyup="m(0);"><button class="btn btn-default" onclick="m(0);">search</button> </div> </li> </center>
    </ul>
    <br>
    <div class="row" style="max-width: 1290px">
        <div class="col-1"></div>
        <div id="cb" class="col-3 border border-primary">

            <center><label>Advanced Search</label></center>
            <br>

            <span class="text1">Material </span>
            <select class="text1 form-control" id="material" onchange="m(0);">
                <option value="0">All</option>
                <option value="1">Gold</option>
                <option value="2">Silver</option>
                <option value="3">White Gold</option>
            </select>

            <br>

            <span class="text1">Type</span>
            <select class="text1 form-control" id="type" onchange="m(0);">
                <option value="0">All</option>
                <option value="Armlet">Armlets</option>
                <option value="Bracelet">Bracelets</option>
                <option value="Necklac">Necklaces</option>
                <option value="Earring">Earrings</option>
                <option value="Ring">Rings</option>
                <option value="Engagement ring">Engagement rings</option>
                <option value="Wedding ring">Wedding rings</option>
                <option value="Pendant">Pendants</option>
            </select>

            <br>

            <span class="text1">Sort By </span>
            <select class="text1 form-control" id="asd" onchange="m(0);">
                <option value="ard">Asc By Date Reg</option>
                <option value="drd">Desc By Date Reg</option>
                <option value="ap">Asc By Price</option>
                <option value="dp">Desc By Price</option>
                <option value="5">Asc</option>
                <option value="6">Desc</option>
            </select>
            <br>

            <div class="border border-info">
                <span class="text1" class="danger">Price Between</span>
                <br>
                <input class="text1 form-control" type="number" id="min" onkeyup="m(0);"><span class="text1" >  to  </span><input class="text1 form-control" type="number" id="max" onkeyup="m(0);">
                <br>
            </div>

            <br>
            <button class="btn btn-default" onclick="m(0);">search</button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <br><br>
        </div>

        <div id="ll" class="col-8">

        </div>
    </div>

    <br><br>
    <div class="row" style="max-width: 1290px">
        <div class="col-md-4"></div>
        <div class="col-md-8">
            <table>

                <tr id="r">

                </tr>

            </table>
        </div>
    </div>
    
    <div style="height: 30px"></div>
    
</body>
<script>


    function addToCart(id) {

        var request = new XMLHttpRequest();
        var qty = 1;

        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {

                if (request.responseText===""){
                    Swal.fire({
                                position: 'top-end',
                                icon: 'success',
                                title: 'Added to the cart',
                                showConfirmButton: false,
                                timer: 1500
                            });
                } else {
                    Swal.fire({
                                icon: 'error',
                                title: 'Oops...',
                                text: request.responseText

                            });
                }
                    

            }
        };

        request.open("GET", "addtocart?id=" + id + "&qty=" + qty, true);
        request.send();

    }




    function m(e) {
        document.getElementById("ll").innerHTML = "";
        var material = document.getElementById("material").value;
        var name = document.getElementById("name").value;
        var asd = document.getElementById("asd").value;
        var min = document.getElementById("min").value;
        var max = document.getElementById("max").value;
        var type = document.getElementById("type").value;
        //var email = document.getElementById("email").value;
        //var country = document.getElementById("country").value;



        var i = e;

        if (e === 99999) {
            i = 0;
        }

        var ar = new Array();

        //          for (var u = 0; u < i; u++) {

        //            if (document.getElementById("os" + u).checked) {

        //alert(document.getElementById("os" + u).value);

        //              ar.push(document.getElementById("os" + u).value);

        //          }

        //      }


        var obj = {"material": material, "name": name, "asd": asd, "min": min, "max": max, "type": type};

        var request = new XMLHttpRequest();


        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {

                document.getElementById("r").innerHTML = request.responseText.split("^")[1];

                var j = JSON.parse(request.responseText.split("^")[0]);


                for (var i = 0; j.length > i; i++) {

                    var job = j[i];
                    //gg+="<option>"+s[v]+"</option>";
                    var ggz = document.createElement("div");
                    var gg = document.createElement("div");
                    var ggg = document.createElement("div");
                    var gggg = document.createElement("div");

                    var op = document.createElement("img");

                    var temgg1 = document.createElement("br");


                    var op1 = document.createElement("span");

                    var temgg2 = document.createElement("br");

                    var tem2 = document.createElement("span");
                    var op2 = document.createElement("span");

                    var temgg3 = document.createElement("br");

                    var tem3 = document.createElement("span");
                    var op3 = document.createElement("span");

                    var tem4 = document.createElement("p");

                    var temgg4 = document.createElement("br");
                    var temgg5 = document.createElement("br");

                    var b1 = document.createElement("button");

                    var b2 = document.createElement("button");
                    var temgg6 = document.createElement("br");

                    var b3 = document.createElement("button");
                    var temgg7 = document.createElement("br");
                    op.setAttribute("src", "Images//Product_Images//" + job["imgone"]);
                    op.setAttribute("width", "200px");
                    op.setAttribute("height", "250px");
                    gg.setAttribute("class", "row");
                    ggz.setAttribute("class", "view card");
                    ggz.setAttribute("style", "background-color:#DCE3E8");
                    //gg.setAttribute("float", "left");
                    gggg.setAttribute("float", "left");
                    ggg.setAttribute("float", "right");
                    ggg.setAttribute("display", "inline-block");
                    ggg.setAttribute("class", "card-header");
                    gggg.setAttribute("display", "inline-block");
                    tem4.setAttribute("class", "txtpara");
                    b1.setAttribute("onclick", "loadmore(" + job["id"] + ");");
                    b2.setAttribute("onclick", "addToCart(" + job["id"] + ");");

                    // op.src=j[v][0];
                    //op.Attributes.src=j[v][0];
                    //op.Attributes.width="200px"; 
                    //op.Attributes.height="250px";
                    // tem1.Attributes.value=" Name : ";
                    // tem2.Attributes.value=" Price : ";
                    // tem3.Attributes.value=" QTY : ";

                    tem2.innerHTML = " Price : ";
                    tem3.innerHTML = " QTY : ";
                    b1.innerHTML = "View Details";
                    b2.innerHTML = "Add to cart";
                    b3.innerHTML = "Buy now";
                    op1.innerHTML = job["material"] + " " + job["name"] + " " + job["type"];
                    op2.innerHTML = "$" + job["price"];
                    op3.innerHTML = job["count"];
                    tem4.innerHTML = job["desc"];
                    b1.className = "btn btn-info stbtn";
                    b2.className = "btn btn-info stbtn";
                    b3.className = "btn btn-info stbtn";
                    gggg.className = "col-md-3";
                    ggg.className = "col-md-9";
                    //ggg.setAttribute("width", "745px");


                    gggg.appendChild(op);
                    //gg.appendChild(temgg1);

                    ggg.appendChild(op1);
                    ggg.appendChild(temgg2);
                    ggg.appendChild(tem2);
                    ggg.appendChild(op2);
                    ggg.appendChild(temgg3);
                    ggg.appendChild(tem3);
                    ggg.appendChild(op3);
                    ggg.appendChild(temgg4);
                    ggg.appendChild(tem4);
                    ggg.appendChild(temgg5);
                    ggg.appendChild(b1);
                    //gg.appendChild(temgg5);
                    ggg.appendChild(b2);
                    //gg.appendChild(temgg6);
                    ggg.appendChild(b3);

                    gg.appendChild(gggg);
                    gg.appendChild(ggg);


                    ggz.appendChild(gg);

                    //gg.appendChild(temgg7);
                    document.getElementById("ll").appendChild(ggz);
                    document.getElementById("ll").appendChild(temgg1);
                }


            }
        };
        // request.open("GET", "Advancedsearch?a=" + JSON.stringify(obj), false);
        request.open("GET", "LoadProducts?a=" + JSON.stringify(obj) + "&i=" + e, true);

        request.send();
        //me patten json obj ekakata values add karala yawanna. ehapatten criteria search ekka ghla eka eka restrictions add krnna.


    }


    function loadmore(id) {

        var request = new XMLHttpRequest();

        request.onreadystatechange = function () {
            if (request.readyState === 4) {
                if (request.status === 200) {
                    var x = request.responseText;
                    send(x);
                }
            }
        };
        request.open("GET", "loadmore?g=" + id, true);
        request.send();


    }

    function send(x) {
        var xx = x;
        window.location = "viewmore.jsp?gg=" + xx;

    }





    function OS() {
        document.getElementById("cb").innerHTML = "";
        var request = new XMLHttpRequest();

        request.onreadystatechange = function () {
            if (request.readyState === 4) {
                if (request.status === 200) {
                    var j = JSON.parse(request.responseText);


                    for (var i = 0; j.length > i; i++) {
                        var s1 = document.createElement("span");
                        s1.innerHTML = j[i];
                        var c1 = document.createElement("input");
                        var br = document.createElement("br");
                        c1.setAttribute("type", "checkbox");
                        c1.setAttribute("onclick", "m(" + j.length + ");");
                        c1.setAttribute("value", j[i]);
                        c1.setAttribute("id", "os" + i);
                        document.getElementById("cb").appendChild(s1);
                        document.getElementById("cb").appendChild(c1);
                        document.getElementById("cb").appendChild(br);
                    }




                }
            }
        };
        request.open("GET", "os", true);
        request.send();


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
