<%-- 
    Document   : index
    Created on : Apr 6, 2021, 4:02:35 PM
    Author     : Kakashi
--%>

<%@page import="bean.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng nhập</title>
        
        <link rel="stylesheet" href="bootstrap-4.0.0\dist\css\bootstrap.min.css">
        <script src="jquery/jquery-3.6.0.min.js"></script>
        <script src="bootstrap-4.0.0/dist/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="font-awesome-4.7.0\css\font-awesome.min.css">

        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            Cookie[] listCookie = request.getCookies();
            String username = "";
            String password = "";
            if (listCookie != null) {
                int co = 0;
                while (co < listCookie.length) {
                    if (listCookie[co].getName().equals("CookieUser")) {
                        username = listCookie[co].getValue();
                    }
                    if (listCookie[co].getName().equals("CookiePass")) {
                        password = listCookie[co].getValue();
                    }
                    co++;
                }
            }
        %>
        <div class="container">
        <form name="formlogin" action="doLogin" onsubmit="return checkValidtion()" method="POST">
            <img src="images/avatar.svg" class="w-50 p-3">
            <h2 class="title">Xin chào</h2>
            <div class="form-row">
                <div class="form-group input-icons col-md-12">
                    <label for="username">Tên đăng nhập</label>
                    <input type="text" class="form-control" name="username"
                           placeholder="Nhập tên đăng nhập"  
                           value="<%if(request.getAttribute("OldUsername")!=null){%>${OldUsername}<%}else out.print(username); %>">
                    <span id="span-user" class="fa fa-user fa-lg"></span>
                    <p id="p-user" class="error-user">
                        <%if(request.getAttribute("errorusername")!=null) {%>
                            <script type="text/javascript">
                                document.getElementById("p-user").style.display = "block";
                            </script>
                        <%}%>
                        ${errorusername}
                    </p>
                    <p></p>
                </div>
                <div class="form-group input-icons col-md-12">
                    <label for="password">Mật khẩu</label>
                    <input type="password" class="form-control" name="password" 
                           placeholder="Nhập mật khẩu" value="<%if(request.getAttribute("OldPassword")!=null){%>${OldPassword}<%}else out.print(password); %>">
                    <span id="span-pass" class="fa fa-lock fa-lg"></span>
                    <p id="p-pass" class="error-pass">
                        <%if(request.getAttribute("errorpassword")!=null) {%>
                            <script type="text/javascript">
                                document.getElementById("p-pass").style.display = "block";
                            </script>
                        <%}%>
                        ${errorpassword}
                    </p>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="remember">Nhớ tài khoản của tôi</label>
                    <input type="checkbox" name="remember" id="remember" value="remember" checked>
                </div>
                <div class="form-group col-md-2"></div>
                <div class="form-group col-md-4">
                    <a class="forgot" href="#">Quên mật khẩu?</a>
                </div>
            </div>
            <div class="form-group">
                <input type="submit" class="btn" value="ĐĂNG NHẬP">
<!--                <div class="div">
                    <label>Bạn chưa có tài khoản.</label><a href="register.html"> Đăng kí ngay</a>
                </div>-->
            </div>
        </form>
    </div>
    <script type="text/javascript">
        // get element js
        var username = document.forms["formlogin"]["username"];
        var password = document.forms["formlogin"]["password"];
        var usericon = document.getElementById("span-user");
        var passicon = document.getElementById("span-pass");
        var nameerror = document.getElementById("p-user");
        var passerror = document.getElementById("p-pass");

        // regular expression
        var userRegex = new RegExp("^[A-Za-z0-9\d]{8,20}$");
        var passRegex = new RegExp("^[A-Za-z0-9\d!@#\$%\^&\*]{8,45}");
        // var passStrongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
        // var passMediumRegex = new RegExp("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");
        // var passWeakRegex = new RegExp("(?=.{8,})");
        
        function checkValidtion() {
            var check = true;
            // Validation password
            if(password.value == "") {
                password.focus();

                password.classList.add("error");
                passicon.classList.add("error");

                passerror.style.display = "block";
                passerror.innerHTML = "* Trường này không được để trống";
                check = false;
            } else {
                if (passRegex.test(password.value)) {
                    password.classList.remove("error");
                    passicon.classList.remove("error");

                    passerror.style.display = "none";
                } else {
                    password.focus();

                    password.classList.add("error");
                    passicon.classList.add("error");

                    passerror.style.display = "block";
                    passerror.innerHTML = "(Mật khẩu dài từ 8 đến 45 kí tự, chỉ chứa chữ không dấu, số và kĩ tự đặc biết VD: Abcd1234@)";
                    check = false;
                }
            }
            // Validation username
            if(username.value == "") {
                username.focus();

                username.classList.add("error");
                usericon.classList.add("error");

                nameerror.style.display = "block";
                nameerror.innerHTML = "* Trường này không được để trống";
                check = false;
            } else {
                if (userRegex.test(username.value)) {
                    username.classList.remove("error");
                    usericon.classList.remove("error");

                    nameerror.style.display = "none";
                } else {
                    username.focus();

                    username.classList.add("error");
                    usericon.classList.add("error");

                    nameerror.style.display = "block";
                    nameerror.innerHTML = "(Tên đăng nhập dài từ 8 đến 20, chỉ chứa kĩ tự không dấu và số VD: Abc123456)";
                    check = false;
                }
            }
            if(!check) {
                console.log("false");
                return false;
            }
        }
    </script>
    </body>
</html>