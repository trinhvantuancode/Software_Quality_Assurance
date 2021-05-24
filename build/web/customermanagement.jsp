<%-- 
    Document   : customermanagement
    Created on : Apr 13, 2021, 4:46:40 PM
    Author     : Kakashi
--%>

<%@page import="bean.Customers"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý khách hàng</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/home_stype.css">
    </head>
    <body>
        <%
            if (session == null || !request.isRequestedSessionIdValid()) {
                response.sendRedirect("index.jsp");
            }
            Users user = (Users) session.getAttribute("User");
            String fullName = user.getFullname();
            ArrayList<Customers> arrayList = (ArrayList)session.getAttribute("listcustomer");
        %>
        <nav class="navbar">
            <ul class="navbar-left">
                <a class="classa" href="home.jsp"><i class="fa fa-fw fa-home"></i> Trang chủ</a> 
                <a class="active" href="doCustomer"><i class="fa fa-tasks"></i> Quản lý khách hàng</a> 
                <a class="classa" href="#"><i class="fa fa-tasks"></i> Quản lý đơn hàng</a>
            </ul>
            <ul class="navbar-right">
                <a class="classa" href="#"><i class="fa fa-user"></i> Xin chào, <%=fullName%></a>
                <a class="classa" href="doLogout"><i class="fa fa-sign-out"></i> Đăng xuất</a>
            </ul>
        </nav>
        <div class="div-table">
            <button onclick="window.location.href='pluscustomer.jsp'" type="button" class="btn btn-success">
                <i class="fa fa-plus"></i>Thêm khách hàng</button>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Mã khách hàng</th>
                        <th scope="col">Full name</th>
                        <th scope="col">Address</th>
                        <th scope="col">Phonenumber</th>
                        <th scope="col">Email</th>
                        <th scope="col">Sửa</th>
                        <th scope="col">Xóa</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    if (arrayList == null) {
                %>
                <h3 style="color: red">Không có khách hàng để hiển thị.</h3>
                <%
                } else {
                    for (int i = 0; i < arrayList.size(); i++) {
                %>
                <tr>
                    <td><%=arrayList.get(i).getIdcustomer() %></td>
                    <td><%=arrayList.get(i).getFullname() %></td>
                    <td><%=arrayList.get(i).getAddress() %></td>
                    <td><%=arrayList.get(i).getPhonenumber() %></td>
                    <td><%=arrayList.get(i).getEmail() %></td>
                    <td><a href="doGetCustomer?idsua=<%=i%>"><i class="fa fa-edit"></i></a></td>
                    <td><a href="doDelete?idxoa=<%=i%>"><i class="fa fa-trash"></i></a></td>
                </tr>
                <%
                        }
                    }
                %>

                </tbody>
            </table>
        </div>
    </body>
</html>
