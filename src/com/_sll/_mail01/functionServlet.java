package com._sll._mail01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/function")
public class functionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String cmd1=request.getParameter("cmd");
        if("delete".equals(cmd1)){
           delete(request,response);
            out.print("hello");

        }else{
            out.print("shit");
        }
    }
    public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
            String username="root";
            String pwd="2016013939";
            int id=Integer.valueOf(request.getParameter("id"));
            Connection coon= DriverManager.getConnection(url,username,pwd);
//            Statement stmt=coon.createStatement();
//            HttpSession session = request.getSession();
//            int id=Integer.parseInt((String)session.getAttribute("id"));
            String sql="delete *from user.mail where id=？";
//            ResultSet rs=stmt.executeQuery(sql);
             PreparedStatement ps=coon.prepareStatement(sql);
//            request.getRequestDispatcher("/logo").forward(request,response);
//            response.sendRedirect("mail.jsp");
           ps.setInt("1",mail.getID());
           ps.setString("2",mail.getPost);

            ps.executeLargeUpdate();
            response.sendRedirect("mail.jsp");
             ps.close();
             coon.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
//    public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url="jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
//            String username="root";
//            String pwd="2016013939";
//            int id=Integer.valueOf(request.getParameter("id"));
//            Connection coon= DriverManager.getConnection(url,username,pwd);
////            Statement stmt=coon.createStatement();
////            HttpSession session = request.getSession();
////            int id=Integer.parseInt((String)session.getAttribute("id"));
////            String sql="insert *from user.mail(id,post,get)value(？,？,？)";
////            ResultSet rs=stmt.executeQuery(sql);
//            PreparedStatement ps=coon.prepareStatement(sql);
////            request.getRequestDispatcher("/logo").forward(request,response);
////            response.sendRedirect("mail.jsp");
////            ps.setInt(1,id);
//            int row=ps.executeUpdate();
//            if(row>0){
//                out.print("成功添加了"+row+"条数据");
//            }
//            ps.close();
//            coon.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


