<%-- 
    Document   : editcustomer
    Created on : Apr 16, 2021, 1:52:19 PM
    Author     : Kakashi
--%>

<%@page import="bean.Customers"%>
<%@page import="bean.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add customer</title>
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
        <div class="div-icon">
            <a class="classicon" href="home.jsp"><i class="fa fa-home fa-lg"></i></a>
            <span><i class="fa fa-angle-right fa-lg"></i></span>
            <a class="classicon" href="doCustomer">Quản lý khách hàng</a>
            <span><i class="fa fa-angle-right fa-lg"></i></span>
            <span>Sửa khách hàng</span>
        </div>
        <div class="formadd">
            <div id="notification" class="alert success" style="display: none;">
                <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                <strong>Thành công!</strong> Khách hàng đã được sửa thành công.
            </div>
            <div id="notificationfail" class="alert" style="display: none;">
                <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span> 
                <strong>Không thành công!</strong> Sửa thất bại.
            </div>
            <%
                if (request.getSession().getAttribute("checkadd") != null) {
                    boolean checkadd = (boolean) request.getSession().getAttribute("checkadd");
                    if (checkadd) {
            %>
            <script>
                document.getElementById('notification').style.display = 'block';
            </script>
            <%
            } else {
            %>
            <script>
                document.getElementById('notificationfail').style.display = 'block';
            </script>
            <%
                    }
                }
            %>
            <%
                Customers customers = (Customers) request.getSession().getAttribute("customeredit");
                System.out.println("error");
                System.out.println(customers.toString());   
            %>
            <form action="doEditCustomer">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="firstname">Họ</label>
                        <input type="text" class="form-control" value="<%=customers.getFirstname()%>" 
                               name="firstname" placeholder="Họ" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="middlename">Họ đệm</label>
                        <input type="text" class="form-control" value="<%=customers.getMiddlename()%>"
                               name="middlename" placeholder="Họ đệm" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="lastname">Tên</label>
                        <input type="text" class="form-control" value="<%=customers.getLastname()%>"
                               name="lastname" placeholder="Tên" required>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label for="fullname">Tên đầy đủ</label>
                    <input type="text" class="form-control" value="<%=customers.getFullname()%>"
                           name="fullname" placeholder="Tên đầy đủ" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="phonenumber">Số điện thoại</label>
                    <input type="text" class="form-control" value="<%=customers.getPhonenumber()%>"
                           name="phonenumber" placeholder="0xxxxxxxxx" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="address">Địa chỉ</label>
                    <input type="text" class="form-control" value="<%=customers.getAddress()%>"
                           name="address" placeholder="Địa chỉ" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" value="<%=customers.getEmail()%>"
                           name="email" placeholder="abc@gmail.com" required>
                </div>
                <div class="form-group col-md-12">
                    <label for="fromto">Địa chỉ giao nhận</label>
                    <input type="text" class="form-control" value="<%=customers.getFromto()%>"
                           name="fromto" placeholder="660 Hai Bà Trưng, Hà Nội" required>
                </div><br>
                <div class="form-group submit-type">
                    <button type="submit" class="form-control btn btn-success"><i class="fa fa-save"></i> Sửa</button>
                </div>
            </form>
        </div>
    </body>
</html>
