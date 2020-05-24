<%-- 
    Document   : PwResetRedirect
    Created on : May 30, 2018, 2:03:20 PM
    Author     : ASUS
--%>

<%@page import="Pojos.User"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="Connection.NewHibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>

        <%

            Session s = NewHibernateUtil.getSessionFactory().openSession();
            Criteria c = s.createCriteria(User.class);
            String em = request.getParameter("em");
            c.add(Restrictions.eq("email", em));
            c.add(Restrictions.eq("backupPin", request.getParameter("pin")));

            User l = (User) c.uniqueResult();

            if (l != null&&l.getStatus().equals("100")) {
                HttpSession ses = request.getSession();
                ses.setAttribute("em", em);
        %>

    <center>
        <div style="height: 200px"></div>
        <div class="container">
            <div class="col-lg-4"></div>
            <div class="col-lg-4">
                <div class="jumbotron">
                    <div class="form-group">
                            <input type="password" id="pw" placeholder="Password" class="form-control">
                            <input type="password" id="cpw" placeholder="Confirm Password" class="form-control">
                            <div class="form-group">
                                <label class="col-form-label label label-danger"  style="color: red" id="oopz"></label>
                            </div>                    
                            <button onclick="reset();" class="btn btn-primary btn-block">Reset</button>
                    </div>
                </div>
            </div>
        </div>
    </center>

    <%        } else {

    %>
    <center>
        <div style="height: 200px;"></div>
        <div class="bg-info" style="height: 400px; width: 700px;">
            <h1 style="color: #d9534f">Something Wrong With Your Link</h1>
        </div>
    </center>
    <%            }

    %>

</body>

<script>

    function reset() {
        var request = new XMLHttpRequest();


        request.onreadystatechange = function () {
            if (request.readyState === 4) {

                if (request.status === 200) {
                    
                    if(request.responseText==="gg"){
                        window.location = "index.jsp";
                    }else {
                        document.getElementById("oopz").innerHTML = request.responseText;
                        document.getElementById("pw").value = "";
                        document.getElementById("cpw").value = "";
                    }
                    
                }
            }
        };

        request.open("POST", "ResetPw", true);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send("pw=" + document.getElementById("pw").value + "&" + "cpw=" + document.getElementById("cpw").value);
    }

</script>

</html>
