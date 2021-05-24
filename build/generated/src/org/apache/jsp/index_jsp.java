package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.Users;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Đăng nhập</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap-4.0.0\\dist\\css\\bootstrap.min.css\">\n");
      out.write("        <script src=\"jquery/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap-4.0.0/dist/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"font-awesome-4.7.0\\css\\font-awesome.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Cookie[] listCookie = request.getCookies();
            String username = "";
            String password = "";
            System.out.println(request.isRequestedSessionIdValid());
            System.out.println(session == null ? true : false);
            if (session == null && !request.isRequestedSessionIdValid()) {
                System.out.println("get session");
                Users sessionUser = (Users) session.getAttribute("SessionUser");
                username = sessionUser.getUsername();
                password = sessionUser.getPassword();
            } else if (listCookie != null) {
                System.out.println("get cookie");
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
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <form name=\"formlogin\" action=\"doLogin\" onsubmit=\"return checkValidtion()\" method=\"POST\">\n");
      out.write("            <img src=\"images/avatar.svg\" class=\"w-50 p-3\">\n");
      out.write("            <h2 class=\"title\">Xin chào</h2>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <div class=\"form-group input-icons col-md-12\">\n");
      out.write("                    <label for=\"username\">Tên đăng nhập</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"username\"\n");
      out.write("                           placeholder=\"Nhập tên đăng nhập\"  value=\"");
out.print(username); 
      out.write("\">\n");
      out.write("                    <span id=\"span-user\" class=\"fa fa-user fa-lg\"></span>\n");
      out.write("                    <p id=\"p-user\" class=\"error-user\"></p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group input-icons col-md-12\">\n");
      out.write("                    <label for=\"password\">Mật khẩu</label>\n");
      out.write("                    <input type=\"password\" class=\"form-control\" name=\"password\" \n");
      out.write("                           placeholder=\"Nhập mật khẩu\" value=\"");
out.print(password); 
      out.write("\">\n");
      out.write("                    <span id=\"span-pass\" class=\"fa fa-lock fa-lg\"></span>\n");
      out.write("                    <p id=\"p-pass\" class=\"error-pass\"></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"remember\">Nhớ tài khoản của tôi</label>\n");
      out.write("                    <input type=\"checkbox\" name=\"remember\" id=\"remember\" value=\"remember\" checked>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-2\"></div>\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <a class=\"forgot\" href=\"#\">Quên mật khẩu?</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <input type=\"submit\" class=\"btn\" value=\"ĐĂNG NHẬP\">\n");
      out.write("<!--                <div class=\"div\">\n");
      out.write("                    <label>Bạn chưa có tài khoản.</label><a href=\"register.html\"> Đăng kí ngay</a>\n");
      out.write("                </div>-->\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        // get element js\n");
      out.write("        var username = document.forms[\"formlogin\"][\"username\"];\n");
      out.write("        var password = document.forms[\"formlogin\"][\"password\"];\n");
      out.write("        var usericon = document.getElementById(\"span-user\");\n");
      out.write("        var passicon = document.getElementById(\"span-pass\");\n");
      out.write("        var nameerror = document.getElementById(\"p-user\");\n");
      out.write("        var passerror = document.getElementById(\"p-pass\");\n");
      out.write("\n");
      out.write("        // regular expression\n");
      out.write("        var userRegex = new RegExp(\"^[A-Za-z0-9\\d]{8,20}$\");\n");
      out.write("        var passRegex = new RegExp(\"^[A-Za-z0-9\\d!@#$%\\^&\\*]{8,45}\");\n");
      out.write("        // var passStrongRegex = new RegExp(\"^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%\\^&\\*])(?=.{8,})\");\n");
      out.write("        // var passMediumRegex = new RegExp(\"^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})\");\n");
      out.write("        // var passWeakRegex = new RegExp(\"(?=.{8,})\");\n");
      out.write("        \n");
      out.write("        function checkValidtion() {\n");
      out.write("            var check = true;\n");
      out.write("            // Validation password\n");
      out.write("            if(password.value == \"\") {\n");
      out.write("                password.focus();\n");
      out.write("\n");
      out.write("                password.classList.add(\"error\");\n");
      out.write("                passicon.classList.add(\"error\");\n");
      out.write("\n");
      out.write("                passerror.style.display = \"block\";\n");
      out.write("                passerror.innerHTML = \"* Trường này không được để trống\";\n");
      out.write("                check = false;\n");
      out.write("            } else {\n");
      out.write("                if (passRegex.test(password.value)) {\n");
      out.write("                    password.classList.remove(\"error\");\n");
      out.write("                    passicon.classList.remove(\"error\");\n");
      out.write("\n");
      out.write("                    passerror.style.display = \"none\";\n");
      out.write("                } else {\n");
      out.write("                    password.focus();\n");
      out.write("\n");
      out.write("                    password.classList.add(\"error\");\n");
      out.write("                    passicon.classList.add(\"error\");\n");
      out.write("\n");
      out.write("                    passerror.style.display = \"block\";\n");
      out.write("                    passerror.innerHTML = \"(Mật khẩu dài từ 8 đến 45 kí tự, chỉ chứa chữ không dấu, số và kĩ tự đặc biết VD: Abcd1234@)\";\n");
      out.write("                    check = false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            // Validation username\n");
      out.write("            if(username.value == \"\") {\n");
      out.write("                username.focus();\n");
      out.write("\n");
      out.write("                username.classList.add(\"error\");\n");
      out.write("                usericon.classList.add(\"error\");\n");
      out.write("\n");
      out.write("                nameerror.style.display = \"block\";\n");
      out.write("                nameerror.innerHTML = \"* Trường này không được để trống\";\n");
      out.write("                check = false;\n");
      out.write("            } else {\n");
      out.write("                if (userRegex.test(username.value)) {\n");
      out.write("                    username.classList.remove(\"error\");\n");
      out.write("                    usericon.classList.remove(\"error\");\n");
      out.write("\n");
      out.write("                    nameerror.style.display = \"none\";\n");
      out.write("                } else {\n");
      out.write("                    username.focus();\n");
      out.write("\n");
      out.write("                    username.classList.add(\"error\");\n");
      out.write("                    usericon.classList.add(\"error\");\n");
      out.write("\n");
      out.write("                    nameerror.style.display = \"block\";\n");
      out.write("                    nameerror.innerHTML = \"(Tên đăng nhập dài từ 8 đến 20, chỉ chứa kĩ tự không dấu và số VD: Abc123456)\";\n");
      out.write("                    check = false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            if(!check) {\n");
      out.write("                console.log(\"false\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
