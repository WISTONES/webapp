package com._sll._mail01;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/logo")
public class logoiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
//        HttpSession session = request.getSession();
//        int id=(int)session.getAttribute("id");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
            String username="root";
            String pwd="2016013939";
            Connection coon= DriverManager.getConnection(url,username,pwd);
//            if(coon!=null){
//            }
            Statement stmt=coon.createStatement();
            HttpSession session = request.getSession();
            int id=Integer.parseInt((String)session.getAttribute("id"));
//            String sql="select*from user.mail";
            String sql="select*from user.mail where id='"+id+"'";
            ResultSet rs=stmt.executeQuery(sql);
            List<mail> list= new ArrayList<mail>();
            while(rs.next()){
                mail mail=new mail();
                mail.setId(rs.getInt("id"));
                mail.setPost(rs.getString("post"));
                mail.setGet(rs.getString("get"));
                list.add(mail);
            }
//            String cmd=request.getParameter("cmd");
//            while(cmd==null){
//                if("delete".equals(cmd)){
//                    request.getRequestDispatcher("logo.jsp").forward(request,response);
//                }
//            }
            request.setAttribute("list",list);
            request.getRequestDispatcher("mail.jsp").forward(request,response);
            rs.close();
            stmt.close();
            coon.close();
        }catch (ClassNotFoundException e){
            System.out.print(e);
            e.printStackTrace();
        }
        catch (SQLException e){
            System.out.print(e);
            e.printStackTrace();
        }
//        request.getRequestDispatcher("/mail.jsp").forward(request,response);
//        response.sendRedirect("mail.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            doPost(request,response);
    }


    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
//        req.setCharacterEncoding("utf-8");
//        res.setContentType("text/html;charset=utf-8");
//        PrintWriter out=res.getWriter();
//        try {
//            Class.forName("com.mysql.jdbc.cj.Driver");
//            String url="jdbc:mysql://localhost:3306/user";
//            String username="root";
//            String pwd="2016013939";
//            Connection coon= DriverManager.getConnection(url,username,pwd);
////            if(coon!=null){
////            }
//            Statement stmt=coon.createStatement();
//            String sql="select*from user";
//            ResultSet rs=stmt.executeQuery(sql);
//            List<people> list=new ArrayList<people>();
//            while(rs.next()){
//                people people=new people();
//                people.setId(rs.getInt("id"));
//                people.setName(rs.getString("name"));
//                people.setSex(rs.getString("sex"));
//                list.add(people);
//            }
//            req.setAttribute("list",list);
//            rs.close();
//            stmt.close();
//            coon.close();
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        req.getRequestDispatcher("/mail.jsp").forward(req,res);
////        String id=req.getParameter("username");
////        String pwd=req.getParameter("password");
////        if(id.equals("sll")&&pwd.equals("sll")){
////            req.getRequestDispatcher("/mail.jsp").forward(req,res);
////        }
////        else{
////            out.print("账号或密码输入错误！！！请重新输入\t");
////        }
////        //req.getRequestDispatcher("/mail.jsp").forward(req,res);
////    }
}}
