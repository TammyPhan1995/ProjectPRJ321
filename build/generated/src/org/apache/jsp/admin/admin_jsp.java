package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.html");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_var_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_param_value_name_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_var_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_var_value.release();
    _jspx_tagPool_c_param_value_name_nobody.release();
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"/ProjectPRJ321/css/dashboard.css\">\n");
      out.write("        <script>\n");
      out.write("            function move() {\n");
      out.write("                var elem = document.getElementsByClassName(\"message\");\n");
      out.write("                var op = 0;\n");
      out.write("                var id = setInterval(frame, 100);\n");
      out.write("                function frame() {\n");
      out.write("                    if (op === 1) {\n");
      out.write("                        clearInterval(id);\n");
      out.write("                    } else {\n");
      out.write("                        op = op + 0.1;\n");
      out.write("                        elem.style.opacity =\"1\";\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"move()\">\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <style>\n");
      out.write("            @font-face {\n");
      out.write("                font-family: myMagicFont;\n");
      out.write("                src: url(/ProjectPRJ321/font/Quite_Magical.ttf);\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                margin: 0px;\n");
      out.write("                overflow-x: hidden;\n");
      out.write("            }\n");
      out.write("            #header{\n");
      out.write("                width: 100%;\n");
      out.write("                height: 100px;\n");
      out.write("                background-color:  #7a0099;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                margin: 0px;\n");
      out.write("                padding: 30px;\n");
      out.write("                color: white;\n");
      out.write("                margin-bottom: 100px;\n");
      out.write("            }\n");
      out.write("            #headerImage{\n");
      out.write("                position: absolute;\n");
      out.write("                left: -50px;\n");
      out.write("                bottom: -100px;\n");
      out.write("                position: fixed;\n");
      out.write("                width: 400px;\n");
      out.write("                height:400px;\n");
      out.write("            }\n");
      out.write("            h1{\n");
      out.write("                font-size: 4em;\n");
      out.write("                font-family: myMagicFont;\n");
      out.write("                margin: 0px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            #logoutlink{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 0px;\n");
      out.write("                right: 0px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: white;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 2em;\n");
      out.write("                display: block;\n");
      out.write("                width: 20%;\n");
      out.write("                height: 100px;\n");
      out.write("                text-align: center;\n");
      out.write("                padding-top: 30px;\n");
      out.write("            }\n");
      out.write("            #logoutlink:hover{\n");
      out.write("                opacity: 0.8;\n");
      out.write("            }\n");
      out.write("            #chatBoxImage{\n");
      out.write("                position: absolute;\n");
      out.write("                left: 30px;\n");
      out.write("                bottom: 310px;\n");
      out.write("                position: fixed;\n");
      out.write("                width: 300px;\n");
      out.write("                height:300px;\n");
      out.write("            }\n");
      out.write("            h2{\n");
      out.write("                position: absolute;\n");
      out.write("                left: 80px;\n");
      out.write("                bottom: 500px;\n");
      out.write("                position: fixed;\n");
      out.write("                z-index: 10;\n");
      out.write("            }\n");
      out.write("            h3{\n");
      out.write("                position: absolute;\n");
      out.write("                left: 80px;\n");
      out.write("                bottom: 430px;\n");
      out.write("                position: fixed;\n");
      out.write("                z-index: 10;\n");
      out.write("            }\n");
      out.write("            .message{\n");
      out.write("                opacity: 0;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <h1>RACCOON Traveling</h1>\n");
      out.write("            <a id=\"logoutlink\" href=\"/ProjectPRJ321/LogoutController\">Logout</a>\n");
      out.write("        </div>\n");
      out.write("        <a href=\"/ProjectPRJ321/admin/admin.jsp\" title=\"Click me to back to dashboard\"><img alt=\"raccoon\" id=\"headerImage\" src=\"/ProjectPRJ321/img/logo.png\"/></a>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    <center> \n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <th>User Management</th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><a href=\"/ProjectPRJ321/admin/user_management.jsp\">Search users by full name to delete or update</a></td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <th>Tour Management</th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><a href=\"/ProjectPRJ321/admin/insertTour.jsp\">Add new tour</a></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><a href=\"/ProjectPRJ321/admin/tour_management.jsp\">Search tours by title to delete or update</a></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    ");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    <td><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${deleteOverdueTourLink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Delete passed tours</a></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Booking Management</th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><a href=\"/ProjectPRJ321/admin/booking_management.jsp\" >Search booking by tour's title</a></td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("    </center>\n");
      out.write("    <img class=\"message\" id=\"chatBoxImage\" alt=\"chatBax\" src=\"/ProjectPRJ321/img/chatBox.png\"/>\n");
      out.write("    <h2 class=\"message\">Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("    <h3 class=\"message\">  Please check passed tours <br/>regularly</h3>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setVar("deleteOverdueTourLink");
    _jspx_th_c_url_0.setValue("/AdminMainController");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_url_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_c_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_c_param_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_url_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_0 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_0.setPageContext(_jspx_page_context);
    _jspx_th_c_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_0.setName("action");
    _jspx_th_c_param_0.setValue("TourManagement");
    int _jspx_eval_c_param_0 = _jspx_th_c_param_0.doStartTag();
    if (_jspx_th_c_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
    return false;
  }

  private boolean _jspx_meth_c_param_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_1 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_1.setPageContext(_jspx_page_context);
    _jspx_th_c_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_1.setName("subaction");
    _jspx_th_c_param_1.setValue("CheckPassedTour");
    int _jspx_eval_c_param_1 = _jspx_th_c_param_1.doStartTag();
    if (_jspx_th_c_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
    return false;
  }
}
