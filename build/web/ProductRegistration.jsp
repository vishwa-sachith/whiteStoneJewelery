<%-- 
    Document   : ProductRegistration
    Created on : Jun 6, 2018, 12:53:13 PM
    Author     : ASUS
--%>

<%@page import="Pojos.Stone"%>
<%@page import="Pojos.Material"%>
<%@page import="Pojos.Weightmesurement"%>
<%@page import="Pojos.Puritymesurement"%>
<%@page import="Pojos.Purity"%>
<%@page import="java.util.List"%>
<%@page import="Pojos.Type"%>
<%@page import="Connection.NewHibernateUtil"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Registration</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>


        <!-- CSS -->
        <style>

            @import url(https://fonts.googleapis.com/css?family=Montserrat);

            * {margin: 0; padding: 0;}

            .flchooser {

                display: none;

            }

            html {
                height: 100%;
                /*Image only BG fallback*/

                /*background = gradient + image pattern combo*/
                background: 
                    linear-gradient(rgba(192, 203, 219, 0.6), rgba(155, 89, 182, 0.6));
            }

            body {
                font-family: montserrat, arial, verdana;
            }
            /*form styles*/
            #msform {
                width: 1000px;
                margin: 50px auto;
                text-align: center;
                position: relative;
            }
            #msform fieldset {
                background: white;
                border: 0 none;
                border-radius: 3px;
                box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
                padding: 20px 30px;
                box-sizing: border-box;
                width: 80%;
                margin: 0 10%;

                /*stacking fieldsets above each other*/
                position: relative;
            }
            /*Hide all except first fieldset*/
            #msform fieldset:not(:first-of-type) {
                display: none;
            }
            /*inputs*/
            #msform input, #msform textarea {
                padding: 15px;
                border: 1px solid #ccc;
                border-radius: 3px;
                margin-bottom: 10px;
                width: 100%;
                box-sizing: border-box;
                font-family: montserrat;
                color: #2C3E50;
                font-size: 13px;
            }
            /*buttons*/
            #msform .action-button {
                width: 100px;
                background: #27AE60;
                font-weight: bold;
                color: white;
                border: 0 none;
                border-radius: 1px;
                cursor: pointer;
                padding: 10px 5px;
                margin: 10px 5px;
            }
            .selecttg {
                padding: 15px;
                border: 1px solid #ccc;
                border-radius: 3px;
                margin-bottom: 10px;
                width: 100%;
                box-sizing: border-box;
                font-family: montserrat;
                color: #2C3E50;
                font-size: 13px;
            }
            #msform .action-button:hover, #msform .action-button:focus {
                box-shadow: 0 0 0 2px white, 0 0 0 3px #27AE60;
            }
            /*headings*/
            .fs-title {
                font-size: 15px;
                text-transform: uppercase;
                color: #2C3E50;
                margin-bottom: 10px;
            }
            .fs-subtitle {
                font-weight: normal;
                font-size: 13px;
                color: #666;
                margin-bottom: 20px;
            }
            /*progressbar*/
            #progressbar {
                margin-bottom: 30px;
                overflow: hidden;
                /*CSS counters to number the steps*/
                counter-reset: step;
            }
            #progressbar li {
                list-style-type: none;
                color: white;
                text-transform: uppercase;
                font-size: 9px;
                width: 25%;
                float: left;
                position: relative;
            }
            #progressbar li:before {
                content: counter(step);
                counter-increment: step;
                width: 20px;
                line-height: 20px;
                display: block;
                font-size: 10px;
                color: #333;
                background: white;
                border-radius: 3px;
                margin: 0 auto 5px auto;
            }
            /*progressbar connectors*/
            #progressbar li:after {
                content: '';
                width: 100%;
                height: 2px;
                background: white;
                position: absolute;
                left: -50%;
                top: 9px;
                z-index: -1; /*put it behind the numbers*/
            }
            #progressbar li:first-child:after {
                /*connector not needed before the first step*/
                content: none; 
            }
            /*marking active/completed steps green*/
            /*The number of the step and the connector before it = green*/
            #progressbar li.active:before,  #progressbar li.active:after{
                background: #27AE60;
                color: white;
            }


            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even){background-color: #f2f2f2}

            th {
                background-color: #4CAF50;
                color: white;
            }

        </style>
    </head>




    <body>

        <div style="height: 30px">
            <input type="button" onclick="toadminpln();" value="Back" style="background-color: #c9c03e;width: 100px;
                   font-weight: bold;
                   color: white;
                   border: 0 none;
                   border-radius: 1px;
                   cursor: pointer;
                   padding: 10px 5px;
                   margin: 10px 5px;"/>
        </div>

        <form id="msform">

            <ul id="progressbar">
                <li class="active">Main Details</li>
                <li>More Details</li>
                <li>Stone Details</li>
                <li>Images</li>
            </ul>

            <fieldset>
                <h2 class="fs-title">Main Details</h2>
                <h3 class="fs-subtitle">This is step 1</h3>
                <select id="type" class="form-control selecttg">
                    <%
                        Session s = NewHibernateUtil.getSessionFactory().openSession();
                        Criteria c = s.createCriteria(Type.class);
                        List<Type> t = c.list();
                        for (Type ty : t) {
                    %>             
                    <option value=<%=ty.getId()%>><%=ty.getType()%></option>   
                    <%
                        }
                    %>
                </select>
                <input type="text" id="name" placeholder="Name Of The Product"/>
                <div class="col-md-12">
                    <div class="col-md-8">
                        <select id="purity" class="form-control selecttg">             
                            <%
                                Criteria c1 = s.createCriteria(Purity.class);
                                List<Purity> t1 = c1.list();
                                for (Purity ty : t1) {
                            %>             
                            <option value=<%=ty.getId()%>><%=ty.getValue()%> <%=ty.getPuritymesurement().getPurityMesurement()%></option>   
                            <%
                                }
                            %>
                        </select>
                    </div>

                </div>

                <div class="col-md-12">
                    <div class="col-md-8">
                        <input type="text" id="weight" placeholder="Weight" style="width: 50%; float: left"/>
                    </div>
                    <div class="col-md-4">
                        <select id="weightmesurement" class="form-control selecttg" style="width: 50%;">      
                            <%
                                Criteria c3 = s.createCriteria(Weightmesurement.class);
                                List<Weightmesurement> t3 = c3.list();
                                for (Weightmesurement ty : t3) {
                            %>             
                            <option value=<%=ty.getId()%>><%=ty.getWeightMesurement()%></option>   
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>
                <select id="material" class="form-control selecttg">
                    <%
                        Criteria c4 = s.createCriteria(Material.class);
                        List<Material> t4 = c4.list();
                        for (Material ty : t4) {
                    %>             
                    <option value=<%=ty.getId()%>><%=ty.getMaterial()%></option>   
                    <%
                        }
                    %>
                </select>
                <input type="button" name="next" class="next action-button" value="Next" />
            </fieldset>

            <fieldset>
                <h2 class="fs-title">More Details</h2>
                <h3 class="fs-subtitle">About cost and sale stuff</h3>

                <label class="selecttg" style="width: 10%; float: left">Rs:</label>
                <input type="number" id="cost" placeholder="Cost" style="width: 90%;"/>

                <label class="selecttg" style="width: 10%; float: left">Rs:</label>
                <input type="number" id="price" placeholder="Selling Price" style="width: 90%;"/>

                <label class="selecttg" style="width: 10%; float: left">Rs:</label>
                <input type="number" id="discount" placeholder="Discount" style="width: 90%;"/>

                <label class="selecttg" style="width: 30%; float: left">Estimated Date</label>
                <input type="date" id="estimateddate" style="width: 70%; height: 48px"/>

                <label class="selecttg" style="width: 30%; float: left">Date Created</label>
                <input type="date" id="datecreated" style="width: 70%; height: 48px"/>

                <input type="number" id="count" placeholder="Count" title="How Many You Created"/>

                <textarea id="description" placeholder="Description"></textarea>

                <input type="button" name="previous" class="previous action-button" value="Previous" />
                <input type="button" name="next" class="next action-button" value="Next" />
            </fieldset>

            <fieldset style="width: 100%">
                <h2 class="fs-title">Stone Details</h2>
                <h3 class="fs-subtitle">About Stones Added To The Item</h3>

                <select id="stone" class="form-control selecttg">             
                    <%
                        Criteria c5 = s.createCriteria(Stone.class);
                        List<Stone> t5 = c5.list();
                        for (Stone ty : t5) {
                    %>             
                    <option id="stone<%=ty.getId()%>" value="<%=ty.getId()%>">Stone Type - <%=ty.getStone()%>,    ... Color - <%=ty.getColor()%>,    ... Shape - <%=ty.getShape()%></option>   
                    <%
                        }
                    %>
                </select>

                <div class="col-md-8">
                    <input type="number" id="weightstone" placeholder="Weight" style="width: 50%; float: left"/>
                </div>
                <div class="col-md-4">
                    <select id="weightmesurementstone" class="form-control selecttg" style="width: 50%;">      
                        <%
                            Criteria c6 = s.createCriteria(Weightmesurement.class);
                            List<Weightmesurement> t6 = c6.list();
                            for (Weightmesurement ty : t6) {
                        %>             
                        <option  id="weime<%=ty.getId()%>" value=<%=ty.getId()%>><%=ty.getWeightMesurement()%></option>   
                        <%
                            }
                        %>
                    </select>
                </div>
                <select id="puritystone" class="form-control selecttg">             
                    <%
                        Criteria c7 = s.createCriteria(Purity.class);
                        List<Purity> t7 = c7.list();
                        for (Purity ty : t7) {
                    %>             
                    <option  id="pur<%=ty.getId()%>"  value=<%=ty.getId()%>><%=ty.getValue()%><%=ty.getPuritymesurement().getPurityMesurement()%></option>   
                    <%
                        }
                    %>
                </select>
                <input type="number" id="countstone" placeholder="Count" title="How Many Of This Stones You Added To The Product"/>

                <input type="button" onclick="add();" class="action-button" value="Add" style="background-color: #3399ff"/>

                <input type="button" name="previous" class="previous action-button" value="Previous" />
                <input type="button" name="next" class="next action-button" value="Next" />

                <input type="button" onclick="removeall();" class="action-button" value="Remove All" style="background-color: #d9534f"/>

                <table style="font-size: 12px" id="tble">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Details</th>
                            <th>Weight</th>
                            <th>Measurement</th>
                            <th>Purity</th>
                            <th>Count</th>
                        </tr>
                    </thead>

                    <tbody id="tb">

                    </tbody>
                </table>

            </fieldset>

            <fieldset>
                <h2 class="fs-title">Images</h2>
                <h3 class="fs-subtitle">The First Image Will Be The Main Image</h3>


                <center>
                    <label for="filechooser1"><img id="preview1" src="Images/addimage.png" style="height: 150px; width: 150px; border: #000 solid 1px; padding: 3px;"></label>
                    <input type="file" name="img1" class="flchooser" id="filechooser1" onchange="preview();">
                </center>

                <br>

                <label for="filechooser2"><img id="preview2" src="Images/addimage.png" style="height: 70px; width: 70px; border: #000 solid 1px; padding: 3px;"></label>
                <input type="file" name="img2" class="flchooser" id="filechooser2" onchange="previeww();">

                <label for="filechooser3"><img id="preview3" src="Images/addimage.png" style="height: 70px; width: 70px; border: #000 solid 1px; padding: 3px;"></label>
                <input type="file" name="img3" class="flchooser" id="filechooser3" onchange="previewww();">

                <label for="filechooser4"><img id="preview4" src="Images/addimage.png" style="height: 70px; width: 70px; border: #000 solid 1px; padding: 3px;"></label>
                <input type="file" name="img4" class="flchooser" id="filechooser4" onchange="previewwww();">

                <label for="filechooser5"><img id="preview5" src="Images/addimage.png" style="height: 70px; width: 70px; border: #000 solid 1px; padding: 3px;"></label>
                <input type="file" name="img5" class="flchooser" id="filechooser5" onchange="previewwwww();">

                <input type="button" name="previous" class="previous action-button" value="Previous" />
                <input type="button" onclick="save();" class="submit action-button" value="Submit" />
            </fieldset>
        </form>



    </body>

    <!-- Java Script -->
    <script type="text/javascript">

        function toadminpln() {
            document.location = "index.jsp";
        }

        function save() {

            var type = document.getElementById("type").value;
            var name = document.getElementById("name").value;
            var purity = document.getElementById("purity").value;
            var weight = document.getElementById("weight").value;
            var weightmesurement = document.getElementById("weightmesurement").value;
            var material = document.getElementById("material").value;

            var cost = document.getElementById("cost").value;
            var price = document.getElementById("price").value;
            var discount = document.getElementById("discount").value;
            var estimateddate = document.getElementById("estimateddate").value;
            var datecreated = document.getElementById("datecreated").value;
            var count = document.getElementById("count").value;
            var description = document.getElementById("description").value;

            var file1 = document.getElementById("filechooser1").files[0];
            var file2 = document.getElementById("filechooser2").files[0];
            var file3 = document.getElementById("filechooser3").files[0];
            var file4 = document.getElementById("filechooser4").files[0];
            var file5 = document.getElementById("filechooser5").files[0];

            var form = new FormData();

            form.append("type", type);
            form.append("name", name);
            form.append("purity", purity);
            form.append("weight", weight);
            form.append("weightmesurement", weightmesurement);
            form.append("material", material);

            form.append("cost", cost);
            form.append("price", price);
            form.append("discount", discount);
            form.append("estimateddate", estimateddate);
            form.append("datecreated", datecreated);
            form.append("count", count);
            form.append("description", description);

            form.append("file1", file1);
            form.append("file2", file2);
            form.append("file3", file3);
            form.append("file4", file4);
            form.append("file5", file5);

            var request = new XMLHttpRequest();

            request.onreadystatechange = function () {
                if (request.readyState === 4) {
                    if (request.status === 200) {

                        if (request.responseText === "aa") {
                            Swal.fire({
                                icon: 'error',
                                title: 'Oops...',
                                text: 'Product Name Already Exist!'

                            });
                            document.getElementById("name").style.backgroundColor = "yellow";
                        } else if (request.responseText === "gg") {
                            Swal.fire({
                                position: 'top-end',
                                icon: 'success',
                                title: 'Product Registered',
                                showConfirmButton: false,
                                timer: 1500
                            });
                            document.getElementById("tb").innerHTML = "";
                            document.getElementById("name").value = "";
                            document.getElementById("weight").value = "";
                            document.getElementById("cost").value = "";
                            document.getElementById("price").value = "";
                            document.getElementById("discount").value = "";
                            document.getElementById("datecreated").value = "";
                            document.getElementById("count").value = "";
                            document.getElementById("description").value = "";
                            document.getElementById("weightstone").value = "";
                            document.getElementById("countstone").value = "";
                            document.getElementById("preview1").src = "Images/addimage.png";
                            document.getElementById("preview2").src = "Images/addimage.png";
                            document.getElementById("preview3").src = "Images/addimage.png";
                            document.getElementById("preview4").src = "Images/addimage.png";
                            document.getElementById("preview5").src = "Images/addimage.png";
                        }
                    }
                }
            };
            request.open("POST", "RegProducts?remove=all");
            request.send(form);

        }


        function preview() {

            var file = document.getElementById("filechooser1").files[0];
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (content) {
                document.getElementById("preview1").src = content.target.result;
            };
        }

        function previeww() {

            var file = document.getElementById("filechooser2").files[0];
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (content) {
                document.getElementById("preview2").src = content.target.result;
            };
        }

        function previewww() {

            var file = document.getElementById("filechooser3").files[0];
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (content) {
                document.getElementById("preview3").src = content.target.result;
            };
        }

        function previewwww() {

            var file = document.getElementById("filechooser4").files[0];
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (content) {
                document.getElementById("preview4").src = content.target.result;
            };
        }

        function previewwwww() {

            var file = document.getElementById("filechooser5").files[0];
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (content) {
                document.getElementById("preview5").src = content.target.result;
            };
        }

        // eka eka cells walata wena wenama idintifiers hdnna. stone id use krnna. row ekak add krnkota eka kalin add krlada blnna. add krlanm count eka + wenna hdnna.

//alert(document.getElementById("tb").rows.length);



        function removeall() {
            var request = new XMLHttpRequest();

            request.onreadystatechange = function () {
                if (request.readyState === 4) {
                    if (request.status === 200) {

                        document.getElementById("tb").innerHTML = "";

                    }
                }
            };
            request.open("GET", "AddToTable?remove=all");
            request.send();
        }




        function viewetbl(re) {

            var j = JSON.parse(re);

            document.getElementById("tb").innerHTML = "";

            for (var i = 0; j.length > i; i++) {

                var job = j[i];

                var tr = document.createElement("tr");

                var tdstid = document.createElement("td");
                var tdsde = document.createElement("td");
                var tdwegh = document.createElement("td");
                var tdweigmesu = document.createElement("td");
                var tdpurity = document.createElement("td");
                var tdcount = document.createElement("td");




                tdstid.innerHTML = job["stoneid"];
                tdsde.innerHTML = job["details"];
                tdwegh.innerHTML = job["weight"];
                tdweigmesu.innerHTML = job["weightmesu"];
                tdpurity.innerHTML = job["puritydeta"];
                tdcount.innerHTML = job["count"];

                tr.appendChild(tdstid);
                tr.appendChild(tdsde);
                tr.appendChild(tdwegh);
                tr.appendChild(tdweigmesu);
                tr.appendChild(tdpurity);
                tr.appendChild(tdcount);


                document.getElementById("tb").appendChild(tr);

            }

        }



        function  add() {

            var stoneid = document.getElementById("stone").value;
            var details = document.getElementById("stone" + stoneid).innerHTML;
            var weight = document.getElementById("weightstone").value;
            var weightmesuid = document.getElementById("weightmesurementstone").value;
            var weightmesu = document.getElementById("weime" + weightmesuid).innerHTML;
            var purityid = document.getElementById("puritystone").value;
            var puritydeta = document.getElementById("pur" + purityid).innerHTML;
            var count = document.getElementById("countstone").value;

            var a = true;
            var b = true;

            if (weight < 1) {
                document.getElementById("weightstone").value = "";
                document.getElementById("weightstone").style.backgroundColor = "yellow";
                a = false;
            }

            if (count < 1) {
                document.getElementById("countstone").value = "";
                document.getElementById("countstone").style.backgroundColor = "yellow";
                b = false;
            }

            if (a && b) {
                document.getElementById("countstone").style.backgroundColor = "white";
                document.getElementById("weightstone").style.backgroundColor = "white";

                var request = new XMLHttpRequest();

                request.onreadystatechange = function () {
                    if (request.readyState === 4) {
                        if (request.status === 200) {
                            var j = request.responseText;

                            document.getElementById("weightstone").value = "";
                            document.getElementById("countstone").value = "";

                            viewetbl(j);


                        }
                    }
                };
                request.open("GET", "AddToTable?stoneid=" + stoneid + "&details=" + details + "&weight=" + weight + "&weightmesuid=" + weightmesuid + "&weightmesu=" + weightmesu + "&purityid=" + purityid + "&puritydeta=" + puritydeta + "&count=" + count, true);
                request.send();

            }

        }




        var current_fs, next_fs, previous_fs; //fieldsets
        var left, opacity, scale; //fieldset properties which we will animate
        var animating; //flag to prevent quick multi-click glitches

        $(".next").click(function () {
            if (animating)
                return false;
            animating = true;

            current_fs = $(this).parent();
            next_fs = $(this).parent().next();

            //activate next step on progressbar using the index of next_fs
            $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

            //show the next fieldset
            next_fs.show();
            //hide the current fieldset with style
            current_fs.animate({opacity: 0}, {
                step: function (now, mx) {
                    //as the opacity of current_fs reduces to 0 - stored in "now"
                    //1. scale current_fs down to 80%
                    scale = 1 - (1 - now) * 0.2;
                    //2. bring next_fs from the right(50%)
                    left = (now * 50) + "%";
                    //3. increase opacity of next_fs to 1 as it moves in
                    opacity = 1 - now;
                    current_fs.css({
                        'transform': 'scale(' + scale + ')',
                        'position': 'absolute'
                    });
                    next_fs.css({'left': left, 'opacity': opacity});
                },
                duration: 800,
                complete: function () {
                    current_fs.hide();
                    animating = false;
                },
                //this comes from the custom easing plugin
                easing: 'easeInOutBack'
            });
        });

        $(".previous").click(function () {
            if (animating)
                return false;
            animating = true;

            current_fs = $(this).parent();
            previous_fs = $(this).parent().prev();

            //de-activate current step on progressbar
            $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

            //show the previous fieldset
            previous_fs.show();
            //hide the current fieldset with style
            current_fs.animate({opacity: 0}, {
                step: function (now, mx) {
                    //as the opacity of current_fs reduces to 0 - stored in "now"
                    //1. scale previous_fs from 80% to 100%
                    scale = 0.8 + (1 - now) * 0.2;
                    //2. take current_fs to the right(50%) - from 0%
                    left = ((1 - now) * 50) + "%";
                    //3. increase opacity of previous_fs to 1 as it moves in
                    opacity = 1 - now;
                    current_fs.css({'left': left});
                    previous_fs.css({'transform': 'scale(' + scale + ')', 'opacity': opacity});
                },
                duration: 800,
                complete: function () {
                    current_fs.hide();
                    animating = false;
                },
                //this comes from the custom easing plugin
                easing: 'easeInOutBack'
            });
        });





       


    </script>

    <style>
        body {
            font-family: "Open Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Helvetica, Arial, sans-serif; 
        }
    </style>



</html>
