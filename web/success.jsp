<%@ page import="com.mysql.cj.x.protobuf.MysqlxDatatypes" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: 26330
  Date: 2018/12/26
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success-error</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
//  String IDcard=(String)request.getParameter("IDcard");
//  String pwd=(String)request.getParameter("pwd");
//  out.print(IDcard+" 、 ");


    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String pwd = "2016013939";
        Connection conn = DriverManager.getConnection(url,username,pwd);
        Statement stmt=conn.createStatement();
//        String sql="select*from user";

        ResultSet rs=stmt.executeQuery("select*from user");
        while(rs.next()){
            String id=request.getParameter("username1");
            String peoplepwd=request.getParameter("password");
            String id1=rs.getString(1);
            String pwd1 =rs.getString(4);
            String name=rs.getString(2);
//            session.setAttribute("name",name);
//            out.print(id1);
            if(id1.equals(id)&& pwd1.equals(peoplepwd)){
                session.setAttribute("name",name);
                session.setAttribute("id",id);
              request.getRequestDispatcher("/logo").forward(request,response);

//              request.getRequestDispatcher("/logo").forward(request,response);
            }
            else{

                out.print("<script language='javaScript'>alert('账号或密码错误')</script>");
                response.setHeader("refresh","0;url=index.jsp");

            }
        }

    } catch (ClassNotFoundException e) {
        e.printStackTrace();

    } catch (SQLException e) {
        e.printStackTrace();
    }


%>

</body>
</html>
