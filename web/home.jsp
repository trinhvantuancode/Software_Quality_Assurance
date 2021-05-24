<%-- 
    Document   : Home
    Created on : Apr 7, 2021, 12:54:36 AM
    Author     : Kakashi
--%>

<%@page import="bean.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/home_stype.css">
    <body>
        <%
            if (!request.isRequestedSessionIdValid()) {
                response.sendRedirect("index.jsp");
            }
            Users user = (Users) session.getAttribute("SessionUser");
            String fullName = user.getFullname();
        %>
        <nav class="navbar">
            <ul class="navbar-left">
                <a class="active" href="home.jsp"><i class="fa fa-fw fa-home"></i> Trang chủ</a> 
                <a class="classa" href="doCustomer"><i class="fa fa-tasks"></i> Quản lý khách hàng</a> 
                <a class="classa" href="#"><i class="fa fa-tasks"></i> Quản lý đơn hàng</a>
            </ul>
            <ul class="navbar-right">
                <a class="classa" href="#"><i class="fa fa-user"></i> Xin chào, <%=fullName %></a> 
                <a class="classa" href="doLogout"><i class="fa fa-sign-out"></i> Đăng xuất</a>
            </ul>

        </nav>

    </body>
</html> 
