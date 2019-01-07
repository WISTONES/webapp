<%@ page import="java.util.List" %>
<%@ page import="com._sll._mail01.people" %>
<%@ page import="com._sll._mail01.mail" %><%--
  Created by IntelliJ IDEA.
  User: 26330
  Date: 2018/12/23
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
欢迎您来到查询中心<br>
<%--<h2><a href=function?cmd=add&&id=<%=mail.getId()%>寄快递</a></h2>--%>
<table align="center" with="450" border="1">
    <tr>
        <td align="center" colspan="5">
            <h3>用户信息</h3>
    </tr>
    <tr align="center">
        <td><b>id</b></td>
        <td><b>post</b></td>
        <td><b>get</b></td>
        <td><b>function</b></td>
    </tr>
    <%
      List<mail> list=(List<mail>)request.getAttribute("list");
      if(list==null||list.size()<1){
          out.print("没有数据！！！");
      }else{
          for(mail mail:list){
              %>
    <tr align="center">
        <td><%=mail.getId() %></td>
        <td><%=mail.getPost()%></td>
        <td><%=mail.getGet()%></td>
        <td><a href="/function?cmd=delete&&id=<%=mail.getId()%>">收快递</a></td>
        <td><a href="/function?cmd=add&&id=<%=mail.getId()%>">寄快递</a></td>
    </tr>
    <%
          }
      }
    %>

</table>
</body>
</html>
