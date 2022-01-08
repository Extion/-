package com.servlet.UserServlet;

import com.alibaba.fastjson.JSONObject;
import com.pojo.User;
import com.service.ServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
    ServiceImp service = new ServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        //转换JSON
        User obj = JSONObject.parseObject(readLine, User.class);
//        System.out.println(obj.getUsername());
//        System.out.println(obj.getPassword());
        //执行方法
        User user = service.login(obj.getUsername(), obj.getPassword());
        //判断
        if (user!=null){
            //登录成功
            response.getWriter().write("success");
        }else {
            //登录失败
            response.getWriter().write("failure");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
