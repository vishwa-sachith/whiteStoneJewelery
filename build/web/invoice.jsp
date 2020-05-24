<%-- 
    Document   : invoice
    Created on : Nov 18, 2019, 10:22:16 AM
    Author     : ASUS
--%>

<%@page import="Pojos.Img"%>
<%@page import="Pojos.CartHasProduct"%>
<%@page import="java.util.Set"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="Pojos.Cart"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="Connection.NewHibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@page import="Pojos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>

        <style>
            #invoice{
                padding: 30px;
            }

            .invoice {
                position: relative;
                background-color: #FFF;
                min-height: 680px;
                padding: 15px
            }

            .invoice header {
                padding: 10px 0;
                margin-bottom: 20px;
                border-bottom: 1px solid #3989c6
            }

            .invoice .company-details {
                text-align: right
            }

            .invoice .company-details .name {
                margin-top: 0;
                margin-bottom: 0
            }

            .invoice .contacts {
                margin-bottom: 20px
            }

            .invoice .invoice-to {
                text-align: left
            }

            .invoice .invoice-to .to {
                margin-top: 0;
                margin-bottom: 0
            }

            .invoice .invoice-details {
                text-align: right
            }

            .invoice .invoice-details .invoice-id {
                margin-top: 0;
                color: #3989c6
            }

            .invoice main {
                padding-bottom: 50px
            }

            .invoice main .thanks {
                margin-top: -100px;
                font-size: 2em;
                margin-bottom: 50px
            }

            .invoice main .notices {
                padding-left: 6px;
                border-left: 6px solid #3989c6
            }

            .invoice main .notices .notice {
                font-size: 1.2em
            }

            .invoice table {
                width: 100%;
                border-collapse: collapse;
                border-spacing: 0;
                margin-bottom: 20px
            }

            .invoice table td,.invoice table th {
                padding: 15px;
                background: #eee;
                border-bottom: 1px solid #fff
            }

            .invoice table th {
                white-space: nowrap;
                font-weight: 400;
                font-size: 16px
            }

            .invoice table td h3 {
                margin: 0;
                font-weight: 400;
                color: #3989c6;
                font-size: 1.2em
            }

            .invoice table .qty,.invoice table .total,.invoice table .unit {
                text-align: right;
                font-size: 1.2em
            }

            .invoice table .no {
                color: #fff;
                font-size: 1.6em;
                background: #3989c6
            }

            .invoice table .unit {
                background: #ddd
            }

            .invoice table .total {
                background: #3989c6;
                color: #fff
            }

            .invoice table tbody tr:last-child td {
                border: none
            }

            .invoice table tfoot td {
                background: 0 0;
                border-bottom: none;
                white-space: nowrap;
                text-align: right;
                padding: 10px 20px;
                font-size: 1.2em;
                border-top: 1px solid #aaa
            }

            .invoice table tfoot tr:first-child td {
                border-top: none
            }

            .invoice table tfoot tr:last-child td {
                color: #3989c6;
                font-size: 1.4em;
                border-top: 1px solid #3989c6
            }

            .invoice table tfoot tr td:first-child {
                border: none
            }

            .invoice footer {
                width: 100%;
                text-align: center;
                color: #777;
                border-top: 1px solid #aaa;
                padding: 8px 0
            }

            @media print {
                .invoice {
                    font-size: 11px!important;
                    overflow: hidden!important
                }

                .invoice footer {
                    position: absolute;
                    bottom: 10px;
                    page-break-after: always
                }

                .invoice>div:last-child {
                    page-break-before: always
                }
            }
        </style>


        <div id="invoice">

            <div class="toolbar hidden-print">
                <div class="text-right">
                    <button id="printInvoice" class="btn btn-info"><i class="fa fa-print"></i> Print</button>
                    <button class="btn btn-info"><i class="fa fa-file-pdf-o"></i> Export as PDF</button>
                </div>
                <hr>
            </div>
            <div class="invoice overflow-auto">
                <div style="min-width: 600px">
                    <header>
                        <div class="row">
                            <div class="col">
                                <a target="_blank" href="#">
                                    <img src="Images/logo.png" data-holder-rendered="true"  style="height: 100px; width: 200px;"/>
                                </a>
                            </div>
                            <div class="col company-details">
                                <h2 class="name">
                                    <a target="_blank" href="#">
                                        Whitestone Jewell
                                    </a>
                                </h2>
                                <div>455 Foggy Heights, AZ 85004, US</div>
                                <div>(123) 456-789</div>
                                <div>whitestone@gmail.com</div>
                            </div>
                        </div>
                    </header>
                    <%
                    
                    User uu = (User) request.getSession().getAttribute("user");
                    
                    %>
                    <main>
                        <div class="row contacts">
                            <div class="col invoice-to">
                                <div class="text-gray-light">INVOICE TO:</div>
                                <h2 class="to"><%= uu.getFname() + " " + uu.getLname()%></h2>
                                <div class="address"></div>
                                <div class="email"><a href="mailto:john@example.com"><%=uu.getEmail()%></a></div>
                            </div>
                            <div class="col invoice-details">
                                <h1 class="invoice-id">INVOICE 3-2-1</h1>
                                <div class="date">Date of Invoice: 18/11/2019</div>
                            </div>
                        </div>
                        <table border="0" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th class="text-left">DESCRIPTION</th>
                                    <th class="text-right">UNIT PRICE</th>
                                    <th class="text-right">UNITS</th>
                                    <th class="text-right">TOTAL</th>
                                </tr>
                            </thead>
                            <tbody>


                                <%                double total = 0;
                                    int i = 0;
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
                                                i++;
                                                Criteria ccc = s.createCriteria(Img.class);
                                                ccc.add(Restrictions.eq("product", chp.getProduct()));
                                                Img im = (Img) ccc.uniqueResult();

                                                total += chp.getProduct().getPrice() * chp.getQuantity();
                                %>


                                <tr>
                                    <td class="no"><%=i%></td>
                                    <td class="text-left"><h3><%= chp.getProduct().getName()%></h3><%= chp.getProduct().getDescription()%></td>
                                    <td class="unit">$<%= chp.getProduct().getPrice()%></td>
                                    <td class="qty" id="qty<%= chp.getProduct().getId()%>"><%= chp.getQuantity()%></td>
                                    <td class="total">$<%= chp.getQuantity() * chp.getProduct().getPrice()%></td>
                                </tr>

                                <%
                                            }
                                        }
                                    }
                                %>



                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="2"></td>
                                    <td colspan="2"></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td colspan="2"></td>
                                    <td colspan="2"></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td colspan="2"></td>
                                    <td colspan="2">GRAND TOTAL</td>
                                    <td>$<%=total%></td>
                                </tr>
                            </tfoot>
                        </table>
                        <div class="thanks">Thank you!</div>
                        <div class="notices">
                            <div>NOTICE:</div>
                            <div class="notice">A finance charge of 1.5% will be made on unpaid balances after 30 days.</div>
                        </div>
                    </main>
                    <footer>
                        Invoice was created on a computer and is valid without the signature and seal.
                    </footer>
                </div>
                <!--DO NOT DELETE THIS div. IT is responsible for showing footer always at the bottom-->
                <div></div>
            </div>
        </div>


    </body>

    <script>

        $('#printInvoice').click(function () {
            Popup($('.invoice')[0].outerHTML);
            function Popup(data)
            {
                window.print();
                return true;
            }
        });

    </script>

</html>
